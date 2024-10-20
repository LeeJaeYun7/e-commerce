package com.example.e_commerce.member.service;


import com.example.e_commerce.member.domain.Member;
import com.example.e_commerce.member.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    public Member getMemberByUuid(UUID uuid) throws Exception {
        return memberRepository.findMemberByUuidWithLock(uuid)
                               .orElseThrow(Exception::new);
    }

    public long getMemberBalance(UUID uuid) throws Exception {
        Member member = getMemberByUuid(uuid);
        return member.getBalance();
    }

    public void updateBalance(UUID uuid, long updatedBalance) throws Exception {
        Member member = getMemberByUuid(uuid);
        member.updateBalance(updatedBalance);
    }

    public void decreaseBalance(UUID uuid, long totalOrderAmount) throws Exception {
        long decreasedBalance = getMemberBalance(uuid) - totalOrderAmount;
        updateBalance(uuid, decreasedBalance);
    }
}
