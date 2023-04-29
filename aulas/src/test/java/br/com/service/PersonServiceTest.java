package br.com.service;

import br.com.domain.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PersonServiceTest {
    @Test
    public void checkAgeOver18(){
        Person person = new Person(18);
        PersonService service = new PersonService();

        Boolean result = service.isAdult(person);

        Assertions.assertTrue(result);

    }
    @Test
    public void verificarVotoObrigatorio(){
        Person person = new Person(18);
        PersonService service = new PersonService();

        String result = service.canVote(person);

        Assertions.assertEquals("Voto obrigatório", result);

    }
    @Test
    public void verificarVotoOptativoAdolescente(){
        Person person = new Person(16);
        PersonService service = new PersonService();

        String result = service.canVote(person);

        Assertions.assertEquals("Voto opcional", result);

    }
    @Test
    public void verificarVotoOptativoIdoso(){
        Person person = new Person(70);
        PersonService service = new PersonService();

        String result = service.canVote(person);

        Assertions.assertEquals("Voto opcional", result);

    }
    @Test
    public void verificarVotoNaoPermitido(){
        Person person = new Person(15);
        PersonService service = new PersonService();

        String result = service.canVote(person);

        Assertions.assertEquals("Não pode votar", result);

    }
}
