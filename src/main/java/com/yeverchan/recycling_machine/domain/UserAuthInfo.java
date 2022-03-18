package com.yeverchan.recycling_machine.domain;

import java.util.Objects;

public class UserAuthInfo {
    private String id;
    private String name;
    private String email;
    private Long amount;

    public UserAuthInfo(String id, String email, String name, Long amount) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserAuthInfo authInfo = (UserAuthInfo) o;
        return Objects.equals(id, authInfo.id) && Objects.equals(name, authInfo.name) && Objects.equals(email, authInfo.email) && Objects.equals(amount, authInfo.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, amount);
    }

    @Override
    public String toString() {
        return "UserAuthInfo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", amount=" + amount +
                '}';
    }
}
