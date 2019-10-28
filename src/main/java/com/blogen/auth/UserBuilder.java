package com.blogen.auth;

public class UserBuilder implements
        UserBuilderInterfaces.UserEmailInterface,
        UserBuilderInterfaces.UserPasswordInterface,
        UserBuilderInterfaces.UserRoleInterface
{

    private User user;

    private UserBuilder() {
        user = new User();
    }

    public static UserBuilderInterfaces.UserEmailInterface getInstance(){
        return new UserBuilder();
    }

    @Override
    public UserBuilderInterfaces.UserPasswordInterface withEmail(String email) {
        user.setCredentialsEmail(email);
        return this;
    }

    @Override
    public UserBuilderInterfaces.UserRoleInterface withPassword(String password) {
        user.setCredentialsPassword(password);
        return this;
    }

    @Override
    public User andRole(Role role) {
        user.setRole(role);
        return user;
    }
}
