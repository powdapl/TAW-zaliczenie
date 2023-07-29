package com.example.projekt;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Subject {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("nazwa")
    private String name;

    @JsonProperty("ects")
    private Integer ects;

    @JsonProperty("sala")
    private Integer sala;
    @JsonProperty("egzamin")
    private String egzamin;

    public Subject() {}
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getEcts() {
        return ects;
    }
    public void setEcts (Integer ects) {
        this.ects = ects;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getSala() {
        return sala;
    }
    public void setSala(Integer sala) {
        this.sala = sala;
    }
    public String getEgzamin() {
        return egzamin;
    }
    public void setEgzamin(String egzamin) {
        this.egzamin = egzamin;
    }
}
