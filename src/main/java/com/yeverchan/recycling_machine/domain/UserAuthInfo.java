package com.yeverchan.recycling_machine.domain;

import java.util.Objects;

public class UserAuthInfo {
    private String id;
    private String email;

    public UserAuthInfo(String id, String email) {
        this.id = id;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserAuthInfo that = (UserAuthInfo) o;
        return Objects.equals(id, that.id) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email);
    }

    @Override
    public String toString() {
        return "UserAuthInfo{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
