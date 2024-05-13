package org.example.springdeveloper.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Table(name = "users")
@NoArgsConstructor
@Getter
@Entity

public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", updatable = false)
    private Long id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name ="nickname", unique = true)
    private String nickname;


    @Builder
    public User(String email, String password, String nickname) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        //this.provider = provider;

    }

    public User update(String nickname) {
        this.nickname = nickname;
        return this;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {   //사용자가 가지고 있는 권한에 대한 목록들을 가져옴
        return List.of(new SimpleGrantedAuthority("user"));
    }

    @Override
    public String getUsername() {    //고유해야함
        return email;
    }
    @Override
    public String getPassword() {   //암호화해서 저장해야됨
        return password;
    }
    @Override
    public boolean isAccountNonExpired() {   // 계정 만료 여부 반환 true면 아직 만료안됐음
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {  // 계정 잠금되어있는지 true면 잠금안됐음
        return true;
    }

    public boolean isCredentialsNonExpired() {        //패스워드의 만료 여부
        return true;
    }

    @Override
    public boolean isEnabled() {   // 계정이 사용 가능한지 true면 가능
        return true;
    }
}
