package br.com.school.domain.student;

public class StudentNotFound extends RuntimeException {
    public StudentNotFound(Cpf cpf) {
        super("Student with CPF: " + cpf.getCpf() + "Not Found");
    }
}
