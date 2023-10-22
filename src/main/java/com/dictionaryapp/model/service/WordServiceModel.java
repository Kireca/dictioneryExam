package com.dictionaryapp.model.service;

import com.dictionaryapp.model.entity.UserEntity;
import com.dictionaryapp.model.enums.LanguageNameEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor

public class WordServiceModel {


    private Long id;
    private String term;
    private String translation;
    private String example;
    private LocalDate inputDate;
    private LanguageNameEnum language;
    private UserEntity addedBy;

}
