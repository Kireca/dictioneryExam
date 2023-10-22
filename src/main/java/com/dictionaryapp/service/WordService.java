package com.dictionaryapp.service;

import com.dictionaryapp.model.enums.LanguageNameEnum;
import com.dictionaryapp.model.service.WordServiceModel;
import com.dictionaryapp.model.view.WordViewModel;

import java.util.List;

public interface WordService {
    void addWord(WordServiceModel wordServiceModel);


    List<WordViewModel> findAllWords();

    void remove(Long id);

    void removeAll();
}
