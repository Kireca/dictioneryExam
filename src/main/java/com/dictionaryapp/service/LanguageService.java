package com.dictionaryapp.service;

import com.dictionaryapp.model.entity.LanguageEntity;
import com.dictionaryapp.model.enums.LanguageNameEnum;

public interface LanguageService {
    void initLanguages();

    LanguageEntity findByLanguageNameEnum(LanguageNameEnum language);
}
