package com.example.demo.api.object.model;

import com.example.demo.api.period.model.Period;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.common.collect.Lists;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ObjectModel {

    private Long id;
    private String type;
    private String city;
    private String region;
    private String street;
    private String houseNumber;
    private String apartmentNumber;
    private String postalCode;

    private List<Period> periods = Lists.newArrayList();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ObjectModel that = (ObjectModel) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(type, that.type) &&
                Objects.equals(city, that.city) &&
                Objects.equals(region, that.region) &&
                Objects.equals(street, that.street) &&
                Objects.equals(houseNumber, that.houseNumber) &&
                Objects.equals(apartmentNumber, that.apartmentNumber) &&
                Objects.equals(postalCode, that.postalCode) &&
                Objects.equals(periods, that.periods);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, city, region, street, houseNumber, apartmentNumber, postalCode, periods);
    }
}
