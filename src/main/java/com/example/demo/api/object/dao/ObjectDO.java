package com.example.demo.api.object.dao;

import com.example.demo.api.contract.dao.ContractDO;
import com.example.demo.api.meter.dao.MeterDO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "object")
public class ObjectDO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String type;
    @Column
    private String city;
    @Column
    private String region;
    @Column
    private String street;
    @Column
    private String houseNumber;
    @Column
    private String apartmentNumber;
    @Column
    private String postalCode;
    @OneToMany(mappedBy = "object")
    private List<ContractDO> contracts;
    @OneToMany(mappedBy = "object")
    private List<MeterDO> meters;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ObjectDO objectDO = (ObjectDO) o;
        return Objects.equals(id, objectDO.id) &&
                Objects.equals(type, objectDO.type) &&
                Objects.equals(city, objectDO.city) &&
                Objects.equals(region, objectDO.region) &&
                Objects.equals(street, objectDO.street) &&
                Objects.equals(houseNumber, objectDO.houseNumber) &&
                Objects.equals(apartmentNumber, objectDO.apartmentNumber) &&
                Objects.equals(postalCode, objectDO.postalCode) &&
                Objects.equals(contracts, objectDO.contracts) &&
                Objects.equals(meters, objectDO.meters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, city, region, street, houseNumber, apartmentNumber, postalCode, contracts, meters);
    }
}
