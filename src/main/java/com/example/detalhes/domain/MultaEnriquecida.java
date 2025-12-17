package com.example.detalhes.domain;

import com.example.detalhes.base.MensagemBase;
import java.util.concurrent.atomic.AtomicLong;

public class MultaEnriquecida extends MensagemBase {

    private static final AtomicLong ID_GENERATOR = new AtomicLong(0);

    private long id;
    private Multa multa;
    private Cliente cliente;
    private Veiculo veiculo;
    private Local local;

    public MultaEnriquecida() {
        this.id = ID_GENERATOR.incrementAndGet();
        this.multa = new Multa();
        this.cliente = new Cliente();
        this.veiculo = new Veiculo();
        this.local = new Local();
    }

    public MultaEnriquecida(
        Multa multa,
        Cliente cliente,
        Veiculo veiculo,
        Local local
    ) {
        this.id = ID_GENERATOR.incrementAndGet();
        this.multa = multa;
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.local = local;
    }

    public long getId() {
        return id;
    }

    public Multa getMulta() {
        return multa;
    }

    public void setMulta(Multa multa) {
        this.multa = multa;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }
}
