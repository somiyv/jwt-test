package com.example.jwttest.entity;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "user")
@Getter
@Setter
@Builder
@AllArgsConstructor // 테스트이므로 사용. 실무에서는 고려해서 사용하자!
@NoArgsConstructor
public class User {

    @JsonIgnore
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "username", length = 50, unique = true)
    private String username;

    @JsonIgnore
    @Column(name = "password", length = 100)
    private String password;

    @Column(name = "nickname", length = 50)
    private String nickname;

    @JsonIgnore
    @Column(name = "activated")
    private boolean activated;

    @ManyToMany
    @JoinTable(
            name = "user_authority",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "authority_name", referencedColumnName = "authority_name")})
    private Set<Authority> authorities;
}
