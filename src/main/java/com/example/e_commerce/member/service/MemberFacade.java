package com.example.e_commerce.member.service;

import com.example.e_commerce.charge.service.ChargeService;
import com.example.e_commerce.member.dto.response.MemberResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class MemberFacade {

    private final MemberService memberService;
    private final ChargeService chargeService;

    public MemberFacade(MemberService memberService, ChargeService chargeService){
        this.memberService = memberService;
        this.chargeService = chargeService;
    }

    public MemberResponse getMemberBalance(UUID uuid) throws Exception {
        long balance = memberService.getMemberBalance(uuid);
        return MemberResponse.of(balance);
    }

    @Transactional
    public void chargeMemberBalance(UUID uuid, long amount) throws Exception {
        long balance = memberService.getMemberBalance(uuid);
        long chargedBalance = balance + amount;
        memberService.updateBalance(uuid, chargedBalance);
        chargeService.saveCharge(uuid, amount);
    }
}
