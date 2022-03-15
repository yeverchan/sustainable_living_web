package com.yeverchan.recycling_machine.domain;

import java.util.Date;
import java.util.Objects;

public class UserDto {

    private String id;
    private String password;
    private String email;
    private String name;

    public UserDto(){}

    public UserDto(String id, String password){
        this.id = id;
        this.password = password;
    }

    public UserDto(String id, String password, String email, String name) {
        this.id = id;
        this.password = password;
        this.email = email;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto userDto = (UserDto) o;
        return Objects.equals(id, userDto.id) && Objects.equals(password, userDto.password) && Objects.equals(email, userDto.email) && Objects.equals(name, userDto.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, password, email, name);
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
    public String toString() {
        return "UserDto{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
