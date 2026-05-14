package io.github.gabriel_so_santos.jcinema.service;

import io.github.gabriel_so_santos.jcinema.entity.Category;
import io.github.gabriel_so_santos.jcinema.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }
}
