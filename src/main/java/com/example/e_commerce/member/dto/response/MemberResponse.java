package com.example.e_commerce.member.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberResponse {

    long balance;

    @Builder
    public MemberResponse(long balance){
        this.balance = balance;
    }

    public static MemberResponse of(long balance){
        return MemberResponse.builder()
                             .balance(balance)
                             .build();
    }
}
