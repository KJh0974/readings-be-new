package com.example.demo.api.object;

import com.example.demo.api.object.dao.ObjectDO;
import com.example.demo.api.object.dao.ObjectRepository;
import com.example.demo.api.object.model.ObjectModel;
import com.example.demo.api.period.PeriodService;
import com.example.demo.api.reading.ReadingService;
import com.example.demo.api.meter.MeterService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ObjectService {

    private ObjectRepository objectRepository;

    public ObjectService(ObjectRepository objectRepository) {
        this.objectRepository = objectRepository;
    }

    @Transactional(readOnly = true)
    public List<ObjectModel> findAll() {
        return objectRepository.findAll().stream()
                .map(ObjectService::mapObject)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ResponseEntity<ObjectModel> findContract(Long id) {
        return objectRepository.findById(id)
                .map(ObjectService::mapObject)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    public static ObjectModel mapObject(ObjectDO objectDO) {
        final var object = new ObjectModel();
        object.setId(objectDO.getId());
        object.setType(objectDO.getType());
        object.setRegion(objectDO.getRegion());
        object.setCity(objectDO.getCity());
        object.setStreet(objectDO.getStreet());
        object.setHouseNumber(objectDO.getHouseNumber());
        object.setApartmentNumber(objectDO.getApartmentNumber());
        object.setPostalCode(objectDO.getPostalCode());

        objectDO.getMeters().forEach(meterDO -> {
            meterDO.getReadings().forEach(readingDO -> {
                final var noneMatch = object.getPeriods().stream().noneMatch(p -> Objects.equals(p.getId(), readingDO.getPeriod().getId()));
                if (noneMatch) {
                    object.getPeriods().add(PeriodService.mapPeriod(readingDO.getPeriod()));
                }
            });
        });

        object.getPeriods().forEach(p -> {
            objectDO.getMeters().forEach(meterDO -> {
                meterDO.getReadings().forEach(readingDO -> {
                    final boolean noneMatch = p.getMeters().stream().noneMatch(m -> Objects.equals(m.getId(), meterDO.getId()));
                    if (readingDO.getDate().getMonth() == p.getStartDate().getMonth() && noneMatch) {
                        p.getMeters().add(MeterService.mapMeter(meterDO));
                    }
                });
            });
        });

        object.getPeriods().forEach(p -> {
           p.getMeters().forEach(m -> {
               objectDO.getMeters().forEach(meterDO -> {
                   meterDO.getReadings().forEach(readingDO -> {
                       final boolean noneMatch = m.getReadings().stream().noneMatch(r -> Objects.equals(r.getId(), readingDO.getId()));
                       if (Objects.equals(m.getId(), readingDO.getMeter().getId())
                               && readingDO.getDate().getMonth() == p.getStartDate().getMonth()
                               && noneMatch) {
                           m.getReadings().add(ReadingService.mapReading(readingDO));
                       }
                   });
               });
           });
        });

        return object;
    }
}
