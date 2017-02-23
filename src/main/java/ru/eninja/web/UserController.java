package ru.eninja.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.eninja.domain.User;
import ru.eninja.service.RoleService;
import ru.eninja.service.UserService;

import javax.validation.Valid;


@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    /**
     * Shows user list
     */
    @RequestMapping(method = RequestMethod.GET)
    public String usersPage(Model model) {
        model.addAttribute(userService.getUserList());
        return "users/list";
    }

    /**
     * Shows adding user form
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addUserPage(Model model) {
        model.addAttribute(new User());
        model.addAttribute(roleService.getRoleList());
        return "users/add";
    }

    /**
     * Adds user
     *
     * @param user user to add
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addUser(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "users/add";
        }
        userService.addUser(user);
        return "redirect:/users";
    }

    /**
     * Shows editing user form
     */
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editUserPage(@RequestParam("id") long id, Model model) {
        model.addAttribute(userService.getUserById(id));
        return "users/edit";
    }

    /**
     * Edits user
     *
     * @param user user to edit
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editUser(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "users/add";
        }
        userService.updateUser(user);
        return "redirect:/users";
    }

    /**
     * Deletes user
     *
     * @param id id of user to delete
     */
    @RequestMapping(value = "/delete")
    public String deleteUser(@RequestParam("id") long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}
