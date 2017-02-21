package ru.eninja.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.eninja.domain.User;
import ru.eninja.service.UserService;

@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public String test() {

        User user = new User("login", "pass", "email@email", "odmen");
        // проверка добавления пользователя в базу
        Long aLong = userService.addUser(user).getId();

        // проверка поиска по логину
        User login = userService.getUserByLogin("login");

        User valid = userService.getUserByLoginAndPassword("kolya-t", "qwerty");
        User notValid = userService.getUserByLoginAndPassword("kolya-t", "fgfgg");

        // проверка удаления
        userService.deleteUser(aLong);

        return "redirect:/";
    }
}
