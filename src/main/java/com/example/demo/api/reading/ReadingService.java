package com.example.demo.api.reading;

import com.example.demo.api.reading.dao.ReadingDO;
import com.example.demo.api.reading.dao.ReadingRepository;
import com.example.demo.api.reading.model.Reading;
import com.example.demo.api.reading.model.ReadingAddable;
import com.example.demo.api.meter.dao.MeterRepository;
import com.example.demo.api.period.dao.PeriodRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReadingService {

    private ReadingRepository readingRepository;

    private MeterRepository meterRepository;
    private PeriodRepository periodRepository;

    public ReadingService(ReadingRepository readingRepository, MeterRepository meterRepository, PeriodRepository periodRepository) {
        this.readingRepository = readingRepository;
        this.meterRepository = meterRepository;
        this.periodRepository = periodRepository;
    }

    @Transactional(readOnly = true)
    public List<Reading> findAll() {
        return readingRepository.findAll().stream()
                .map(ReadingService::mapReading)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ResponseEntity<Reading> findById(Long id) {
        return readingRepository.findById(id)
                .map(ReadingService::mapReading)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Transactional
    public Reading add(ReadingAddable reading) {
        final var readingDO = new ReadingDO();

        return Optional.of(readingRepository.save(readingDO))
                .map(ReadingService::mapReading)
                .orElse(null);
    }

    public static Reading mapReading(ReadingDO readingDO) {
        final var reading = new Reading();
        reading.setId(readingDO.getId());
        reading.setDate(readingDO.getDate());
        reading.setOldValue(readingDO.getOldValue());
        reading.setNewValue(readingDO.getNewValue());

        return reading;
    }
}
