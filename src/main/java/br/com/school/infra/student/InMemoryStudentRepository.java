package br.com.school.infra.student;

import br.com.school.domain.student.Cpf;
import br.com.school.domain.student.Student;
import br.com.school.domain.student.StudentNotFound;
import br.com.school.domain.student.StudentRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryStudentRepository implements StudentRepository {

    private List<Student> registered = new ArrayList<>();

    @Override
    public void register(Student student) {
        this.registered.add(student);

    }

    @Override
    public Student findByCpf(Cpf cpf) {
        return this.registered.stream()
                .filter(student -> student.getCpf().equals(cpf.getCpf()))
                .findFirst()
                .orElseThrow(() -> new StudentNotFound(cpf));
    }

    @Override
    public List<Student> findAll() {
        return this.registered;
    }
}
