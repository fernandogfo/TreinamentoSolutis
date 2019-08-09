package com.contas.solutis.service;

import com.contas.solutis.dao.ContasRepositorio;
import com.contas.solutis.model.Conta;
import com.contas.solutis.model.Saldo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ContaService {

    private ContasRepositorio dao;

    public ContaService(@Autowired ContasRepositorio dao) {
        this.dao = dao;
    }

    private Date adicionarMes(Date date, int i) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, i);
        return cal.getTime();}
//  Adiciona conta, com ou sem parcela
    public void persistOrMerge(Conta conta) {

        if(conta.getParcelas()>1) {

            List <Conta>objectList = new ArrayList<>();

                for (int i = 0; i < conta.getParcelas(); i++) {

                    conta.setDataVenc(adicionarMes(conta.getDataVenc(), 1));
                    objectList.add(new Conta(conta.getNome(), conta.getTipo(),
                            conta.getValor() / conta.getParcelas(), conta.getParcelas(),
                            conta.getPermanente(), conta.getDataVenc()));
                }
            this.dao.saveAll(objectList);

            }else{
            this.dao.save(conta);
        }



    }
//  Retorna por ID
    public Optional<Conta> findById(Long id) {
        return this.dao.findById(id);
    }
// Retorna por nome
    public List<Conta> findByNome(String nome) {

        return this.dao.findByNome(nome);
    }
// Retorna por permanente e mês atual
    public List<Conta> findByPermanente(int dataVenc){

        return this.dao.findByPermanente(dataVenc);
    }
//  Retorna por mês especifico
    public Saldo findByData(int dataVenc) {
        List <Conta> contas = this.dao.findByData(dataVenc);
        Saldo saldo = new Saldo();
        float valor = 0;
        for (Conta a: contas) {
            valor = a.getTipo().equals("receber") ? valor + a.getValor() : valor - a.getValor();

        }
        saldo.setSaldo(valor);
        saldo.setContas(contas);

        return saldo;
    }
//  Paga conta por nome + valor
    public void setContaByNome(String nome, float valor) {

        List<Conta> pagando;
        pagando = findByNome(nome);
        float handlerValor = valor;
        for(Conta a : pagando){            
            if(handlerValor == a.getValor() && a.getDataPagamento() == null) {
                a.setDataPagamento(adicionarMes(Calendar.getInstance().getTime(), 0));
                a.setPago(true);
                handlerValor = handlerValor - a.getValor();
            }
            this.dao.saveAll(pagando);
        }

    }
//  Exibe todos os dados
    public List<Conta> findAll(){
        return dao.findAll();
    }
// deleta conta por ID
    public void delete(Conta conta) {
        this.dao.delete(conta);
    }

}
