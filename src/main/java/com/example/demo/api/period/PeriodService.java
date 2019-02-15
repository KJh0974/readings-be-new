package com.example.demo.api.period;

import com.example.demo.api.period.dao.PeriodDO;
import com.example.demo.api.period.dao.PeriodRepository;
import com.example.demo.api.period.model.Period;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PeriodService {

    private PeriodRepository periodRepository;

    public PeriodService(PeriodRepository periodRepository) {
        this.periodRepository = periodRepository;
    }

    @Transactional(readOnly = true)
    public List<Period> findAll() {
        return periodRepository.findAll().stream()
                .map(PeriodService::mapPeriod)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Period findPeriod(Long id) {
        return periodRepository.findById(id)
                .map(PeriodService::mapPeriod)
                .orElse(null);
    }

    public static Period mapPeriod(PeriodDO periodDO) {
        final var period = new Period();
        period.setId(periodDO.getId());
        period.setName(periodDO.getName());
        period.setStartDate(periodDO.getStartDate());
        period.setEndDate(periodDO.getEndDate());

        return period;
    }
}
