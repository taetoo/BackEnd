package com.sideproject.fikabackend.global.jwt;

import com.sideproject.fikabackend.domain.member.repository.MemberRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomMemberDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

//    @Override
//    public UserDetails loadUserByUsername(String memberId) throws UsernameNotFoundException {
//        return memberRepository.findByMemberId(memberId)
//                .map(this::createMemberDetails)
//                .orElseThrow(() -> new UsernameNotFoundException("해당하는 유저를 찾을 수 없습니다."));
//    }
    @Override
    public UserDetails loadUserByUsername(String mmbrEmail) throws UsernameNotFoundException {
        return memberRepository.findBymmbrEmail(mmbrEmail)
                .map(this::createMemberDetails)
                .orElseThrow(() -> new UsernameNotFoundException("해당하는 유저를 찾을 수 없습니다."));
    }

    // 해당하는 User 의 데이터가 존재한다면 UserDetails 객체로 만들어서 리턴
    private UserDetails createMemberDetails(com.sideproject.fikabackend.domain.member.entity.Member member) {
        return User.builder()
                .username(member.getMmbrEmail())
                .password(passwordEncoder.encode(member.getMmbrPw()))
                .roles(member.getRoles().toArray(new String[0]))
                .build();
    }
}


