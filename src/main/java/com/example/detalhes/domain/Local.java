package com.example.detalhes.domain;

public class Local {

    private String zonaId;
    private String nomeZona;
    private int tempoGratisMinutos;
    private double precoHora;
    private double valorCoimaBase;

    // Construtor vazio
    public Local() {}

    // Construtor com parâmetros
    public Local(
        String zonaId,
        String nomeZona,
        int tempoGratisMinutos,
        double precoHora,
        double valorCoimaBase
    ) {
        this.zonaId = zonaId;
        this.nomeZona = nomeZona;
        this.tempoGratisMinutos = tempoGratisMinutos;
        this.precoHora = precoHora;
        this.valorCoimaBase = valorCoimaBase;
    }

    // Getters e Setters
    public String getZonaId() {
        return zonaId;
    }

    public void setZonaId(String zonaId) {
        this.zonaId = zonaId;
    }

    public String getNomeZona() {
        return nomeZona;
    }

    public void setNomeZona(String nomeZona) {
        this.nomeZona = nomeZona;
    }

    public int getTempoGratisMinutos() {
        return tempoGratisMinutos;
    }

    public void setTempoGratisMinutos(int tempoGratisMinutos) {
        this.tempoGratisMinutos = tempoGratisMinutos;
    }

    public double getPrecoHora() {
        return precoHora;
    }

    public void setPrecoHora(double precoHora) {
        this.precoHora = precoHora;
    }

    public double getValorCoimaBase() {
        return valorCoimaBase;
    }

    public void setValorCoimaBase(double valorCoimaBase) {
        this.valorCoimaBase = valorCoimaBase;
    }

    @Override
    public String toString() {
        return (
            "Local{" +
            "zonaId='" +
            zonaId +
            '\'' +
            ", nomeZona='" +
            nomeZona +
            '\'' +
            ", tempoGratisMinutos=" +
            tempoGratisMinutos +
            ", precoHora=" +
            precoHora +
            ", valorCoimaBase=" +
            valorCoimaBase +
            '}'
        );
    }
}
