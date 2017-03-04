package ru.eninja.service.impl;

import com.sun.istack.internal.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.eninja.dao.RoleDao;
import ru.eninja.domain.Role;
import ru.eninja.service.RoleService;

import java.util.List;


@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    private final RoleDao roleDao;

    @Autowired
    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public Role addRole(Role role) {
        return roleDao.save(role);
    }

    @Override
    public Iterable<? extends Role> addRoles(Iterable<? extends Role> roles) {
        return roleDao.save(roles);
    }

    @Override
    public Role getRoleById(Integer id) {
        return roleDao.findOne(id);
    }

    @Override
    public Role getRoleByAuthority(String authority) {
        return roleDao.findByAuthority(authority);
    }

    @Override
    public List<Role> getRoleList() {
        return (List<Role>) roleDao.findAll();
    }

    @Override
    public boolean exists(@NotNull Integer id) {
        return roleDao.exists(id);
    }

    @Override
    public long count() {
        return roleDao.count();
    }

    @Override
    public void updateRole(Role role) {
        roleDao.save(role);
    }

    @Override
    public void deleteRole(Integer id) {
        roleDao.delete(id);
    }

    @Override
    public void deleteRole(Role role) {
        roleDao.delete(role);
    }

    @Override
    public void deleteRoles(Iterable<? extends Role> roles) {
        roleDao.delete(roles);
    }

    @Override
    public void deleteAll() {
        roleDao.deleteAll();
    }
}
