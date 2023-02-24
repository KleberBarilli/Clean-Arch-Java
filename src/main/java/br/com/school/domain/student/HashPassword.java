package br.com.school.domain.student;

public interface HashPassword {

    String hashPassword(String password);

    boolean verify(String hashedPassword, String password);
}
