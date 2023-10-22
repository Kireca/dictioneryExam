package com.dictionaryapp.model.entity;


import com.dictionaryapp.model.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor


@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {

    @NotNull
    @Size(min = 3, max = 20)
    private String username;

    @NotNull
    @Size(min = 3, max = 20)
    private String password;

    @Email
    @NotNull
    @Column(unique = true)
    private String email;

    @OneToMany
    private List<WordEntity> addedWords;


}
