package com.example.e_commerce.charge.service;

import com.example.e_commerce.charge.domain.Charge;
import com.example.e_commerce.charge.repository.ChargeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ChargeService {

    private final ChargeRepository chargeRepository;
    public void saveCharge(UUID uuid, long amount){
        Charge charge = Charge.of(uuid, amount);
        chargeRepository.save(charge);
    }
}
