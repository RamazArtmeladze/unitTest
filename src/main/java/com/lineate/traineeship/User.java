package com.lineate.traineeship;

import java.util.HashSet;
import java.util.Set;

public class User {
    private final String name;
    private final Set<Group> groups = new HashSet<>();

    public User(String name, Group group) {
        this.name = name;
        groups.add(group);
    }

    public String getName() {
        return name;
    }

    public Set<Group> getGroups() {
        return groups;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof User)) {
            return false;
        }

        User user = (User) o;

        return name.equals(user.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
