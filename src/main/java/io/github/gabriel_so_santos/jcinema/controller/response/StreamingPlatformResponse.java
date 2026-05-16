package io.github.gabriel_so_santos.jcinema.controller.response;

import lombok.Builder;

@Builder
public record StreamingPlatformResponse(Long id, String name) {}
