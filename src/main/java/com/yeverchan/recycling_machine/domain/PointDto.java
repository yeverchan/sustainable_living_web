package com.yeverchan.recycling_machine.domain;

public class PointDto {
    private Integer id;
    private String user_id;
    private Long amount;

    public PointDto(String user_id) {
        this.user_id = user_id;
    }

    public PointDto(Long amount) {
        this.amount = amount;
    }

    public PointDto(Integer id) {
        this.id = id;
    }

    public Integer getId(){
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
