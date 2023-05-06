package br.com.service;

import br.com.exception.SaldoInsuficienteException;
import br.com.domain.ContaBancaria;
import br.com.exception.ValorInvalidoException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContaBancariaServiceTest {
    ContaBancariaService service = new ContaBancariaService();

    @Test
    public void depositarTest(){
        ContaBancaria conta = new ContaBancaria();

        service.depositar(conta, 100.00);
        Assertions.assertEquals(100.00, conta.getSaldo().doubleValue());

        service.depositar(conta, 100.00);
        Assertions.assertEquals(200.00, conta.getSaldo().doubleValue());

        Assertions.assertThrows(ValorInvalidoException.class, () -> {service.depositar(conta, -1.00);});
    }

    @Test
    public void sacarTest(){
        ContaBancaria conta = new ContaBancaria();

        service.depositar(conta, 50.0);
        service.sacar(conta, 25.00);
        Assertions.assertEquals(25.00, conta.getSaldo().doubleValue());

        service.sacar(conta, 25.00);
        Assertions.assertEquals(0.00, conta.getSaldo().doubleValue());

        Assertions.assertThrows(SaldoInsuficienteException.class, () -> {service.sacar(conta, 25.00);});

        Assertions.assertThrows(ValorInvalidoException.class, () -> {service.sacar(conta, -1.00);});

    }
    @Test
    public void transferirTest(){
        ContaBancaria contaRecebedor = new ContaBancaria();
        ContaBancaria contaPagador = new ContaBancaria();

        service.depositar(contaPagador, 50.0);
        service.transferir(contaRecebedor, contaPagador, 40.0);
        Assertions.assertEquals(40.0, contaRecebedor.getSaldo().doubleValue());
        Assertions.assertEquals(10.0, contaPagador .getSaldo().doubleValue());

        Assertions.assertThrows(SaldoInsuficienteException.class, () -> {service.transferir(contaRecebedor, contaPagador, 10.01);});
        Assertions.assertEquals(40.0, contaRecebedor.getSaldo().doubleValue());
        Assertions.assertEquals(10.0, contaPagador .getSaldo().doubleValue());

        Assertions.assertThrows(ValorInvalidoException.class, () -> {service.transferir(contaRecebedor, contaPagador, -1.00);});
        Assertions.assertEquals(40.0, contaRecebedor.getSaldo().doubleValue());
        Assertions.assertEquals(10.0, contaPagador .getSaldo().doubleValue());

    }
}
