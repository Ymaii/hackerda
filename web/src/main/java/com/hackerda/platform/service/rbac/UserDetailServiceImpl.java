package com.hackerda.platform.service.rbac;

import com.hackerda.platform.dao.StudentUserDao;
import com.hackerda.platform.dao.rbac.RoleDao;
import com.hackerda.platform.pojo.Permission;
import com.hackerda.platform.pojo.Role;
import com.hackerda.platform.pojo.StudentUserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author JR Chan
 */
@Service
public class UserDetailServiceImpl implements UserDetailService {

    @Autowired
    private StudentUserDao studentUserDao;
    @Autowired
    private RoleDao roleDao;

    @Override
    public StudentUserDetail getStudentUserDetail(String account) {

        StudentUserDetail detail = new StudentUserDetail();
        List<Role> roleList = studentUserDao.selectRoleByAccount(account);

        List<Permission> permissionList = roleList.stream()
                .map(x -> roleDao.selectPermissionById(x.getId()))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        detail.setRoleSet(new HashSet<>(roleList));
        detail.setPermissionSet(new HashSet<>(permissionList));

        return detail;
    }


    public StudentUserDetail authzStudent(String account) {

        StudentUserDetail detail = new StudentUserDetail();
        List<Role> roleList = studentUserDao.selectRoleByAccount(account);

        List<Permission> permissionList = roleList.stream()
                .map(x -> roleDao.selectPermissionById(x.getId()))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        detail.setRoleSet(new HashSet<>(roleList));
        detail.setPermissionSet(new HashSet<>(permissionList));

        return detail;
    }
}