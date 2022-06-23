package com.bigelmo.data;

import lombok.Data;

import java.time.Instant;

@Data
public class Task {
    private final long id;
    private String name;
    private String description;
    private boolean isSolved;
    private final long createdAt;
    private long completedAt;
    private long solveBefore;
    private int priority;

    public Task(long id, String name, String description, long solveBefore, int priority) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.solveBefore = solveBefore;
        this.priority = priority;
        this.isSolved = false;
        this.createdAt = Instant.now().getEpochSecond();
    }

    public boolean isCompleted() {
        return this.completedAt > 0;
    }

    @Override
    public String toString() {
        return "Task #" + id + (isSolved ? " Solved" : " Not solved");
    }
}
