package io.github.gabriel_so_santos.jcinema.controller;

import io.github.gabriel_so_santos.jcinema.controller.request.StreamingPlatformRequest;
import io.github.gabriel_so_santos.jcinema.controller.response.StreamingPlatformResponse;
import io.github.gabriel_so_santos.jcinema.entity.StreamingPlatform;
import io.github.gabriel_so_santos.jcinema.mapper.StreamingPlatformMapper;
import io.github.gabriel_so_santos.jcinema.service.StreamingPlatformService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/jcinema/streaming-platform")
public class StreamingPlatformController {
    private final StreamingPlatformService streamingPlatformService;

    @GetMapping
    public ResponseEntity<List<StreamingPlatformResponse>> getAll() {
        List<StreamingPlatformResponse> streamingPlatforms = streamingPlatformService.findAll()
                .stream()
                .map(StreamingPlatformMapper::toStreamingPlatformResponse)
                .toList();

        return ResponseEntity.ok(streamingPlatforms);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StreamingPlatformResponse> getById(@PathVariable Long id) {
        return streamingPlatformService.findById(id)
                .map(StreamingPlatformMapper::toStreamingPlatformResponse)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<StreamingPlatformResponse> save(@RequestBody StreamingPlatformRequest request) {
        StreamingPlatform newStreamingPlatform = StreamingPlatformMapper.toStreamingPlatform(request);

        StreamingPlatformResponse response = StreamingPlatformMapper.toStreamingPlatformResponse(
                streamingPlatformService.save(newStreamingPlatform)
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        streamingPlatformService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
