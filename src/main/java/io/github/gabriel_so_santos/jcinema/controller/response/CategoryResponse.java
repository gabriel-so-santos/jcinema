package io.github.gabriel_so_santos.jcinema.controller.response;

import lombok.Builder;

@Builder
public record CategoryResponse(Long id, String name) {}
