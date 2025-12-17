package com.example.detalhes.producer;

import com.example.detalhes.domain.Multa;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * Esta classe é usada para produzir mensagens de multa em um topico
 * Podem criar quantos metodos quiserem
 * Podem chamar esses metodos ou numa classe teste ou quando receberem uma mensagem no consumer
 */
@Component
public class MultaTesteProducer {

    private final KafkaTemplate<String, Multa> kafkaTemplate;

    public MultaTesteProducer(KafkaTemplate<String, Multa> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMulta(String topic, String key, Multa multa) {
        kafkaTemplate.send(topic, key, multa);
    }
}
