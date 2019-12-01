package com.wwt.expertservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.Arrays;

@Document("Expert")
public class Expert implements Serializable {
    @Id
    @Field("expertId")
    private String expertId;
    @Field("department")
    private String department;
    @Field("profile")
    private String profile;
    @Field("phone")
    private String phone;
    @Field("field")
    private String[] field;
    @Field("paperNumber")
    private String[] paperNumber;
    @Field("isCertificated")
    private boolean isCertificated;
    @Field("name")
    private String name;
    @Field("email")
    private String email;
    @Field("position")
    private String position;

    public String getExpertId() {
        return expertId;
    }

    public void setExpertId(String expertId) {
        this.expertId = expertId;
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

    public String[] getPaperNumber() {
        return paperNumber;
    }

    public void setPaperNumber(String[] paperNumber) {
        this.paperNumber = paperNumber;
    }

    public boolean isCertificated() {
        return isCertificated;
    }

    public void setCertificated(boolean certificated) {
        this.isCertificated = certificated;
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
        return "{Expert\':{"
                + "\'expert_id\':\'"
                + expertId + '\''
                + ",\'department\':\'"
                + department + '\''
                + ",\'profile\':\'"
                + profile + '\''
                + ",\'phone\':\'"
                + phone + '\''
                + ",\'field\':"
                + Arrays.toString(field)
                + ",\'paper_number\':"
                + Arrays.toString(paperNumber)
                + ",\'is_certificated\':"
                + isCertificated
                + ",\'name\':\'"
                + name + '\''
                + ",\'e_mail\':\'"
                + email + '\''
                + ",\'position\':\'"
                + position + '\''
                + "}}";

    }

}


