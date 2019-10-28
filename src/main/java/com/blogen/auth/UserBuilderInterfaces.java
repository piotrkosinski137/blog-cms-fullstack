package com.blogen.auth;

class UserBuilderInterfaces {

    public interface UserEmailInterface {
        UserPasswordInterface withEmail(String email);
    }

    public interface UserPasswordInterface {
        UserRoleInterface withPassword(String password);
    }

    public interface UserRoleInterface {
        User andRole(Role role);
    }
}
