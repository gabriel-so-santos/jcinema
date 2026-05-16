package io.github.gabriel_so_santos.jcinema.mapper;

import io.github.gabriel_so_santos.jcinema.controller.request.StreamingPlatformRequest;
import io.github.gabriel_so_santos.jcinema.controller.response.StreamingPlatformResponse;
import io.github.gabriel_so_santos.jcinema.entity.StreamingPlatform;
import lombok.experimental.UtilityClass;

@UtilityClass
public class StreamingPlatformMapper {
    public StreamingPlatform toStreamingPlatform(StreamingPlatformRequest request) {
        return StreamingPlatform.builder()
                .name(request.name())
                .build();
    }

    public StreamingPlatformResponse toStreamingPlatformResponse(StreamingPlatform platform) {
        return StreamingPlatformResponse.builder()
                .id(platform.getId())
                .name(platform.getName())
                .build();
    }
}
