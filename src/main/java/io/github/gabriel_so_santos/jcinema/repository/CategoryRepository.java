package io.github.gabriel_so_santos.jcinema.repository;

import io.github.gabriel_so_santos.jcinema.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {}
