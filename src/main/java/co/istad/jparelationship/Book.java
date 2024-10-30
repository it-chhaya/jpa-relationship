package co.istad.jparelationship;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String code;
    private String title;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL,
        orphanRemoval = true)
    private List<Chapter> chapters = new ArrayList<>();

    @ManyToOne
    private Author author;

}
