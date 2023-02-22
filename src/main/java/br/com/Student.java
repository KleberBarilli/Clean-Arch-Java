package br.com;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private Email email;
    private Cpf cpf;

    private List<Telephone> telephones = new ArrayList<>();

    public void addTelephone(String ddd, String number) {
        this.telephones.add(new Telephone(ddd, number));
    }
}
