package com.example.detalhes.consumer;

import com.example.detalhes.domain.Cliente;
import com.example.detalhes.domain.Local;
import com.example.detalhes.domain.Multa;
import com.example.detalhes.domain.MultaEnriquecida;
import com.example.detalhes.domain.Veiculo;
import com.example.detalhes.producer.MultaEnriquecidaProducer;
import com.example.detalhes.service.DataCacheService;
import com.example.detalhes.util.Colors;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.logging.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

/**
 * Esta classe é usada para consumir mensagens de multa de um topico
 * Podem criar quantos KafkaListeners quiserem
 */

@Component
public class FilterConsumer {

    private static final Logger log = Logger.getLogger(
        FilterConsumer.class.getName()
    );

    private final DataCacheService dataCacheService;
    private final MultaEnriquecidaProducer multaEnriquecidaProducer;

    public FilterConsumer(
        DataCacheService dataCacheService,
        MultaEnriquecidaProducer multaEnriquecidaProducer
    ) {
        this.dataCacheService = dataCacheService;
        this.multaEnriquecidaProducer = multaEnriquecidaProducer;
    }

    /*
     * Este método é chamado quando uma mensagem é recebida no tópico "detalhes-multa"
     * o ack.acknowledge() é chamado para confirmar que a mensagem foi processada com sucesso
     * se náo for chamado o kafka não vai alterar o offset da mensagem, ou seja no proximo evento ele vai usar a mensagem antiga
     */
    @KafkaListener(topics = "detalhes-multa", groupId = "detalhes-group")
    public void consumeMulta(Multa message, Acknowledgment ack) {
        try {
            log.info("\u001B[32mReceived message: " + message + "\u001B[0m");
            ack.acknowledge();
            processMulta(message);
        } catch (Exception e) {
            log.severe(
                "\u001B[30mError processing message: " +
                    e.getMessage() +
                    "\u001B[0m"
            );
        }
    }

    public void processMulta(Multa multa) {
        ObjectMapper mapper = new ObjectMapper();

        Veiculo veiculo = new Veiculo();
        Cliente cliente = new Cliente();
        Local local = new Local();
        MultaEnriquecida mEnriquecida = new MultaEnriquecida();

        if (multa == null) {
            log.severe("\u001B[30mReceived null message\u001B[0m");
            return;
        }

        if (
            multa.getIdMulta() == null ||
            multa.getMatricula() == null ||
            multa.getLugarId() == null ||
            multa.getZonaTarifaria() == null
        ) {
            log.severe("Campos em falta");
            return;
        }

        veiculo = dataCacheService.getVeiculoByMatricula(multa.getMatricula());
        cliente = veiculo != null
            ? dataCacheService.getClienteById(veiculo.getIdCliente())
            : null;
        local = dataCacheService.getLocalByNomeZona(multa.getZonaTarifaria());

        if (veiculo == null) {
            log.warning("Veículo não encontrado");
            log.warning("A tentar novamente");
            try {
                veiculo = dataCacheService.getVeiculoByMatriculaReload(
                    multa.getMatricula()
                );
            } catch (Exception e) {
                log.severe(
                    "\u001B[30mErro, Veículo não encontrado: " +
                        e.getMessage() +
                        "\u001B[0m"
                );
            }
        }

        if (cliente == null) {
            log.warning("Cliente não encontrado");
            log.warning("A tentar novamente");
            try {
                cliente = (veiculo != null)
                    ? dataCacheService.getClienteById(veiculo.getIdCliente())
                    : null;
            } catch (Exception e) {
                log.severe(
                    "\u001B[30mErro, Cliente não encontrado: " +
                        e.getMessage() +
                        "\u001B[0m"
                );
            }
        }

        if (local == null) {
            log.warning("Local não encontrado");
            log.warning("A tentar novamente");
            try {
                dataCacheService.getLocalByNomeReload(multa.getZonaTarifaria());
            } catch (Exception e) {
                log.severe(
                    "\u001B[30mErro, Cliente não encontrado: " +
                        e.getMessage() +
                        "\u001B[0m"
                );
            }
        }

        mEnriquecida.setMulta(multa);
        mEnriquecida.setVeiculo(veiculo);
        mEnriquecida.setCliente(cliente);
        mEnriquecida.setLocal(local);

        if (
            mEnriquecida.getMulta() != null &&
            mEnriquecida.getVeiculo() != null &&
            mEnriquecida.getCliente() != null &&
            mEnriquecida.getLocal() != null
        ) {
            multaEnriquecidaProducer.sendMultaEnriquecida(
                mEnriquecida.getId(),
                mEnriquecida
            );
        }

        try {
            String jsonPretty = mapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(mEnriquecida);

            log.info(Colors.GREEN_BOLD + jsonPretty + Colors.RESET);
        } catch (Exception e) {
            log.severe(
                "\u001B[30mErro ao serializar mensagem: " +
                    e.getMessage() +
                    "\u001B[0m"
            );
        }
    }
}
