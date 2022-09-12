package com.group.notes.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Notes implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id; //id not updatable
    private String title;
    private String content;

    public Notes(){}

    public Notes(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Long getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

}
