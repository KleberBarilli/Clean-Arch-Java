package br.com.school.infra.indication;

import br.com.school.app.indication.SendEmail;
import br.com.school.domain.student.Student;

public class SendMail implements SendEmail {
    @Override
    public void send(Student student) {
        //send mail logic

    }
}
