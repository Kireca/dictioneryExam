package com.dictionaryapp.web;

import com.dictionaryapp.model.enums.LanguageNameEnum;
import com.dictionaryapp.model.view.WordViewModel;
import com.dictionaryapp.service.UserService;
import com.dictionaryapp.service.WordService;
import com.dictionaryapp.util.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

import static com.dictionaryapp.model.enums.LanguageNameEnum.GERMAN;

@Controller
public class HomeController {

    private final CurrentUser currentUser;
    private final WordService wordService;
    private final UserService userService;

    public HomeController(CurrentUser currentUser, WordService wordService, UserService userService) {
        this.currentUser = currentUser;
        this.wordService = wordService;
        this.userService = userService;
    }

    @GetMapping
    public String index(Model model) {
        if (currentUser.isNotActive()) {
            return "index";
        }


        List<WordViewModel> germanWords = new ArrayList<>();
        List<WordViewModel> frenchWords = new ArrayList<>();
        List<WordViewModel> spanishWords = new ArrayList<>();
        List<WordViewModel> italianWords = new ArrayList<>();

        long countOfAllWords = wordService.findAllWords().size();
        model.addAttribute("countOfAllWords", countOfAllWords);

        wordService.findAllWords().forEach(word -> {
            switch (word.getLanguage().getName()) {
                case GERMAN -> germanWords.add(word);
                case FRENCH -> frenchWords.add(word);
                case SPANISH -> spanishWords.add(word);
                case ITALIAN -> italianWords.add(word);
            }
        });

        model.addAttribute("germanWords", germanWords);
        model.addAttribute("germanCount", germanWords.size());

        model.addAttribute("frenchWords", frenchWords);
        model.addAttribute("frenchCount", frenchWords.size());


        model.addAttribute("spanishWords", spanishWords);
        model.addAttribute("spanishCount", spanishWords.size());

        model.addAttribute("italianWords", italianWords);
        model.addAttribute("italianCount", italianWords.size());

        return "home";
    }

}
