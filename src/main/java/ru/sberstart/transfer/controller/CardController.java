package ru.sberstart.transfer.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.sberstart.transfer.model.Card;
import ru.sberstart.transfer.service.CardsService;

import javax.validation.Valid;

@Controller
@RequestMapping("/cards")
public class CardController {
    private final CardsService cardsService;

    @Autowired
    public CardController(CardsService cardsService) {
        this.cardsService = cardsService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("cards", cardsService.getCards());
        return "cards/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        model.addAttribute("card", cardsService.getCard(id));
        return "cards/show";
    }

    @GetMapping("/new")
    public String newCard(@ModelAttribute("card") Card card) {
        return "cards/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("card") @Valid Card card, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "cards/new";

        cardsService.createCard(card);
        return "redirect:/cards";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("card", cardsService.getCard(id));
        return "/cards/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("card") @Valid Card card, BindingResult bindingResult,
                         @PathVariable("id") Long id) {
        if (bindingResult.hasErrors())
            return "/cards/edit";

        cardsService.updateCard(id, card);
        return "redirect:/cards";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        cardsService.deleteCard(id);
        return "redirect:/cards";
    }
}
