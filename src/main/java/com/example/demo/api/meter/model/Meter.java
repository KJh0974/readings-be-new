package com.example.demo.api.meter.model;

import com.example.demo.api.reading.model.Reading;
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
public class Meter {

    private Long id;
    private String type;
    private String serialNumber;
    private LocalDateTime installDate;
    private LocalDateTime verificationDate;

    private List<Reading> readings = Lists.newArrayList();

    public void addReading(Reading reading) {
        readings.add(reading);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Meter meter = (Meter) o;
        return Objects.equals(id, meter.id) &&
                Objects.equals(type, meter.type) &&
                Objects.equals(serialNumber, meter.serialNumber) &&
                Objects.equals(installDate, meter.installDate) &&
                Objects.equals(verificationDate, meter.verificationDate) &&
                Objects.equals(readings, meter.readings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, serialNumber, installDate, verificationDate, readings);
    }
}
