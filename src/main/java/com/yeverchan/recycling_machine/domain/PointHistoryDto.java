package com.yeverchan.recycling_machine.domain;

import java.util.Date;
import java.util.Objects;

public class PointHistoryDto {
    private int id;
    private int point_id;
    private String service_type;
    private String service_description;
    private Long amount;
    private Date created_At;

    public PointHistoryDto() {
    }

    public PointHistoryDto(int point_id, String service_type, String service_description, Long amount) {
        this.point_id = point_id;
        this.service_type = service_type;
        this.service_description = service_description;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPoint_id() {
        return point_id;
    }

    public void setPoint_id(int point_id) {
        this.point_id = point_id;
    }

    public String getService_type() {
        return service_type;
    }

    public void setService_type(String service_type) {
        this.service_type = service_type;
    }

    public String getService_description() {
        return service_description;
    }

    public void setService_description(String service_description) {
        this.service_description = service_description;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
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
        PointHistoryDto that = (PointHistoryDto) o;
        return id == that.id && point_id == that.point_id && Objects.equals(service_type, that.service_type) && Objects.equals(service_description, that.service_description) && Objects.equals(amount, that.amount) && Objects.equals(created_At, that.created_At);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, point_id, service_type, service_description, amount, created_At);
    }

    @Override
    public String toString() {
        return "PointHistoryDto{" +
                "id=" + id +
                ", point_id=" + point_id +
                ", service_type='" + service_type + '\'' +
                ", service_description='" + service_description + '\'' +
                ", amount=" + amount +
                ", created_At=" + created_At +
                '}';
    }
}
