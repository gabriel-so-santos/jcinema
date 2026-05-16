package io.github.gabriel_so_santos.jcinema.mapper;

import io.github.gabriel_so_santos.jcinema.controller.request.MovieCategoryRequest;
import io.github.gabriel_so_santos.jcinema.controller.response.MovieCategoryResponse;
import io.github.gabriel_so_santos.jcinema.entity.MovieCategory;
import lombok.experimental.UtilityClass;

@UtilityClass
public class MovieCategoryMapper {
    public MovieCategory toMovieCategory(MovieCategoryRequest request) {
        return MovieCategory.builder()
                .name(request.name())
                .build();
    }

    public MovieCategoryResponse toMovieCategoryResponse(MovieCategory category) {
        return MovieCategoryResponse.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }
}
