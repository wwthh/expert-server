package com.wwt.expertservice.model;

import com.alibaba.fastjson.JSON;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.Arrays;
class Tag{
    String t;
    int w;

    @Override
    public String toString() {
        return "{"
                + "\"t\":\""
                + t + '\"'
                + ",\"w\":"
                + w
                + "}";

    }
}
class Pub{
    String i;
    int r;

    @Override
    public String toString() {
        return "{"
                + "\"i\":\""
                + i + '\"'
                + ",\"r\":"
                + r
                + "}";

    }
}
@Document("Expert")
public class Expert implements Serializable {
    @Id
    @Field("_id")
    private String id;
    @Field("name")
    private String name;
    @Field("orgs")
    private String[] orgs;
    @Field("org")
    private String org;
    @Field("n_pubs")
    private int n_pubs;
    @Field("n_citation")
    private int n_citation;
    @Field("h_index")
    private int h_index;
    @Field("tags")
    private Tag[] tags;
    @Field("pubs")
    private Pub[] pubs;
    @Field("isCertification")
    private boolean isCertification;



    public boolean isCertification() {
        return isCertification;
    }

    public void setCertification(boolean certification) {
        isCertification = certification;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String[] getOrgs() {
        return orgs;
    }

    public void setOrgs(String[] orgs) {
        this.orgs = orgs;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public int getN_pubs() {
        return n_pubs;
    }

    public void setN_pubs(int n_pubs) {
        this.n_pubs = n_pubs;
    }

    public int getN_citation() {
        return n_citation;
    }

    public void setN_citation(int n_citation) {
        this.n_citation = n_citation;
    }

    public int getH_index() {
        return h_index;
    }

    public void setH_index(int h_index) {
        this.h_index = h_index;
    }

    public Tag[] getTags() {
        return tags;
    }

    public void setTags(Tag[] tags) {
        this.tags = tags;
    }

    public Pub[] getPubs() {
        return pubs;
    }

    public void setPubs(Pub[] pubs) {
        this.pubs = pubs;
    }

    @Override
    public String toString() {
        return "{"
                + "\"id\":\""
                + id + '\"'
                + ",\"name\":\""
                + name + '\"'
                + ",\"orgs\":"
                + JSON.toJSONString(orgs)
                + ",\"org\":\""
                + org + '\"'
                + ",\"n_pubs\":"
                + n_pubs
                + ",\"n_citation\":"
                + n_citation
                + ",\"h_index\":"
                + h_index
                + ",\"tags\":"
                + Arrays.toString(tags)
                + ",\"pubs\":"
                + Arrays.toString(pubs)
                + ",\"isCertification\":"
                + isCertification
                + "}";

    }
}


