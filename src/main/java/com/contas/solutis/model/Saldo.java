package com.contas.solutis.model;

import java.util.List;

public class Saldo {
    private float saldo;
    List<Conta> contas;

    public Saldo() {

    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }

    public Saldo(float saldo, List<Conta> contas) {
        this.saldo = saldo;
        this.contas = contas;
    }
}
