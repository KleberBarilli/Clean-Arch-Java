package br.com;

import java.time.LocalDateTime;

public class Indication {

    private Student indicated;
    private Student indicator;

    private LocalDateTime indicatedAt;

    public Indication(Student indicated, Student indicator) {
        this.indicated = indicated;
        this.indicator = indicator;
        this.indicatedAt = LocalDateTime.now();
    }

    public Student getIndicated() {
        return indicated;
    }

    public Student getIndicator() {
        return indicator;
    }

    public LocalDateTime getIndicatedAt() {
        return indicatedAt;
    }
}
