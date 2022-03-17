package com.example.blog;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Blog implements Serializable {
    @Id
            @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(length = 30)
    String title;

    String body;

    @ElementCollection
            @CollectionTable(name = "blog_tags", joinColumns = @JoinColumn(name = "blog_id", referencedColumnName = "id"))
            @JoinColumn(name = "tag")
    List<String> tags = new ArrayList<>();
}
