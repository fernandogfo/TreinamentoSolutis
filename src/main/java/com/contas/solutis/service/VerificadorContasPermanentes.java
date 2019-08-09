package com.contas.solutis.service;

import com.contas.solutis.dao.ContasRepositorio;
import com.contas.solutis.model.Conta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@Component
@EnableScheduling
public class VerificadorContasPermanentes {

    private static final String TIME_ZONE = "America/Sao_Paulo";
    private ContasRepositorio dao;
    private Conta conta;
    private Date adicionarMes(Date date, int i) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, i);
        return cal.getTime();}

    private VerificadorContasPermanentes(@Autowired ContasRepositorio dao) {
        this.dao = dao;
    }

    @Scheduled(cron = "0 0 3 10 1/1 ?", zone = TIME_ZONE) public void verificaPorMes() {

        List<Conta> pagando;

        pagando = this.dao.findByPermanente(Calendar.getInstance().get(Calendar.MONTH) + 1);



        for (Conta a : pagando) {
            Conta conta = new Conta();
            conta.setDataVenc(adicionarMes(a.getDataVenc(), 1));
            conta.setValor(a.getValor());
            conta.setParcelas(a.getParcelas());
            conta.setNome(a.getNome());
            conta.setTipo(a.getTipo());
            conta.setPermanente(a.getPermanente());

            this.dao.save(conta);


        }
    }
}
