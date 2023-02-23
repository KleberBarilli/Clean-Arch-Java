package br.com.school.domain;

import br.com.school.domain.student.Cpf;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CpfTest {

    @Test
    void shouldNotBeAbleToCreateAnInvalidCpf() {

        assertThrows(IllegalArgumentException.class, () -> new Cpf(null));
        assertThrows(IllegalArgumentException.class, () -> new Cpf("1545454556"));

    }

    @Test
    void shouldBeAbleToCreateAnValidCpf() {
        String number = "123.456.789-00";
        Cpf cpf = new Cpf(number);
        assertEquals(number, cpf.getCpf());
    }

}

