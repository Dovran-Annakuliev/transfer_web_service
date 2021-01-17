package ru.sberstart.transfer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.sberstart.transfer.model.User;
import ru.sberstart.transfer.service.UsersService;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UsersController {
    private final UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }
//
//    public UsersController(UsersService usersService) {
//        this.usersService = usersService;
//    }
//
//    @GetMapping
//    public List<User> getUsers() {
//        return usersService.getUsers();
//    }



    @GetMapping()
    public String index(Model model) {
        model.addAttribute("users", usersService.getUsers());
        return "people/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        model.addAttribute("person", usersService.getUser(id));
        return "people/show";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "users/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "users/new";

        usersService.createUser(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("person", usersService.getUser(id));
        return "people/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") @Valid User user, BindingResult bindingResult,
                         @PathVariable("id") Long id) {
        if (bindingResult.hasErrors())
            return "people/edit";

        usersService.updateUser(id, user);
        return "redirect:/people";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        usersService.deleteUser(id);
        return "redirect:/people";
    }
}
