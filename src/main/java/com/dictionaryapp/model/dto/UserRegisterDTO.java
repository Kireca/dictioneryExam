package com.dictionaryapp.model.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor


public class UserRegisterDTO {


    @NotNull
    @Column(unique = true)
    @Size(min = 3, max = 20)
    private String username;

    @Email
    @NotNull
    @Column(unique = true)
    private String email;

    @NotNull
    @Size(min = 3, max = 20)
    private String password;

    @NotNull
    @Size(min = 3, max = 20)
    private String confirmPassword;


}
