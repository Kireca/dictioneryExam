package com.dictionaryapp.model.entity;


import com.dictionaryapp.model.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
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


@Entity
@Table(name = "words")
public class WordEntity  extends BaseEntity {

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

    @ManyToOne
    private LanguageEntity language;

    @ManyToOne
    private UserEntity addedBy;


}
