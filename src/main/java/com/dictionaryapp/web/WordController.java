package com.dictionaryapp.web;

import com.dictionaryapp.model.dto.WordAddDTO;
import com.dictionaryapp.model.service.WordServiceModel;
import com.dictionaryapp.service.WordService;
import com.dictionaryapp.util.CurrentUser;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/words")
public class WordController {

    private final CurrentUser currentUser;
    private final WordService wordService;
    private final ModelMapper modelMapper;

    public WordController(CurrentUser currentUser, WordService wordService, ModelMapper modelMapper) {
        this.currentUser = currentUser;
        this.wordService = wordService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    public String add() {
        if (currentUser.isNotActive()) {
            return "redirect:/users/login";
        }
        return "word-add";
    }


    @PostMapping("/add")
    public String addConfirm(@Valid WordAddDTO wordAddDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("orderAddDTO", wordAddDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.orderAddDTO", bindingResult);

            return "redirect:add";
        }
        wordService.addWord(modelMapper.map(wordAddDTO, WordServiceModel.class));

        return "redirect:/";
    }


    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") Long id) {
        if (currentUser.isNotActive()) {
            return "redirect:/users/login";
        }
        wordService.remove(id);
        return "redirect:/";
    }

    @GetMapping("/remove-all")
    public String removeAll() {
        if (currentUser.isNotActive()) {
            return "redirect:/users/login";
        }
        wordService.removeAll();
        return "redirect:/";

    }


    @ModelAttribute
    private WordAddDTO wordAddDTO() {
        return new WordAddDTO();
    }

}
