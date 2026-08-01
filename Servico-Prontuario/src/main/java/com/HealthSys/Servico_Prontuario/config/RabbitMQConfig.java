package com.HealthSys.Servico_Prontuario.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String EXCHANGE_NOTIFICACOES = "healthsys.notificacoes";
    public static final String QUEUE_CONSULTA_CRIADA = "notificacoes.consulta.criada";
    public static final String ROUNTING_KEY_CONSULTA_CRIADA = "consulta.criada";

    @Bean
    public DirectExchange notificacoesExchange () {
        return new DirectExchange(EXCHANGE_NOTIFICACOES);
    }

    @Bean
    public Queue consultaCriadaQueue () {
        return new Queue(QUEUE_CONSULTA_CRIADA, true);
    }

    @Bean
    public Binding consultaCriadaBinding () {
        return BindingBuilder
                .bind(consultaCriadaQueue())
                .to(notificacoesExchange())
                .with(ROUNTING_KEY_CONSULTA_CRIADA);
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory, MessageConverter jsonMessageConverter) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(jsonMessageConverter);
        return template;
    }

}
