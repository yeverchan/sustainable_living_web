package com.yeverchan.recycling_machine.domain;

import java.util.Date;
import java.util.Objects;

public class UserHistoryDto {
    private String user_id;
    private String name;
    private String email;
    private Date updated_At;

    public UserHistoryDto() {
    }

    public UserHistoryDto(String user_id, String name, String email) {
        this.user_id = user_id;
        this.name = name;
        this.email = email;
    }

    public UserHistoryDto(String user_id, String name, String email, Date updated_At) {
        this.user_id = user_id;
        this.name = name;
        this.email = email;
        this.updated_At = updated_At;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getUpdated_At() {
        return updated_At;
    }

    public void setUpdated_At(Date updated_At) {
        this.updated_At = updated_At;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserHistoryDto that = (UserHistoryDto) o;
        return Objects.equals(user_id, that.user_id) && Objects.equals(name, that.name) && Objects.equals(email, that.email) && Objects.equals(updated_At, that.updated_At);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user_id, name, email, updated_At);
    }

    @Override
    public String toString() {
        return "UserHistoryDto{" +
                "user_id='" + user_id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", updated_At=" + updated_At +
                '}';
    }
}
