package co.istad.jparelationship;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "chapters")
public class Chapter {

    @Id
    private String id;

    private String title;

    @Column(name = "page_id")
    private Integer pageNo;

    private String description;

    @ManyToOne
    private Book book;

}
