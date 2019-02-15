package com.example.demo.api.contract.dao;

import com.example.demo.api.object.dao.ObjectDO;
import com.example.demo.api.partner.dao.PartnerDO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "contract")
public class ContractDO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private LocalDateTime startDate;
    @Column
    private LocalDateTime endDate;
    @ManyToOne
    @JoinColumn(name = "partner_id")
    private PartnerDO partner;
    @ManyToOne
    @JoinColumn(name = "object_id")
    private ObjectDO object;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContractDO that = (ContractDO) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(startDate, that.startDate) &&
                Objects.equals(endDate, that.endDate) &&
                Objects.equals(partner, that.partner) &&
                Objects.equals(object, that.object);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, startDate, endDate, partner, object);
    }
}
