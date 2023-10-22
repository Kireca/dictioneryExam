package com.dictionaryapp.service.impl;

import com.dictionaryapp.model.entity.WordEntity;
import com.dictionaryapp.model.enums.LanguageNameEnum;
import com.dictionaryapp.model.service.WordServiceModel;
import com.dictionaryapp.model.view.WordViewModel;
import com.dictionaryapp.repository.WordRepository;
import com.dictionaryapp.service.LanguageService;
import com.dictionaryapp.service.UserService;
import com.dictionaryapp.service.WordService;
import com.dictionaryapp.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WordServiceImpl implements WordService {


    private final ModelMapper modelMapper;
    private final WordRepository wordRepository;
    private final CurrentUser currentUser;
    private final UserService userService;
    private final LanguageService languageService;

    public WordServiceImpl(ModelMapper modelMapper, WordRepository wordRepository, CurrentUser currentUser, UserService userService, LanguageService languageService) {
        this.modelMapper = modelMapper;
        this.wordRepository = wordRepository;
        this.currentUser = currentUser;
        this.userService = userService;
        this.languageService = languageService;
    }


    @Override
    public void addWord(WordServiceModel wordServiceModel) {

        WordEntity word = modelMapper.map(wordServiceModel, WordEntity.class);
        word.setAddedBy(userService.findById(currentUser.getId()));
        word.setLanguage(languageService.findByLanguageNameEnum(wordServiceModel.getLanguage()));
        word.setTerm(wordServiceModel.getTerm());
        word.setExample(wordServiceModel.getExample());
        word.setTranslation(wordServiceModel.getTranslation());
        wordRepository.save(word);
    }

    @Override
    public List<WordViewModel> findAllWords() {
        return wordRepository.findAll()
                .stream()
                .map(wordEntity -> modelMapper.map(wordEntity, WordViewModel.class)).collect(Collectors.toList());
    }

    @Override
    public void remove(Long id) {
        wordRepository.deleteById(id);
    }

    @Override
    public void removeAll() {
        wordRepository.deleteAll();
    }
}
