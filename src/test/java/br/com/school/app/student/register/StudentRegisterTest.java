package br.com.school.app.student.register;

import br.com.school.domain.student.Cpf;
import br.com.school.domain.student.Student;
import br.com.school.infra.student.InMemoryStudentRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentRegisterTest {

    @Test
    void studentMustBePersisted(){

        InMemoryStudentRepository repository = new InMemoryStudentRepository();
        StudentRegister useCase = new StudentRegister(repository);

        StudentRegisterDto data = new StudentRegisterDto("Kleber","034.877.666-00", "kb@gmail.com");

        useCase.execute(data);

        Student studentFound  = repository.findByCpf(new Cpf("034.877.666-00"));

        assertEquals("Kleber", studentFound.getName());
        assertEquals("034.877.666-00", studentFound.getCpf());
        assertEquals("kb@gmail.com", studentFound.getEmail());

    }
}
