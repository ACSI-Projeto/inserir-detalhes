package com.example.detalhes.domain;

import com.example.detalhes.base.MensagemBase;
import com.example.detalhes.util.IdGenerator;

public class Cliente extends MensagemBase {

    private long idCliente;
    private String nome;
    private String email;
    private boolean PasseResidente;
    private String validadePass;
    private boolean Insencao;
    private String tipoInsencao; //Podemos trocar por um enum depois de savermos os tipos de insenção

    public Cliente() {
        this.idCliente = IdGenerator.nextClienteId();
        this.nome = "";
        this.email = "";
        this.PasseResidente = false;
        this.validadePass = "";
        this.Insencao = false;
        this.tipoInsencao = "";
    }

    public Cliente(
        String nome,
        String email,
        boolean PasseResidente,
        String validadePass,
        boolean Insencao,
        String tipoInsencao
    ) {
        this.idCliente = IdGenerator.nextClienteId();
        this.nome = nome;
        this.email = email;
        this.PasseResidente = PasseResidente;
        this.validadePass = validadePass;
        this.Insencao = Insencao;
        this.tipoInsencao = tipoInsencao;
    }

    public long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getValidadePass() {
        return validadePass;
    }

    public String getTipoInsencao() {
        return tipoInsencao;
    }

    public boolean isPasseResidente() {
        return PasseResidente;
    }

    public boolean isInsencao() {
        return Insencao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setValidadePass(String validadePass) {
        this.validadePass = validadePass;
    }

    public void setTipoInsencao(String tipoInsencao) {
        this.tipoInsencao = tipoInsencao;
    }

    public void setPasseResidente(boolean passeResidente) {
        PasseResidente = passeResidente;
    }

    public void setInsencao(boolean insencao) {
        Insencao = insencao;
    }
}
