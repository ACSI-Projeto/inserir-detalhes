package com.example.detalhes.domain;

import com.example.detalhes.base.MensagemBase;

public class Veiculo extends MensagemBase {

    private int idVeiculo;
    private Long idCliente;
    private String matricula;
    private String tipoVeiculo;
    private String marca;
    private String modelo;
    private String cor;

    public Veiculo() {
        this.idVeiculo = 0;
        this.idCliente = 0L;
        this.matricula = "";
        this.tipoVeiculo = "";
        this.marca = "";
        this.modelo = "";
        this.cor = "";
    }

    public Veiculo(
        int idVeiculo,
        Long idCliente,
        String matricula,
        String tipoVeiculo,
        String marca,
        String modelo,
        String cor
    ) {
        this.idVeiculo = idVeiculo;
        this.idCliente = idCliente;
        this.matricula = matricula;
        this.tipoVeiculo = tipoVeiculo;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
    }

    public int getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(int idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getTipoVeiculo() {
        return tipoVeiculo;
    }

    public void setTipoVeiculo(String tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
}
