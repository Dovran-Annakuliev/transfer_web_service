package ru.sberstart.transfer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.sberstart.transfer.model.History;
import ru.sberstart.transfer.service.HistorysService;

import javax.validation.Valid;

@Controller
@RequestMapping("/historys")
public class HistoryController {
    private final HistorysService historysService;

    @Autowired
    public HistoryController(HistorysService historysService) {
        this.historysService = historysService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("historys", historysService.getHistorys());
        return "historys/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        model.addAttribute("history", historysService.getHistory(id));
        return "historys/show";
    }

    @GetMapping("/new")
    public String newHistory(@ModelAttribute("history") History history) {
        return "historys/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("history") @Valid History history, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "historys/new";

        historysService.createHistory(history);
        return "redirect:/historys";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("history", historysService.getHistory(id));
        return "/historys/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("history") @Valid History history, BindingResult bindingResult,
                         @PathVariable("id") Long id) {
        if (bindingResult.hasErrors())
            return "/historys/edit";

        historysService.updateHistory(id, history);
        return "redirect:/historys";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        historysService.deleteHistory(id);
        return "redirect:/historys";
    }
}
