package io.github.gabriel_so_santos.jcinema.controller.request;

import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Builder
public record MovieRequest(
        String title,
        String description,
        LocalDate releaseDate,
        double rating,
        List<Long> categoryIds,
        List<Long> streamingPlatformIds
) {}
