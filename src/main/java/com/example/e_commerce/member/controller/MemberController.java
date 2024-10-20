package com.example.e_commerce.member.controller;

import com.example.e_commerce.member.dto.request.ChargeRequest;
import com.example.e_commerce.member.dto.response.MemberResponse;
import com.example.e_commerce.member.service.MemberFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class MemberController {
    private final MemberFacade memberFacade;

    public MemberController(MemberFacade memberFacade){
        this.memberFacade = memberFacade;
    }

    @GetMapping("/member/balance")
    public ResponseEntity<MemberResponse> retrieveMemberBalance(@RequestParam(value = "uuid") UUID uuid) throws Exception {
        MemberResponse memberResponse = memberFacade.getMemberBalance(uuid);
        return ResponseEntity.status(HttpStatus.OK).body(memberResponse);
    }

    @PostMapping("/member/charge")
    public ResponseEntity<Void> chargeMemberBalance(@RequestBody ChargeRequest chargeRequest) throws Exception {
        UUID uuid = chargeRequest.getUuid();
        long amount = chargeRequest.getAmount();
        memberFacade.chargeMemberBalance(uuid, amount);

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
