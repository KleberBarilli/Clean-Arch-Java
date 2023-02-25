package br.com.school.app.student.register;

import br.com.school.domain.student.Cpf;
import br.com.school.domain.student.Email;
import br.com.school.domain.student.Student;

public class StudentRegisterDto {
    private String name;
    private String cpf;
    private String email;

    public StudentRegisterDto(String name, String cpf, String email) {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
    }

    public Student makeStudent(){
        return new Student(name,new Email(email), new Cpf(cpf));
    }
}
