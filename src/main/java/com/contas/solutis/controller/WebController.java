package com.contas.solutis.controller;

import com.contas.solutis.model.Conta;
import com.contas.solutis.service.ContaService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RequestMapping(value = "/api")
@RestController
public class WebController {
    @Autowired
    private ContaService contasService;

    @ApiOperation("EM TESTE - HTML + Bootstrap")
    @RequestMapping(
            value = "/adicionarConta",
            produces = "application/json",
            method = { RequestMethod.POST})
    public String adicionarConta(Conta conta) {

        this.contasService.persistOrMerge(conta);

        return "index";
    }
}
