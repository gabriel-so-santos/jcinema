package io.github.gabriel_so_santos.jcinema.service;

import io.github.gabriel_so_santos.jcinema.entity.MovieCategory;
import io.github.gabriel_so_santos.jcinema.repository.MovieCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieCategoryService {
    private final MovieCategoryRepository movieCategoryRepository;

    public List<MovieCategory> findAll() {
        return movieCategoryRepository.findAll();
    }

    public Optional<MovieCategory> findById(Long id) {
        return movieCategoryRepository.findById(id);
    }

    public MovieCategory save(MovieCategory category) {
        return movieCategoryRepository.save(category);
    }

    public void deleteById(Long id) {
        movieCategoryRepository.deleteById(id);
    }
}
