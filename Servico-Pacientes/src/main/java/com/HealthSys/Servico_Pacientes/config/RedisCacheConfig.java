package com.HealthSys.Servico_Pacientes.config;

import com.HealthSys.Servico_Pacientes.model.Paciente;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.CachingConfigurer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;

@Slf4j
@Configuration
@EnableCaching
public class RedisCacheConfig implements CachingConfigurer {

    @Value("${cache.pacientes.ttl-minutos}")
    private long ttlMinutos;

    @Bean
    public RedisCacheManager cacheManager (RedisConnectionFactory connectionFactory) {
        ObjectMapper mapper = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        RedisCacheConfiguration pacienteConfig = RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofMinutes(ttlMinutos))
                .disableCachingNullValues()
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()))
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(
                        new Jackson2JsonRedisSerializer<>(mapper, Paciente.class)));

        return RedisCacheManager
                .builder(connectionFactory)
                .withCacheConfiguration("pacientes", pacienteConfig)
                .build();
    }

    @Override
    public CacheErrorHandler errorHandler () {
        return new CacheErrorHandler() {
            @Override
            public void handleCacheGetError(RuntimeException exception, Cache cache, Object key) {
                log.warn("Redis indisponível ao LER cache '{}' chave '{}': '{}'", cache.getName(), key, exception.getMessage());
            }

            @Override
            public void handleCachePutError(RuntimeException exception, Cache cache, Object key, @Nullable Object value) {
                log.warn("Redis indisponível ao GRAVAR cache '{}' chave '{}': '{}'", cache.getName(), key, exception.getMessage());
            }

            @Override
            public void handleCacheEvictError(RuntimeException exception, Cache cache, Object key) {
                log.warn("Redis indisponível ao INVALIDAR cache '{}' chave '{}': '{}'", cache.getName(), key, exception.getMessage());
            }

            @Override
            public void handleCacheClearError(RuntimeException exception, Cache cache) {
                log.warn("Redis indisponível ao LIMPAR cache '{}': {}", cache.getName(), exception.getMessage());
            }
        };
    }
}
