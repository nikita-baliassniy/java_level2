package server.service;

import server.interfaces.AuthService;

import java.util.LinkedList;
import java.util.List;

public class AuthServiceImpl implements AuthService {

    private List<UserEntity> userList;

    public AuthServiceImpl() {
        this.userList = new LinkedList<>();
        this.userList.add(new UserEntity("login1", "password1", "nick1"));
        this.userList.add(new UserEntity("login2", "password2", "nick2"));
        this.userList.add(new UserEntity("login3", "password3", "nick3"));
    }

    @Override
    public void start() {
        System.out.println("Сервис аутентификации запущен");
    }

    @Override
    public String getNick(String login, String password) {
        for (UserEntity userEntity : userList) {
            if (userEntity.login.equals(login) && userEntity.password.equals(password)) {
                return userEntity.nick;
            }
        }
        return null;
    }

    @Override
    public void stop() {
        System.out.println("Сервис аутентификации остановлен");
    }


    private class UserEntity {
        private String login;
        private String password;
        private String nick;

        public UserEntity(String login, String password, String nick) {
            this.login = login;
            this.password = password;
            this.nick = nick;
        }
    }
}
