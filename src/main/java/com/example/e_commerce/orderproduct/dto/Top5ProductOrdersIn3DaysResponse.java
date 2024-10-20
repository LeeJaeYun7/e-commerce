package com.example.e_commerce.orderproduct.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.Map;

@Getter
public class Top5ProductOrdersIn3DaysResponse {

    private final List<Map.Entry<Long, Long>> top5Entries;

    @Builder
    public Top5ProductOrdersIn3DaysResponse(List<Map.Entry<Long, Long>> top5Entries){
        this.top5Entries = top5Entries;
    }

    public static Top5ProductOrdersIn3DaysResponse of(List<Map.Entry<Long, Long>> top5Entries){
        return Top5ProductOrdersIn3DaysResponse.builder()
                                               .top5Entries(top5Entries)
                                               .build();
    }
}
