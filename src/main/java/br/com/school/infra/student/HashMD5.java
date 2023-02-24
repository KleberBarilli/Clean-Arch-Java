package br.com.school.infra.student;

import br.com.school.domain.student.HashPassword;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashMD5 implements HashPassword {

    @Override
    public String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : bytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean verify(String hashedPassword, String password) {
        String hashed = hashPassword(password);
        return hashedPassword.equals(hashed);
    }

}
