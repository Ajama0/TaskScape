package com.TaskScape.Models;


import com.TaskScape.Constants.Priority;
import com.TaskScape.Constants.Status;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.ZoneId;



@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "Tasks")
public class Task {



    @SequenceGenerator(name = "Task_id",
            sequenceName = "Task_id",
            allocationSize = 1

    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "Task_id")

    @Id
    private Long id;

    @Column(name = "title", nullable = false)
    private String Title;

    @Column(name = "description")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "priority")
    private Priority priority;

    @Column(name = "due_date", nullable = false)
    private LocalDate date;

    @Column(name = "created_date")
    private LocalDate createdDate;

    @Column(name = "updated_at")
    private LocalDate updateDate;



    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;


    public Task(String title, String description, Priority priority,
                LocalDate date) {
        this.Title = title;
        this.description = description;
        this.priority = priority;
        this.date = date;
        this.updateDate = LocalDate.now(ZoneId.of("GMT"));
    }

    public Task(){}

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return Title;
    }

    public String getDescription() {
        return description;
    }

    public Priority getPriority() {
        return priority;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public LocalDate getUpdateDate() {
        return updateDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public void setUpdateDate(LocalDate updateDate) {
        this.updateDate = updateDate;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", Title='" + Title + '\'' +
                ", description='" + description + '\'' +
                ", priority=" + priority +
                ", date=" + date +
                ", status=" + status +
                '}';
    }
}
