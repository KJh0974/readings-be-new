package com.example.demo.api.meter;

import com.example.demo.api.meter.dao.MeterDO;
import com.example.demo.api.meter.dao.MeterRepository;
import com.example.demo.api.meter.model.Meter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MeterService {

    private MeterRepository contractRepository;

    public MeterService(MeterRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    @Transactional(readOnly = true)
    public List<Meter> findAll() {
        return contractRepository.findAll().stream()
                .map(MeterService::mapMeter)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Meter findContract(Long id) {
        return contractRepository.findById(id)
                .map(MeterService::mapMeter)
                .orElse(null);
    }

    public static Meter mapMeter(MeterDO meterDO) {
        final var meter = new Meter();
        meter.setId(meterDO.getId());
        meter.setInstallDate(meterDO.getInstallDate());
        meter.setSerialNumber(meterDO.getSerialNumber());
        meter.setType(meterDO.getType());
        meter.setVerificationDate(meterDO.getVerificationDate());

        return meter;
    }
}
