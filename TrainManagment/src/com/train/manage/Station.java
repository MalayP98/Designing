package com.train.manage;

import java.util.HashMap;

public class Station {

    private Integer id;

    private String name;

    private HashMap<Integer, Train> platforms = new HashMap<>();

    public Station(Integer id, String name, int platformCount) {
        this.id = id;
        this.name = name;
        for (int i = 1; i <= platformCount; i++) {
            this.platforms.put(i, null);
        }
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "{" + id + ", " + name + ", " + platforms.size() + "}";
    }
}
