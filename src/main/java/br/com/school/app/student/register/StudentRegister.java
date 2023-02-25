package br.com.school.app.student.register;

import br.com.school.domain.student.Student;
import br.com.school.domain.student.StudentRepository;

public class StudentRegister {
    private final StudentRepository repository;

    public StudentRegister(StudentRepository repository){
        this.repository = repository;
    }

    public void execute(StudentRegisterDto data){
        Student student = data.makeStudent();
        repository.register(student);
    }


}
