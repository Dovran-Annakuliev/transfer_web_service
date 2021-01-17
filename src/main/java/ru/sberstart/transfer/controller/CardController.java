package ru.sberstart.transfer.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.sberstart.transfer.model.Card;
import ru.sberstart.transfer.service.CardService;
import ru.sberstart.transfer.service.UsersService;

import javax.validation.Valid;

@Controller
@RequestMapping("/cards")
public class CardController {
    private final CardService cardService;
    private final UsersService usersService;

    @Autowired
    public CardController(CardService cardService, UsersService usersService) {
        this.cardService = cardService;
        this.usersService = usersService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("cards", cardService.getCards());
        return "cards/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        model.addAttribute("card", cardService.getCard(id));
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

        System.out.println(card.toString());

        cardService.createUCard(card);
        return "redirect:/cards";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("card", cardService.getCard(id));
        return "/cards/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("card") @Valid Card card, BindingResult bindingResult,
                         @PathVariable("id") Long id) {
        if (bindingResult.hasErrors())
            return "/cards/edit";

        cardService.updateCard(id, card);
        return "redirect:/cards";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        cardService.deleteCard(id);
        return "redirect:/cards";
    }
}
