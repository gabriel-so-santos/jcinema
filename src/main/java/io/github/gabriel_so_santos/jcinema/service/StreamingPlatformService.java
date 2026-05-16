package io.github.gabriel_so_santos.jcinema.service;

import io.github.gabriel_so_santos.jcinema.entity.StreamingPlatform;
import io.github.gabriel_so_santos.jcinema.repository.StreamingPlatformRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class StreamingPlatformService {
    private final StreamingPlatformRepository streamingPlatformRepository;

    public List<StreamingPlatform> findAll() {
        return streamingPlatformRepository.findAll();
    }

    public Optional<StreamingPlatform> findById(Long id) {
        return streamingPlatformRepository.findById(id);
    }

    public StreamingPlatform save(StreamingPlatform streamingPlatform) {
        return streamingPlatformRepository.save(streamingPlatform);
    }

    public void deleteById(Long id) {
        streamingPlatformRepository.deleteById(id);
    }
}
