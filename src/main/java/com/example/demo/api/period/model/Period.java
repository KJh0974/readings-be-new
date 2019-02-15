package com.example.demo.api.period.model;

import com.example.demo.api.meter.model.Meter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.common.collect.Lists;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Period {

    private Long id;
    private String name;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    private List<Meter> meters = Lists.newArrayList();

    public void addMeter(Meter meter) {
        meters.add(meter);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Period period = (Period) o;
        return Objects.equals(id, period.id) &&
                Objects.equals(name, period.name) &&
                Objects.equals(startDate, period.startDate) &&
                Objects.equals(endDate, period.endDate) &&
                Objects.equals(meters, period.meters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, startDate, endDate, meters);
    }
}
