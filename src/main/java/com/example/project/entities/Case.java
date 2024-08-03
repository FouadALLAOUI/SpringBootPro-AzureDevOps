package com.example.project.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name = "cases")
@Data @NoArgsConstructor @AllArgsConstructor
public class Case {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long caseid;
    @CreationTimestamp
    private Date creationDate;
    @UpdateTimestamp
    private Date lastUpdateDate;

    private String title;

    private String description;


    public Case(String title, String description) {
        this.title = title;
        this.description = description;
    }
}