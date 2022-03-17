package com.example.todo;

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

    String title;

    String body;

    @ElementCollection
            @CollectionTable(name = "blog_tags", joinColumns = @JoinColumn(name = "blog_id", referencedColumnName = "id"))
            @JoinColumn(name = "tag")
    List<String> tags = new ArrayList<>();
}
