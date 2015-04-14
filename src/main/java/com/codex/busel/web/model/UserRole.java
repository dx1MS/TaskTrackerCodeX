package com.codex.busel.web.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

//User-Role
@Entity
@Table(name = "ROLE")
public class UserRole {

    @Id
    @Column(name = "USER_ROLE_ID")
    private Long id;

    @Enumerated(EnumType.STRING)
    private ListRole listRole;

    @Column(name = "USER_ID")
    @ManyToMany(mappedBy = "userRoles")
    private Set<User> userList = new HashSet<User>();
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "ROLE_ID")
//    private Long roleID;

//    public Long getRoleID() {
//        return roleID;
//    }
//
//    public void setRoleID(Long roleID) {
//        this.roleID = roleID;
//    }

    public ListRole getListRole() {
        return listRole;
    }

    public void setListRole(ListRole listRole) {
        this.listRole = listRole;
    }

//    public Set<User> getUserList() {
//        return userList;
//    }

    public void setUserList(Set<User> userList) {
        this.userList = userList;
    }



//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Role role1 = (Role) o;
//
//        if (listRole != null ? !listRole.equals(role1.listRole) : role1.listRole != null) return false;
//        if (!roleID.equals(role1.roleID)) return false;
////        if (user != null ? !user.equals(role1.user) : role1.user != null) return false;
//            return true;
//        }
//
//    @Override
//    public int hashCode() {
//        int result = roleID.hashCode();
//        result = 31 * result + (listRole != null ? listRole.hashCode() : 0);
////        result = 31 * result + (user != null ? user.hashCode() : 0);
//        return result;
//    }
}