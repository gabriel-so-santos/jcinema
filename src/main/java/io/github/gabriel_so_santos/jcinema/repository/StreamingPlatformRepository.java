package io.github.gabriel_so_santos.jcinema.repository;

import io.github.gabriel_so_santos.jcinema.entity.StreamingPlatform;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StreamingPlatformRepository extends JpaRepository<StreamingPlatform, Long> {}
