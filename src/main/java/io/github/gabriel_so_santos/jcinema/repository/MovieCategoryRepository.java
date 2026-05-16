package io.github.gabriel_so_santos.jcinema.repository;

import io.github.gabriel_so_santos.jcinema.entity.MovieCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieCategoryRepository extends JpaRepository<MovieCategory,Long> {}
