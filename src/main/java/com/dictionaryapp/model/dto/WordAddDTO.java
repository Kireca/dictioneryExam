package com.dictionaryapp.model.dto;

import com.dictionaryapp.model.entity.LanguageEntity;
import com.dictionaryapp.model.enums.LanguageNameEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor

public class WordAddDTO {

    @NotNull
    @Size(min = 2, max = 40)
    private String term;

    @NotNull
    @Size(min = 2, max = 80)
    private String translation;

    @NotNull
    @Size(min = 2, max = 200)
    private String example;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate inputDate;

    @Enumerated(EnumType.STRING)
    private LanguageNameEnum language;


}
