package com.example.demo.api.meter.dao;

import com.example.demo.api.object.dao.ObjectDO;
import com.example.demo.api.reading.dao.ReadingDO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "meter")
public class MeterDO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String type;
    @Column
    private String serialNumber;
    @Column
    private LocalDateTime installDate;
    @Column
    private LocalDateTime verificationDate;
    @ManyToOne
    @JoinColumn(name = "object_id")
    private ObjectDO object;
    @OneToMany(mappedBy = "meter")
    private List<ReadingDO> readings;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MeterDO meterDO = (MeterDO) o;
        return Objects.equals(id, meterDO.id) &&
                Objects.equals(type, meterDO.type) &&
                Objects.equals(serialNumber, meterDO.serialNumber) &&
                Objects.equals(installDate, meterDO.installDate) &&
                Objects.equals(verificationDate, meterDO.verificationDate) &&
                Objects.equals(object, meterDO.object) &&
                Objects.equals(readings, meterDO.readings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, serialNumber, installDate, verificationDate, object, readings);
    }
}
