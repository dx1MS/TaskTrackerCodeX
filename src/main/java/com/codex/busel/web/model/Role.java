package com.codex.busel.web.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ROLE")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ROLE_ID")
    private Long roleID;

    @Column(name = "ROLE_NAME")
    private String roleName;

//    @Column(name = "USER_ID")
    @OneToMany(mappedBy = "role")
    // @PrimaryKeyJoinColumn
    private Set<User> userList; // todo Set<User> userList ???

    public Role() {
    }

    public Long getRoleID() {
        return roleID;
    }

    public void setRoleID(Long roleID) {
        this.roleID = roleID;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<User> getUserList() {
        return userList;
    }

    public void setUserList(Set<User> userList) {
        this.userList = userList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role1 = (Role) o;

        if (roleName != null ? !roleName.equals(role1.roleName) : role1.roleName != null) return false;
        if (!roleID.equals(role1.roleID)) return false;
//        if (user != null ? !user.equals(role1.user) : role1.user != null) return false;
            return true;
        }

    @Override
    public int hashCode() {
        int result = roleID.hashCode();
        result = 31 * result + (roleName != null ? roleName.hashCode() : 0);
//        result = 31 * result + (user != null ? user.hashCode() : 0);
        return result;
    }
}