package br.com.school;

import br.com.school.app.student.register.StudentRegister;
import br.com.school.app.student.register.StudentRegisterDto;
import br.com.school.domain.student.StudentRepository;
import br.com.school.infra.student.InMemoryStudentRepository;


public class MatriculateStudent {
    public static void main (String[] args){
        String name = "Kleber";
        String cpf = "031.157.305-30";
        String email = "kb@gmail.com";


        StudentRegister register = new StudentRegister(new InMemoryStudentRepository());
        register.execute(new StudentRegisterDto(name, cpf, email));

    }
}
