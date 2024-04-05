package com.ykic;

public class Couple {
    public int id;
    public String name;

    public Couple(int id, String string) {
        this.id = id;
        this.name = string;
    }

    @Override
    public String toString() {
        return "Couple{" +
                "id=" + id +
                ", string='" + name + '\'' +
                '}';
    }
}
