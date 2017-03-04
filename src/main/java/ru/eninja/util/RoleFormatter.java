package ru.eninja.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import ru.eninja.domain.Role;
import ru.eninja.service.RoleService;

import java.text.ParseException;
import java.util.Locale;


public class RoleFormatter implements Formatter<Role> {

    @Autowired
    private RoleService roleService;

    @Override
    public Role parse(String idStr, Locale locale) throws ParseException {
        try {
            int id = Integer.parseInt(idStr);
            Role role = roleService.getRoleById(id);
            if (role == null) {
                throw new ParseException("Role not found", 0);
            }
            return role;
        } catch (Exception e) {
            throw new ParseException(e.getMessage(), 0);
        }
    }

    @Override
    public String print(Role role, Locale locale) {
        return role.getId().toString();
    }
}
