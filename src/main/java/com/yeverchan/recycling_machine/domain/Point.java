package com.yeverchan.recycling_machine.domain;

public class Point {
    private Long id;
    private String user_id;
    private Long amount;

    public Point(String user_id) {
        this.user_id = user_id;
    }

    public Point(Long amount) {
        this.amount = amount;
    }

    public Point(String user_id, Long amount) {
        this.user_id = user_id;
        this.amount = amount;
    }

    public Long getId(){
        return id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}
