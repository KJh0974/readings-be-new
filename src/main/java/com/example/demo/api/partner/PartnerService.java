package com.example.demo.api.partner;

import com.example.demo.api.partner.dao.PartnerDO;
import com.example.demo.api.partner.dao.PartnerRepository;
import com.example.demo.api.partner.model.Partner;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PartnerService {

    private PartnerRepository partnerRepository;

    public PartnerService(PartnerRepository partnerRepository) {
        this.partnerRepository = partnerRepository;
    }

    @Transactional(readOnly = true)
    public List<Partner> findAll() {
        return partnerRepository.findAll().stream()
                .map(PartnerService::mapPartner)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Partner findById(Long id) {
        return partnerRepository.findById(id)
                .map(PartnerService::mapPartner)
                .orElse(null);
    }

    public static Partner mapPartner(PartnerDO partnerDO) {
        final var partner = new Partner();
        partner.setId(partnerDO.getId());
        partner.setCode(partnerDO.getCode());
        partner.setCompany(partnerDO.getCompany());
        partner.setEmail(partnerDO.getEmail());
        partner.setName(partnerDO.getName());
        partner.setPhone(partnerDO.getPhone());

        return partner;
    }
}
