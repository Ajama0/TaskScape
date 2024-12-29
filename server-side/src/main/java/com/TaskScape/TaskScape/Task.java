package com.TaskScape.TaskScape;


import com.TaskScape.TaskScape.Constants.Priority;
import com.TaskScape.TaskScape.Constants.Status;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.ZoneId;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "Tasks")
@JsonInclude(JsonInclude.Include.NON_NULL)
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
    private LocalDate createddate;

    @Column(name = "updated_at")
    private LocalDate updatedat;



    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;


    public Task(String title, String description, Priority priority,
                LocalDate date) {
        this.Title = title;
        this.description = description;
        this.priority = priority;
        this.date = date;
        this.updatedat = LocalDate.now(ZoneId.of("GMT"));
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
