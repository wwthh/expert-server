package com.wwt.expertservice.model;

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
        return "{\'Tag\':{"
                + "\'t\':\'"
                + t + '\''
                + ",\'w\':"
                + w
                + "}}";

    }
}
class Pub{
    String i;
    int r;

    @Override
    public String toString() {
        return "{\'Pub\':{"
                + "\'i\':\'"
                + i + '\''
                + ",\'r\':"
                + r
                + "}}";

    }
}
@Document("Expert")
public class Expert implements Serializable {
    @Id
    @Field("id")
    private String id;
    @Field("name")
    private String name;
    @Field("orgs")
    private String[] orgs;
    @Field("org")
    private String org;
    @Field("n_pubs")
    private int npubs;
    @Field("n_citation")
    private int ncitation;
    @Field("h_index")
    private int hindex;
    @Field("tags")
    private Tag[] tags;
    @Field("pubs")
    private Pub[] pubs;

    
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

    public int getNpubs() {
        return npubs;
    }

    public void setNpubs(int npubs) {
        this.npubs = npubs;
    }

    public int getNcitation() {
        return ncitation;
    }

    public void setNcitation(int ncitation) {
        this.ncitation = ncitation;
    }

    public int getHindex() {
        return hindex;
    }

    public void setHindex(int hindex) {
        this.hindex = hindex;
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
        return "{\'Expert\':{"
                + "\'id\':\'"
                + id + '\''
                + ",\'name\':\'"
                + name + '\''
                + ",\'orgs\':"
                + Arrays.toString(orgs)
                + ",\'org\':\'"
                + org + '\''
                + ",\'n_pubs\':"
                + npubs
                + ",\'n_citation\':"
                + ncitation
                + ",\'h_index\':"
                + hindex
                + ",\'tags\':"
                + Arrays.toString(tags)
                + ",\'pubs\':"
                + Arrays.toString(pubs)
                + "}}";

    }
}


