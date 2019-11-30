package com.wwt.expertservice.model;

import com.alibaba.fastjson.JSONObject;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.Arrays;

@Document("Expert")
public class Expert implements Serializable {
    @Id
    @Field("id")
    private String expert_id;
    @Field("department")
    private String department;
    @Field("profile")
    private String profile;
    @Field("phone")
    private String phone;
    @Field("field")
    private String[] field;
    @Field("paper_number")
    private String[] paper_number;
    @Field("is_certificated")
    private boolean is_certificated;
    @Field("name")
    private String name;
    @Field("e_mail")
    private String email;
    @Field("position")
    private String position;

    public String getExpert_id() {
        return expert_id;
    }

    public void setExpert_id(String expert_id) {
        this.expert_id = expert_id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String[] getField() {
        return field;
    }

    public void setField(String[] field) {
        this.field = field;
    }

    public String[] getPaper_number() {
        return paper_number;
    }

    public void setPaper_number(String[] paper_number) {
        this.paper_number = paper_number;
    }

    public boolean isIs_certificated() {
        return is_certificated;
    }

    public void setIs_certificated(boolean is_certificated) {
        this.is_certificated = is_certificated;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }


    @Override
    public String toString() {
        return "{\"Expert\":{"
                + "\"expert_id\":\""
                + expert_id + '\"'
                + ",\"department\":\""
                + department + '\"'
                + ",\"profile\":\""
                + profile + '\"'
                + ",\"phone\":\""
                + phone + '\"'
                + ",\"field\":"
                + Arrays.toString(field)
                + ",\"paper_number\":"
                + Arrays.toString(paper_number)
                + ",\"is_certificated\":"
                + is_certificated
                + ",\"name\":\""
                + name + '\"'
                + ",\"e_mail\":\""
                + email + '\"'
                + ",\"position\":\""
                + position + '\"'
                + "}}";

    }

}


