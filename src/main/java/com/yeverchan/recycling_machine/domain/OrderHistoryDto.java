package com.yeverchan.recycling_machine.domain;

import java.util.Date;
import java.util.Objects;

public class OrderHistoryDto {
    private String user_id;
    private int product_id;
    private String orderer_name;
    private String orerer_address;
    private String orerer_phone_number;
    private Date created_At;

    public OrderHistoryDto() {
    }

    public OrderHistoryDto(String user_id, int product_id, String orderer_name, String orerer_address, String orerer_phone_number, Date created_At) {
        this.user_id = user_id;
        this.product_id = product_id;
        this.orderer_name = orderer_name;
        this.orerer_address = orerer_address;
        this.orerer_phone_number = orerer_phone_number;
        this.created_At = created_At;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getOrderer_name() {
        return orderer_name;
    }

    public void setOrderer_name(String orderer_name) {
        this.orderer_name = orderer_name;
    }

    public String getOrerer_address() {
        return orerer_address;
    }

    public void setOrerer_address(String orerer_address) {
        this.orerer_address = orerer_address;
    }

    public String getOrerer_phone_number() {
        return orerer_phone_number;
    }

    public void setOrerer_phone_number(String orerer_phone_number) {
        this.orerer_phone_number = orerer_phone_number;
    }

    public Date getCreated_At() {
        return created_At;
    }

    public void setCreated_At(Date created_At) {
        this.created_At = created_At;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderHistoryDto that = (OrderHistoryDto) o;
        return product_id == that.product_id && Objects.equals(user_id, that.user_id) && Objects.equals(orderer_name, that.orderer_name) && Objects.equals(orerer_address, that.orerer_address) && Objects.equals(orerer_phone_number, that.orerer_phone_number) && Objects.equals(created_At, that.created_At);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user_id, product_id, orderer_name, orerer_address, orerer_phone_number, created_At);
    }

    @Override
    public String toString() {
        return "OrderHistoryDto{" +
                "user_id='" + user_id + '\'' +
                ", product_id=" + product_id +
                ", orderer_name='" + orderer_name + '\'' +
                ", orerer_address='" + orerer_address + '\'' +
                ", orerer_phone_number='" + orerer_phone_number + '\'' +
                ", created_At=" + created_At +
                '}';
    }
}

