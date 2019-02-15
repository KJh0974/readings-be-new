package com.example.demo.api.reading.dao;

import com.example.demo.api.meter.dao.MeterDO;
import com.example.demo.api.period.dao.PeriodDO;
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
@Table(name = "reading")
public class ReadingDO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private LocalDateTime date;
    @Column(name = "old_value")
    private Long oldValue;
    @Column(name = "new_value")
    private Long newValue;
    @ManyToOne
    @JoinColumn(name = "meter_id")
    private MeterDO meter;
    @ManyToOne
    @JoinColumn(name = "period_id")
    private PeriodDO period;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReadingDO readingDO = (ReadingDO) o;
        return Objects.equals(id, readingDO.id) &&
                Objects.equals(date, readingDO.date) &&
                Objects.equals(oldValue, readingDO.oldValue) &&
                Objects.equals(newValue, readingDO.newValue) &&
                Objects.equals(meter, readingDO.meter) &&
                Objects.equals(period, readingDO.period);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, oldValue, newValue, meter, period);
    }
}
