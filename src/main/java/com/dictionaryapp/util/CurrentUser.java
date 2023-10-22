package com.dictionaryapp.util;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Getter
@Setter
@NoArgsConstructor

@Component
@SessionScope
public class CurrentUser {


    private Long id;

    private String username;


    public Boolean isNotActive() {
        return this.getId() == null;
    }
}