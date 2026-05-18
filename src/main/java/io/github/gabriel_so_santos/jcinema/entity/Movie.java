package io.github.gabriel_so_santos.jcinema.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "movie")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String title;

    @Column
    private String description;

    @Column
    private double rating;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    private Instant createdAt;

    @Column(name = "updated_at", nullable = false)
    @UpdateTimestamp
    private Instant updatedAt;

    @ManyToMany
    @JoinTable(
        name = "movie_classification",
        joinColumns = @JoinColumn(name = "movie_id"),
        inverseJoinColumns = @JoinColumn(name = "movie_category_id")
    )
    private List<MovieCategory> categories;

    @ManyToMany
    @JoinTable(
        name = "movie_availability",
        joinColumns = @JoinColumn(name = "movie_id"),
        inverseJoinColumns = @JoinColumn(name = "streaming_platform_id")
    )
    private List<StreamingPlatform> streamingPlatforms;
}

