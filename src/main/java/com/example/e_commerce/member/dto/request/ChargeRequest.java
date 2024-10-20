package com.example.e_commerce.member.dto.request;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
public class ChargeRequest {

    private final UUID uuid;
    private final long amount;

    @Builder
    public ChargeRequest(UUID uuid, long amount){
        this.uuid = uuid;
        this.amount = amount;
    }
}
