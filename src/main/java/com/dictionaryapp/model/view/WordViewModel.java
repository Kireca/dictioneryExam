package com.dictionaryapp.model.view;

import com.dictionaryapp.model.entity.LanguageEntity;
import com.dictionaryapp.model.entity.UserEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor

public class WordViewModel {

    private Long id;
    private String term;
    private String translation;
    private String example;
    private LocalDate inputDate;
    private LanguageEntity language;
    private UserEntity addedBy;
}
