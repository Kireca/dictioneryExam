package com.dictionaryapp.service.impl;

import com.dictionaryapp.model.entity.LanguageEntity;
import com.dictionaryapp.model.enums.LanguageNameEnum;
import com.dictionaryapp.model.enums.constants.DescriptionConstant;
import com.dictionaryapp.repository.LanguageRepository;
import com.dictionaryapp.service.LanguageService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class LanguageServiceImpl implements LanguageService {


    private final LanguageRepository languageRepository;

    public LanguageServiceImpl(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }


    @Override
    public void initLanguages() {
        if (languageRepository.count() != 0) {
            return;
        }

        Arrays.stream(LanguageNameEnum.values())
                .forEach(languageNameEnum -> {
                    LanguageEntity language = new LanguageEntity();
                    language.setName(languageNameEnum);
                    switch (languageNameEnum) {

                        case FRENCH -> language.setDescription(DescriptionConstant.FRENCH);
                        case GERMAN -> language.setDescription(DescriptionConstant.GERMAN);
                        case ITALIAN -> language.setDescription(DescriptionConstant.ITALIAN);
                        case SPANISH -> language.setDescription(DescriptionConstant.SPANISH);
                    }

                    languageRepository.save(language);
                });

    }

    @Override
    public LanguageEntity findByLanguageNameEnum(LanguageNameEnum language) {
        return languageRepository.findByName(language).orElse(null);
    }
}
