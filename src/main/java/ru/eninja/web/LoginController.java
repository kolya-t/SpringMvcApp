package ru.eninja.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.eninja.domain.Role;
import ru.eninja.domain.User;
import ru.eninja.service.RoleService;
import ru.eninja.service.UserService;

import javax.validation.Valid;

import java.util.Arrays;
import java.util.HashSet;

import static org.springframework.web.bind.annotation.RequestMethod.*;


@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/login", method = GET)
    public String loginPage(
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout,
            Model model) {

        if (error != null) {
            model.addAttribute("errorMessage", "Invalid login or password");
        }
        if (logout != null) {
            model.addAttribute("successMessage", "You've been logged out successfully.");
        }

        return "login";
    }

    @RequestMapping(value = "signup", method = GET)
    public String signupPage(Model model) {
        model.addAttribute(new User());
        return "signup";
    }

    @RequestMapping(value = "signup", method = POST)
    public String signup(@Valid User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "signup";
        }

        //noinspection ArraysAsListWithZeroOrOneArgument
        user.setRoles(new HashSet<>(Arrays.asList(roleService.getRoleByAuthority("ROLE_USER"))));
        userService.addUser(user);
        return "redirect:/login";
    }
}
