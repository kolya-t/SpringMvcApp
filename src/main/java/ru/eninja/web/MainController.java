package ru.eninja.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.eninja.domain.User;
import ru.eninja.service.UserService;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    UserService userService;

    @RequestMapping("/test")
    public String test(ModelMap map) {
        User userByLogin = userService.getUserByLogin("kolya-t");
        List<User> userList = userService.getUserList();
        map.addAttribute("userList", userList);
        return "index";
    }
}
