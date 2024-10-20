package com.example.e_commerce.member.domain;

import com.example.e_commerce.global.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@Entity
@Table(name = "member")
@NoArgsConstructor
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private UUID uuid;

    private String name;

    private long balance;

    @Builder
    public Member(UUID uuid, String name, long balance){
        this.uuid = uuid;
        this.name = name;
        this.balance = balance;
    }

    public void updateBalance(long balance){
        this.balance = balance;
    }

    public void isOrderAvailable(long orderAmount) throws Exception {
        if(this.balance - orderAmount < 0){
            throw new Exception();
        }
    }
}

