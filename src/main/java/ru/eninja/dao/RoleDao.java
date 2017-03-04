package ru.eninja.dao;

import org.springframework.data.repository.CrudRepository;
import ru.eninja.domain.Role;


public interface RoleDao extends CrudRepository<Role, Integer> {
    Role findByAuthority(String authority);
}
