package io.github.gabriel_so_santos.jcinema.mapper;

import io.github.gabriel_so_santos.jcinema.controller.request.MovieRequest;
import io.github.gabriel_so_santos.jcinema.controller.response.MovieCategoryResponse;
import io.github.gabriel_so_santos.jcinema.controller.response.MovieResponse;
import io.github.gabriel_so_santos.jcinema.controller.response.StreamingPlatformResponse;
import io.github.gabriel_so_santos.jcinema.entity.Movie;
import io.github.gabriel_so_santos.jcinema.entity.MovieCategory;
import io.github.gabriel_so_santos.jcinema.entity.StreamingPlatform;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class MovieMapper {

    public static Movie toMovie(MovieRequest request) {

        List<MovieCategory> categories = request.categoryIds()
                .stream()
                .map(categoryId -> MovieCategory.builder().id(categoryId).build())
                .toList();

        List<StreamingPlatform> streamingPlatforms = request.streamingPlatformIds()
                .stream()
                .map(platformId -> StreamingPlatform.builder().id(platformId).build())
                .toList();

        return Movie.builder()
                .title(request.title())
                .description(request.description())
                .releaseDate(request.releaseDate())
                .rating(request.rating())
                .categories(categories)
                .streamingPlatforms(streamingPlatforms)
                .build();
    }

    public static MovieResponse toMovieResponse(Movie movie) {

        List<MovieCategoryResponse> categories = movie.getCategories()
                .stream()
                .map(MovieCategoryMapper::toMovieCategoryResponse)
                .toList();

        List<StreamingPlatformResponse> streamingPlatforms = movie.getStreamingPlatforms()
                .stream()
                .map(StreamingPlatformMapper::toStreamingPlatformResponse)
                .toList();

        return MovieResponse.builder()
                .id(movie.getId())
                .title(movie.getTitle())
                .description(movie.getDescription())
                .releaseDate(movie.getReleaseDate())
                .rating(movie.getRating())
                .categories(categories)
                .streamingPlatforms(streamingPlatforms)
                .build();
    }

}
