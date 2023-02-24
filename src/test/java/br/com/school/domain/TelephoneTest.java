package br.com.school.domain;

import br.com.school.domain.student.Telephone;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TelephoneTest {

    @Test
    void shouldNotBeAbleToCreateAnTelephoneWithInvalidDDD() {

        assertThrows(IllegalArgumentException.class, () -> new Telephone(null, "12345678"));
        assertThrows(IllegalArgumentException.class, () -> new Telephone("", "12345678"));
        assertThrows(IllegalArgumentException.class, () -> new Telephone("5", "12345678"));
    }

    @Test
    void shouldNotBeAbleToCreateAnTelephoneWithInvalidNumber() {

        assertThrows(IllegalArgumentException.class, () -> new Telephone("54", null));
        assertThrows(IllegalArgumentException.class, () -> new Telephone("54", ""));
        assertThrows(IllegalArgumentException.class, () -> new Telephone("54", "123456"));
    }

    @Test
    void shouldBeAbleToCreateAnTelephone() {
        String ddd = "54";
        String number = "99532382";
        Telephone telephone = new Telephone(ddd, number);
        assertEquals(ddd, telephone.getDdd());
        assertEquals(number, telephone.getNumber());
    }
}
