package br.com.school.student;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private Email email;
    private Cpf cpf;

    private List<Telephone> telephones = new ArrayList<>();

    public Student(String name, Email email, Cpf cpf) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
    }

    public void addTelephone(String ddd, String number) {
        this.telephones.add(new Telephone(ddd, number));
    }

    public String getName() {
        return name;
    }

    public Email getEmail() {
        return email;
    }

    public Cpf getCpf() {
        return cpf;
    }

    public List<Telephone> getTelephones() {
        return telephones;
    }
}
