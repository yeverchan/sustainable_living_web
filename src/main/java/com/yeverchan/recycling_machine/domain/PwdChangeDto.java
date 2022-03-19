package com.yeverchan.recycling_machine.domain;

import java.util.Objects;

public class PwdChangeDto {
    private String current;
    private String newPwd;
    private String checkNewPwd;

    public PwdChangeDto(String current, String newPwd, String checkNewPwd) {
        this.current = current;
        this.newPwd = newPwd;
        this.checkNewPwd = checkNewPwd;
    }

    public String getCurrent() {
        return current;
    }

    public void setCurrent(String current) {
        this.current = current;
    }

    public String getNewPwd() {
        return newPwd;
    }

    public void setNewPwd(String newPwd) {
        this.newPwd = newPwd;
    }

    public String getCheckNewPwd() {
        return checkNewPwd;
    }

    public void setCheckNewPwd(String checkNewPwd) {
        this.checkNewPwd = checkNewPwd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PwdChangeDto that = (PwdChangeDto) o;
        return Objects.equals(current, that.current) && Objects.equals(newPwd, that.newPwd) && Objects.equals(checkNewPwd, that.checkNewPwd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(current, newPwd, checkNewPwd);
    }

    @Override
    public String toString() {
        return "PwdChangeDto{" +
                "current='" + current + '\'' +
                ", newPwd='" + newPwd + '\'' +
                ", checkNewPwd='" + checkNewPwd + '\'' +
                '}';
    }
}
