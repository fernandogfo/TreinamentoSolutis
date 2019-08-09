package com.contas.solutis.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="contas")
public class Conta implements Serializable {
    public Conta(@NotNull String nome, @NotNull String tipo, @NotNull float valor,
                 @NotNull int parcelas, @NotNull Boolean permanente, @NotNull Date dataVenc) {
        this.nome = nome;
        this.tipo = tipo;
        this.valor = valor;
        this.parcelas = parcelas;
        this.permanente = permanente;
        this.dataVenc = dataVenc;

    }

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull(message = "Data é uma informação obrigatória.")
    private String nome;

    @NotNull(message = "Data é uma informação obrigatória.")
    private String tipo;

    @NotNull(message = "Data é uma informação obrigatória.")
    private float valor;

    @NotNull(message = "Data é uma informação obrigatória.")
    private int parcelas;

    @NotNull(message = "Data é uma informação obrigatória.")
    private Boolean permanente;

    @NotNull(message = "Data é uma informação obrigatória.")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataVenc;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataPagamento;


    private Boolean pago = false;

    public Conta() {
    }

    public Conta(String nome) {
        super();
        this.nome = nome;
    }

    public Boolean getPago() {
        return pago;
    }

    public void setPago(Boolean pago) {
        this.pago = pago;
    }

    public Conta(Long id) {
        super();
        this.id = id;
    }

    public Boolean getPermanente() {
        return permanente;
    }

    public void setPermanente(Boolean permanente) {
        this.permanente = permanente;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public float getValor() {
        return this.valor;
    }
    public void setValor(float valor) {
        this.valor = valor;
    }
    public int getParcelas() {
        return parcelas;
    }
    public void setParcelas(int parcelas) {
        this.parcelas = parcelas;
    }

    public Date getDataVenc() {
        return dataVenc;
    }

    public void setDataVenc(Date dataVenc) {
        this.dataVenc = dataVenc;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

//    @Override
//    public String toString() {
//        return "Conta [id=" + id + ", nome=" + nome + ", parcelas=" + parcelas +  ", dataVenc=" + dataVenc +
//                ", tipo=" + tipo + ", valor=" + valor   +  ", permanente=" + permanente + ", dataPagamento=" + dataPagamento + "]";
//    }
}
