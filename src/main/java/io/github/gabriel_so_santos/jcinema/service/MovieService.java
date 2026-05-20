package io.github.gabriel_so_santos.jcinema.service;

import io.github.gabriel_so_santos.jcinema.entity.Movie;
import io.github.gabriel_so_santos.jcinema.entity.MovieCategory;
import io.github.gabriel_so_santos.jcinema.entity.StreamingPlatform;
import io.github.gabriel_so_santos.jcinema.exception.ResourceNotFoundException;
import io.github.gabriel_so_santos.jcinema.repository.MovieCategoryRepository;
import io.github.gabriel_so_santos.jcinema.repository.MovieRepository;
import io.github.gabriel_so_santos.jcinema.repository.StreamingPlatformRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;
    private final MovieCategoryRepository categoryRepository;
    private final StreamingPlatformRepository streamingPlatformRepository;

    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    public Optional<Movie> findById(Long id) {
        return movieRepository.findById(id);
    }

    public Movie save(Movie movie) {
        movie.setCategories(
                verifyCategories(movie.getCategories())
        );
        movie.setStreamingPlatforms(
                verifyPlatforms(movie.getStreamingPlatforms())
        );
        return movieRepository.save(movie);
    }

    public void deleteById(Long id) {
        movieRepository.deleteById(id);
    }

    private List<MovieCategory> verifyCategories(List<MovieCategory> categories) {
        return categories.stream()
                .map(category -> categoryRepository.findById(category.getId())
                        .orElseThrow(() -> new ResourceNotFoundException(
                                "Category not found with ID: " + category.getId()
                        )))

                .toList();
    }

    private List<StreamingPlatform> verifyPlatforms(List<StreamingPlatform> platforms) {
        return platforms.stream()
                .map(platform -> streamingPlatformRepository.findById(platform.getId())
                        .orElseThrow(() -> new ResourceNotFoundException(
                                "Streaming platform not found with ID: " + platform.getId()
                        )))
                .toList();
    }
}
