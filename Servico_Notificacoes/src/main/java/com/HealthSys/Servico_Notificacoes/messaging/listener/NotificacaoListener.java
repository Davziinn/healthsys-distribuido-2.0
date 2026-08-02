package com.HealthSys.Servico_Notificacoes.messaging.listener;

import com.HealthSys.Servico_Notificacoes.messaging.event.ConsultaCriadaEvent;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Slf4j
public class NotificacaoListener {

    @RabbitListener(queues = "notificacoes.consulta.criada", containerFactory = "manualAckContainerFactory")
    public void receberConsultaCriada (ConsultaCriadaEvent event, Channel channel, @Header (AmqpHeaders.DELIVERY_TAG) long deliveryTag) throws IOException {
        try {
            log.info("Notificação: nova consulta registrada - paciente {} com {} em {}", event.idPaciente(), event.nomeMedico(), event.dataConsulta());
            // aqui, no futuro, entraria o envio de verdade (email, SMS, push...)
            // por agora, o log já prova que o consumidor está funcionando

            channel.basicAck(deliveryTag, false);
        } catch (Exception e) {
            log.error("Falha ao processar notificação, enviando para DLQ: {}", e.getMessage());
            channel.basicNack(deliveryTag, false, false);
        }


    }
}
