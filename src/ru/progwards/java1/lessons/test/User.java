package ru.progwards.java1.lessons.test;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class User {
    public Integer id;
    public String name;

    User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    class compareUser implements Comparator<User> {
        @Override
        public int compare(User o1, User o2) {
            return o1.id - o2.id;
        }
    }

    public TreeSet<User> createSet() {
        Set set = new TreeSet(new compareUser());
        return new TreeSet<User>(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.id - o2.id;
            }

            @Override
            public boolean equals(Object obj) {
                return false;
            }
        });
    }
}
