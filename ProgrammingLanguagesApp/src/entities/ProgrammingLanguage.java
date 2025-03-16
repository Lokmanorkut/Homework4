package entities;

import common.BaseEntity;

public class ProgrammingLanguage extends BaseEntity {
    private int id;
    private String name;

    public ProgrammingLanguage(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}