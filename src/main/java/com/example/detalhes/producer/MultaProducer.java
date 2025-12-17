package com.example.detalhes.producer;

import com.example.detalhes.domain.Multa;
import java.time.Instant;
import java.util.Date;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/*
 * Esta classe é usada para enviar mensagens de multa para o tópico detalhes-multa
 * Classe de Teste, basta trocar o Profile no ficheiro application.properties para nao aparecer
 */

@Component
@Profile("test")
public class MultaProducer implements CommandLineRunner {

    private final MultaTesteProducer producer;

    public MultaProducer(MultaTesteProducer producer) {
        this.producer = producer;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Sending test message via CommandLineRunner");

        Date dataHoraDeteccao = Date.from(
            Instant.parse("2025-12-15T20:37:14Z")
        );
        Multa multa = new Multa(
            "0", // idMulta
            "ABC1234", // matricula
            "A", // lugarId
            "ZONA_A", // zonaTarifaria
            dataHoraDeteccao, // dataHoraDeteccao
            "ESTACIONAMENTO_PROIBIDO", // razaoPrimariaMulta
            0.95f, // confianca
            "FISCAL_1", // idFiscal
            "APP_FISCAL", // origem
            "OCR", // tipoDeteccao
            null // idEvidenciaPrimaria
        );
        /*
         * O primeiro parametro é o nome do topico para onde a mensagem será enviada
         * O segundo parametro é a key da mensagem, se usarmos mais que uma particao é necessário uma key
         */
        producer.sendMulta("detalhes-multa", "0", multa);
    }
}
