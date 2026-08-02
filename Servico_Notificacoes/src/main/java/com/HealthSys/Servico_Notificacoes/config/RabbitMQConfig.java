package com.HealthSys.Servico_Notificacoes.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.support.converter.Jackson2JavaTypeMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQConfig {

    public static final String QUEUE_CONSULTA_CRIADA = "notificacoes.consulta.criada";
    public static final String DLX_NOTIFICACOES = "healthsys.notificacoes.dlx";
    public static final String DLQ_CONSULTA_CRIADA = "notificacoes.consulta.criada.dlq";

    @Bean
    public Queue queueConsultaCriada () {
        return QueueBuilder
                .durable(QUEUE_CONSULTA_CRIADA)
                .withArgument("x-dead-letter-exchange", DLX_NOTIFICACOES)
                .build();
    }

    @Bean
    public DirectExchange dlxExchange () {
        return new DirectExchange(DLX_NOTIFICACOES);
    }

    @Bean
    public Queue dlqQueue () {
        return QueueBuilder
                .durable(DLQ_CONSULTA_CRIADA)
                .build();
    }

    @Bean
    public Binding dlqBinding () {
        return BindingBuilder.bind(dlqQueue()).to(dlxExchange()).with("");
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        Jackson2JsonMessageConverter converter = new Jackson2JsonMessageConverter();
        converter.setTypePrecedence(Jackson2JavaTypeMapper.TypePrecedence.INFERRED);
        return converter;
    }

    @Bean
    public SimpleRabbitListenerContainerFactory manualAckContainerFactory (ConnectionFactory connectionFactory, MessageConverter jsonMessageConverter) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setMessageConverter(jsonMessageConverter);
        factory.setAcknowledgeMode(AcknowledgeMode.MANUAL);
        return factory;
    }
}
