package io.github.gabriel_so_santos.jcinema.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "movie_category")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MovieCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false, unique = true)
    private String name;
}
