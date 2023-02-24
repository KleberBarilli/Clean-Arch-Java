package br.com.school.domain.student;

public class StudentNotFound extends RuntimeException {

    private static final long serialVersionUid = 1L;

    public StudentNotFound(Cpf cpf) {
        super("Student with CPF: " + cpf.getCpf() + "Not Found");
    }
}
