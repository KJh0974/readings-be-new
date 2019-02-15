package com.example.demo.api.period.dao;

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
@Table(name = "period")
public class PeriodDO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String name;
    @Column
    private LocalDateTime startDate;
    @Column
    private LocalDateTime endDate;
    @OneToMany(mappedBy = "period")
    private List<ReadingDO> readings;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PeriodDO periodDO = (PeriodDO) o;
        return Objects.equals(id, periodDO.id) &&
                Objects.equals(name, periodDO.name) &&
                Objects.equals(startDate, periodDO.startDate) &&
                Objects.equals(endDate, periodDO.endDate) &&
                Objects.equals(readings, periodDO.readings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, startDate, endDate, readings);
    }
}
