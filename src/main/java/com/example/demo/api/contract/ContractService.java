package com.example.demo.api.contract;

import com.example.demo.api.contract.dao.ContractDO;
import com.example.demo.api.contract.dao.ContractRepository;
import com.example.demo.api.contract.model.Contract;
import com.example.demo.api.object.ObjectService;
import com.example.demo.api.partner.PartnerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContractService {

    private final ContractRepository contractRepository;

    public ContractService(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    @Transactional(readOnly = true)
    public List<Contract> findAll() {
        return contractRepository.findAll().stream()
                .map(ContractService::mapContractDO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Contract findContract(Long id) {
        return contractRepository.findById(id)
                .map(ContractService::mapContractDO)
                .orElse(null);
    }

    public static Contract mapContractDO(ContractDO contractDO) {
        final var contract = new Contract();
        contract.setId(contractDO.getId());
        contract.setStartDate(contractDO.getStartDate());
        contract.setEndDate(contractDO.getEndDate());

        contract.setPartner(PartnerService.mapPartner(contractDO.getPartner()));
        contract.setObject(ObjectService.mapObject(contractDO.getObject()));

        return contract;
    }
}
