package io.github.gabriel_so_santos.jcinema.controller.response;

import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Builder
public record MovieResponse(
        Long id,
        String title,
        String description,
        LocalDate releaseDate,
        double rating,
        List<MovieCategoryResponse> categories,
        List<StreamingPlatformResponse> streamingPlatforms
) {}
