package br.com.service;

import br.com.domain.Person;

public class PersonService {
    public Boolean isAdult(Person person){
        return (person.getAge() >= 18);
    }
    public String canVote(Person person){
        Integer personAge = person.getAge();

        return personAge >= 18 && personAge < 70 ? "Voto obrigatório" :
                personAge >= 16 ? "Voto opcional" : "Não pode votar";


    }
}
