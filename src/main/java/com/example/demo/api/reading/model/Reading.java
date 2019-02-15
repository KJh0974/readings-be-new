package com.example.demo.api.reading.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Objects;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Reading {

    private Long id;
    private LocalDateTime date;
    private Long oldValue;
    private Long newValue;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reading reading = (Reading) o;
        return Objects.equals(id, reading.id) &&
                Objects.equals(date, reading.date) &&
                Objects.equals(oldValue, reading.oldValue) &&
                Objects.equals(newValue, reading.newValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, oldValue, newValue);
    }
}
