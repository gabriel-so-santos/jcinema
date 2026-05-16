package io.github.gabriel_so_santos.jcinema.controller;

import io.github.gabriel_so_santos.jcinema.controller.request.MovieCategoryRequest;
import io.github.gabriel_so_santos.jcinema.controller.response.MovieCategoryResponse;
import io.github.gabriel_so_santos.jcinema.entity.MovieCategory;
import io.github.gabriel_so_santos.jcinema.mapper.MovieCategoryMapper;
import io.github.gabriel_so_santos.jcinema.service.MovieCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jcinema/movie-category")
@RequiredArgsConstructor
public class MovieCategoryController {
    private final MovieCategoryService movieCategoryService;

    @GetMapping
    public ResponseEntity<List<MovieCategoryResponse>> getAll() {
        List<MovieCategoryResponse> categories = movieCategoryService.findAll()
                .stream()
                .map(MovieCategoryMapper::toMovieCategoryResponse)
                .toList();

        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieCategoryResponse> getById(@PathVariable Long id) {
        return movieCategoryService.findById(id)
                .map(MovieCategoryMapper::toMovieCategoryResponse)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<MovieCategoryResponse> save(@RequestBody MovieCategoryRequest request) {
        MovieCategory newMovieCategory = MovieCategoryMapper.toMovieCategory(request);

        MovieCategoryResponse response = MovieCategoryMapper.toMovieCategoryResponse(
                movieCategoryService.save(newMovieCategory)
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        movieCategoryService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
