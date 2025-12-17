package com.example.detalhes.producer;

import com.example.detalhes.domain.MultaEnriquecida;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * Esta classe é usada para produzir mensagens de multa em um topico
 * Podem criar quantos metodos quiserem
 * Podem chamar esses metodos ou numa classe teste ou quando receberem uma mensagem no consumer
 */
@Component
public class MultaEnriquecidaProducer {

    private final KafkaTemplate<String, MultaEnriquecida> kafkaTemplate;

    public MultaEnriquecidaProducer(
        KafkaTemplate<String, MultaEnriquecida> kafkaTemplate
    ) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMultaEnriquecida(Long key, MultaEnriquecida multa) {
        kafkaTemplate.send("multa-enriquecida", String.valueOf(key), multa);
    }
}
