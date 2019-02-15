package com.example.demo.api.contract.model;

import com.example.demo.api.partner.model.Partner;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Objects;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Contract {

    private Long id;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    private Partner partner;
    private Object object;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contract contract = (Contract) o;
        return Objects.equals(id, contract.id) &&
                Objects.equals(startDate, contract.startDate) &&
                Objects.equals(endDate, contract.endDate) &&
                Objects.equals(partner, contract.partner) &&
                Objects.equals(object, contract.object);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, startDate, endDate, partner, object);
    }
}
