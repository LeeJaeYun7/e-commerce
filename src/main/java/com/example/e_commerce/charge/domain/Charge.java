package com.example.e_commerce.charge.domain;

import com.example.e_commerce.global.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@Entity
@Table(name = "charge")
@NoArgsConstructor
public class Charge extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private UUID uuid;

    private long amount;

    @Builder
    public Charge(UUID uuid, long amount){
        this.uuid = uuid;
        this.amount = amount;
    }

    public static Charge of(UUID uuid, long amount){
        return Charge.builder()
                     .uuid(uuid)
                     .amount(amount)
                     .build();
    }
}
