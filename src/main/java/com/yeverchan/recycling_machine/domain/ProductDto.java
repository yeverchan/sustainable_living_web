package com.yeverchan.recycling_machine.domain;

import java.util.Date;
import java.util.Objects;

public class ProductDto {
    private String user_id;
    private String name;
    private String description;
    private Long price;
    private Date created_At;

    public ProductDto() {
    }

    public ProductDto(String user_id, String name, String description, Long price){
        this.user_id = user_id;
        this.name = name;
        this.description = description;
        this.price = price;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
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
        ProductDto that = (ProductDto) o;
        return Objects.equals(user_id, that.user_id) && Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(price, that.price) && Objects.equals(created_At, that.created_At);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user_id, name, description, price, created_At);
    }

    @Override
    public String toString() {
        return "ProductDto{" +
                "user_id='" + user_id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", created_At=" + created_At +
                '}';
    }
}
