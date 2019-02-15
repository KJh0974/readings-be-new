package com.example.demo.api.partner.dao;

import com.example.demo.api.contract.dao.ContractDO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "partner")
public class PartnerDO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String name;
    @Column
    private Boolean company;
    @Column
    private String code;
    @Column
    private String email;
    @Column
    private String phone;
    @OneToMany(mappedBy = "partner")
    private List<ContractDO> contracts;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PartnerDO partnerDO = (PartnerDO) o;
        return Objects.equals(id, partnerDO.id) &&
                Objects.equals(name, partnerDO.name) &&
                Objects.equals(company, partnerDO.company) &&
                Objects.equals(code, partnerDO.code) &&
                Objects.equals(email, partnerDO.email) &&
                Objects.equals(phone, partnerDO.phone) &&
                Objects.equals(contracts, partnerDO.contracts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, company, code, email, phone, contracts);
    }
}
