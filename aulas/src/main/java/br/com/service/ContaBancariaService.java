package br.com.service;

import br.com.domain.ContaBancaria;

public class ContaBancariaService {
    public void depositar(ContaBancaria conta, Double valor){
        conta.setSaldo(conta.getSaldo() + valor);
    }
}
