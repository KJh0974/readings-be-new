package com.example.demo.api.partner.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Partner {

    private Long id;
    private String name;
    private Boolean company;
    private String code;
    private String email;
    private String phone;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Partner partner = (Partner) o;
        return Objects.equals(id, partner.id) &&
                Objects.equals(name, partner.name) &&
                Objects.equals(company, partner.company) &&
                Objects.equals(code, partner.code) &&
                Objects.equals(email, partner.email) &&
                Objects.equals(phone, partner.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, company, code, email, phone);
    }
}
