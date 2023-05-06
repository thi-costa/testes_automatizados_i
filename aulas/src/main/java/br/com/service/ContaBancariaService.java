package br.com.service;

import br.com.exception.SaldoInsuficienteException;
import br.com.domain.ContaBancaria;
import br.com.exception.ValorInvalidoException;

public class ContaBancariaService {
    public void depositar(ContaBancaria conta, Double valor){
        if (valor < 0) throw new ValorInvalidoException("Depósito negativo inválido");
        conta.setSaldo(conta.getSaldo() + valor);
    }
    public void sacar(ContaBancaria conta, Double valor) {
        if(conta.getSaldo() < valor) throw new SaldoInsuficienteException("Saldo insuficiente");
        else if (valor < 0) throw new ValorInvalidoException("Saque de valor negativo inválido");
        conta.setSaldo(conta.getSaldo() - valor);
    }
    public void transferir(ContaBancaria contaRecebedor, ContaBancaria contaPagador, Double valor){
        sacar(contaPagador, valor);
        depositar(contaRecebedor, valor);
    }
}
