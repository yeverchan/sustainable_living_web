package com.yeverchan.recycling_machine.domain;

import java.util.Objects;

public class RegisterDto {

    private String id;
    private String password;
    private String checkPassword;
    private String email;
    private String name;

    public RegisterDto() {
    }

    public RegisterDto(String id, String password, String checkPassword, String email, String name) {
        this.id = id;
        this.password = password;
        this.checkPassword = checkPassword;
        this.email = email;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCheckPassword() {
        return checkPassword;
    }

    public void setCheckPassword(String checkPassword) {
        this.checkPassword = checkPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegisterDto that = (RegisterDto) o;
        return Objects.equals(id, that.id) && Objects.equals(password, that.password) && Objects.equals(checkPassword, that.checkPassword) && Objects.equals(email, that.email) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, password, checkPassword, email, name);
    }
}
