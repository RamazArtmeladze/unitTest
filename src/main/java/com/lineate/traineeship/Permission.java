package com.lineate.traineeship;

public enum Permission {
    READ(0),
    WRITE(1);

    private final int level;

    Permission(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}
