package br.com.school.domain.student;

public class StudentFactory {

    private Student student;

    public StudentFactory withNameCpfEmail(String name, String cpf, String email) {
        this.student = new Student(name, new Email(email), new Cpf(cpf));
        return this;
    }

    public StudentFactory withTelephone(String ddd, String number) {
        this.student.addTelephone(ddd, number);
        return this;
    }
}
