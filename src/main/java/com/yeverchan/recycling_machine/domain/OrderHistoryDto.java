package com.yeverchan.recycling_machine.domain;

import java.util.Date;
import java.util.Objects;

public class OrderHistoryDto {
    private String user_id;
    private int id;
    private String orderer_name;
    private String orderer_address;
    private String orderer_phone_number;
    private Date created_At;
    private String name;

    public OrderHistoryDto() {
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderer_name() {
        return orderer_name;
    }

    public void setOrderer_name(String orderer_name) {
        this.orderer_name = orderer_name;
    }

    public String getOrderer_address() {
        return orderer_address;
    }

    public void setOrderer_address(String orderer_address) {
        this.orderer_address = orderer_address;
    }

    public String getOrderer_phone_number() {
        return orderer_phone_number;
    }

    public void setOrderer_phone_number(String orderer_phone_number) {
        this.orderer_phone_number = orderer_phone_number;
    }

    public Date getCreated_At() {
        return created_At;
    }

    public void setCreated_At(Date created_At) {
        this.created_At = created_At;
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
        OrderHistoryDto that = (OrderHistoryDto) o;
        return id == that.id && Objects.equals(user_id, that.user_id) && Objects.equals(orderer_name, that.orderer_name) && Objects.equals(orderer_address, that.orderer_address) && Objects.equals(orderer_phone_number, that.orderer_phone_number) && Objects.equals(created_At, that.created_At) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user_id, id, orderer_name, orderer_address, orderer_phone_number, created_At, name);
    }

    @Override
    public String toString() {
        return "OrderHistoryDto{" +
                "user_id='" + user_id + '\'' +
                ", id=" + id +
                ", orderer_name='" + orderer_name + '\'' +
                ", orderer_address='" + orderer_address + '\'' +
                ", orderer_phone_number='" + orderer_phone_number + '\'' +
                ", created_At=" + created_At +
                ", name='" + name + '\'' +
                '}';
    }
}

