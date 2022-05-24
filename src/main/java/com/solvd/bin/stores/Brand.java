package com.solvd.bin.stores;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Brand {
    @JsonProperty
    private long id;
    @JsonProperty
    private String name;

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }  
}
