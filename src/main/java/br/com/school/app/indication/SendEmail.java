package br.com.school.app.indication;

import br.com.school.domain.student.Student;

public interface SendEmail {

    void send(Student student);
}
