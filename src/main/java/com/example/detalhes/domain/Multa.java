package com.example.detalhes.domain;

import com.example.detalhes.base.MensagemBase;
import java.util.Date;

/**
 * Esta classe é usada para representar o tipo de dados recebidos do kafka
 */
public class Multa extends MensagemBase {

    private String idMulta;
    private String matricula;
    private String lugarId;
    private String zonaTarifaria;
    private Date dataHoraDeteccao;
    private String razaoPrimariaMulta;
    private Float confianca;
    private String idFiscal;
    private String origem;
    private String tipoDeteccao;
    private String idEvidenciaPrimaria;

    public Multa() {
        this.idMulta = "";
        this.matricula = "";
        this.lugarId = "";
        this.zonaTarifaria = "";
        this.dataHoraDeteccao = new Date();
        this.razaoPrimariaMulta = "";
        this.confianca = 0.0f;
        this.idFiscal = "";
        this.origem = "";
        this.tipoDeteccao = "";
        this.idEvidenciaPrimaria = "";
    }

    public Multa(
        String idMulta,
        String matricula,
        String lugarId,
        String zonaTarifaria,
        Date dataHoraDeteccao,
        String razaoPrimariaMulta,
        Float confianca,
        String idFiscal,
        String origem,
        String tipoDeteccao,
        String idEvidenciaPrimaria
    ) {
        this.idMulta = idMulta;
        this.matricula = matricula;
        this.lugarId = lugarId;
        this.zonaTarifaria = zonaTarifaria;
        this.dataHoraDeteccao = dataHoraDeteccao;
        this.razaoPrimariaMulta = razaoPrimariaMulta;
        this.confianca = confianca;
        this.idFiscal = idFiscal;
        this.origem = origem;
        this.tipoDeteccao = tipoDeteccao;
        this.idEvidenciaPrimaria = idEvidenciaPrimaria;
    }

    @Override
    public String toString() {
        return (
            "Multa{" +
            "idMulta=" +
            idMulta +
            ", matricula='" +
            matricula +
            '\'' +
            ", lugarId='" +
            lugarId +
            '\'' +
            ", zonaTarifaria='" +
            zonaTarifaria +
            '\'' +
            ", dataHoraDeteccao=" +
            dataHoraDeteccao +
            ", razaoPrimariaMulta='" +
            razaoPrimariaMulta +
            '\'' +
            ", confianca=" +
            confianca +
            ", idFiscal='" +
            idFiscal +
            '\'' +
            ", origem='" +
            origem +
            '\'' +
            ", tipoDeteccao='" +
            tipoDeteccao +
            '\'' +
            ", idEvidenciaPrimaria='" +
            idEvidenciaPrimaria +
            '\'' +
            '}'
        );
    }

    public String getIdMulta() {
        return idMulta;
    }

    public void setIdMulta(String idMulta) {
        this.idMulta = idMulta;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getLugarId() {
        return lugarId;
    }

    public void setLugarId(String lugarId) {
        this.lugarId = lugarId;
    }

    public String getZonaTarifaria() {
        return zonaTarifaria;
    }

    public void setZonaTarifaria(String zonaTarifaria) {
        this.zonaTarifaria = zonaTarifaria;
    }

    public Date getDataHoraDeteccao() {
        return dataHoraDeteccao;
    }

    public void setDataHoraDeteccao(Date dataHoraDeteccao) {
        this.dataHoraDeteccao = dataHoraDeteccao;
    }

    public String getRazaoPrimariaMulta() {
        return razaoPrimariaMulta;
    }

    public void setRazaoPrimariaMulta(String razaoPrimariaMulta) {
        this.razaoPrimariaMulta = razaoPrimariaMulta;
    }

    public Float getConfianca() {
        return confianca;
    }

    public void setConfianca(Float confianca) {
        this.confianca = confianca;
    }

    public String getIdFiscal() {
        return idFiscal;
    }

    public void setIdFiscal(String idFiscal) {
        this.idFiscal = idFiscal;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getTipoDeteccao() {
        return tipoDeteccao;
    }

    public void setTipoDeteccao(String tipoDeteccao) {
        this.tipoDeteccao = tipoDeteccao;
    }

    public String getIdEvidenciaPrimaria() {
        return idEvidenciaPrimaria;
    }

    public void setIdEvidenciaPrimaria(String idEvidenciaPrimaria) {
        this.idEvidenciaPrimaria = idEvidenciaPrimaria;
    }
}
