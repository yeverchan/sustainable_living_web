package com.yeverchan.recycling_machine.domain;

import java.util.Objects;

public class Order {
    private String ordererName;
    private String ordererAddress;
    private String ordererPhone;
    private int productId;
    private String productName;

    public Order() {
    }

    public Order(String ordererName, String ordererAddress, String ordererPhone, int productId, String productName) {
        this.ordererName = ordererName;
        this.ordererAddress = ordererAddress;
        this.ordererPhone = ordererPhone;
        this.productId = productId;
        this.productName = productName;
    }

    public String getOrdererName() {
        return ordererName;
    }

    public void setOrdererName(String ordererName) {
        this.ordererName = ordererName;
    }

    public String getOrdererAddress() {
        return ordererAddress;
    }

    public void setOrdererAddress(String ordererAddress) {
        this.ordererAddress = ordererAddress;
    }

    public String getOrdererPhone() {
        return ordererPhone;
    }

    public void setOrdererPhone(String ordererPhone) {
        this.ordererPhone = ordererPhone;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(ordererName, order.ordererName) && Objects.equals(ordererAddress, order.ordererAddress) && Objects.equals(ordererPhone, order.ordererPhone) && Objects.equals(productId, order.productId) && Objects.equals(productName, order.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ordererName, ordererAddress, ordererPhone, productId, productName);
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "ordererName='" + ordererName + '\'' +
                ", ordererAddress='" + ordererAddress + '\'' +
                ", ordererPhone='" + ordererPhone + '\'' +
                ", productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                '}';
    }
}
