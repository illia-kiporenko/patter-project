package me.kiporenko.system.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String plot;

    private Integer likesNumber;
    private Integer dislikesNumber;

    @ManyToOne
    @JoinColumn(name = "blog_id")
    @JsonBackReference
    private Blog blog;

}
