package com.dictionaryapp.model.entity;

import com.dictionaryapp.model.BaseEntity;
import com.dictionaryapp.model.enums.LanguageNameEnum;
import jakarta.persistence.*;
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
@Table(name = "languages")
public class LanguageEntity extends BaseEntity {

    @NotNull
    @Column(unique = true)
    @Enumerated(EnumType.STRING)
    private LanguageNameEnum name;

    @NotNull
    private String description;

    @OneToMany(mappedBy = "language", fetch = FetchType.EAGER)
    private List<WordEntity> words;

}
