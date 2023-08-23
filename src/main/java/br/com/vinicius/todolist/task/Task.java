package br.com.vinicius.todolist.task;

import jakarta.persistence.*;


import java.time.LocalDateTime;
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String time;
    public Task(TaskData data) {
        this.title = data.title();
        this.description = data.description();
        this.time = data.time();
    }

    public Task() {
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getTime() {
        return time;
    }


    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", dateTime=" + time +
                '}';
    }

    public void updateTask(TaskUpdateData data) {
        this.title = data.title();
        this.description = data.description();
        this.time = data.time();
    }
}
