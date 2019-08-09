package com.contas.solutis.controller;

import com.contas.solutis.model.Conta;
import com.contas.solutis.model.Saldo;
import com.contas.solutis.service.ContaService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api/receber")
public class Receber {
    @Autowired
    private ContaService contasService;

    public Receber(@Autowired ContaService contasService) {
        this.contasService = contasService;
    }

    @GetMapping("/contas")
    @ApiOperation("Retorna todas as contas do banco")
    public List<Conta> contas() {
        return contasService.findAll();
    }

    @GetMapping("/conta/{id}")
    @ApiOperation("Retorna todos os dados por ID")
    public Optional<Conta> getContaById(@PathVariable("id") Long id) {

        return contasService.findById(id);
    }

    @GetMapping("/conta/nome/{nome}")
    @ApiOperation("Retorna contas por NOME")
    public List<Conta> getContaByNome(@PathVariable("nome") String nome) {

        return contasService.findByNome(nome);
    }

//  Retorna todos os dados que são permanentes do mês atual
    public List<Conta> getContaByPermanente(){

        return contasService.findByPermanente(Calendar.getInstance().get(Calendar.MONTH));
    }

    @GetMapping("/conta/data/{dataVenc}")
    @ApiOperation("Retorna todos dados por MÊS especifico - exemplo: JUNHO = '6'")
    public Saldo getContaByData(@PathVariable("dataVenc") int dataVenc) {

        return contasService.findByData(dataVenc);
    }

    @PutMapping("/conta/nome/{nome}/{valor}")
    @ApiOperation("Paga uma conta por NOME + VALOR")
    public void setContaByName(@PathVariable("nome") String nome, @PathVariable("valor") float valor) {

        this.contasService.setContaByNome(nome, valor);
    }

    @PostMapping("/conta")
    @ApiOperation("Insere CONTA no banco de dados")
    public void inserirConta(@RequestBody Conta conta) {
        contasService.persistOrMerge(conta);
    }

    @PutMapping("/conta")
    @ApiOperation("Atualiza informações da conta passando o json com ID")
    public void atualizarConta(@RequestBody Conta conta) {
        contasService.persistOrMerge(conta);
    }

    @DeleteMapping("/conta")
    @ApiOperation("Deleta a conta por ID")
    public void deletarConta(@RequestBody Conta conta) {
        this.contasService.delete(conta);

    }


}