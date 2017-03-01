package ru.eninja.util;

import org.springframework.format.Formatter;
import ru.eninja.domain.Role;

import java.text.ParseException;
import java.util.Locale;


public class RoleFormatter implements Formatter<Role> {
    @Override
    public Role parse(String id, Locale locale) throws ParseException {
        try {
            Role role = new Role();
            role.setId(Integer.parseInt(id));
            return role;
        } catch (NumberFormatException e) {
            throw new ParseException(e.getMessage(), 0);
        }
    }

    @Override
    public String print(Role role, Locale locale) {
        return role.getId().toString();
    }
}
