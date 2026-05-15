package io.github.gabriel_so_santos.jcinema.controller;

import io.github.gabriel_so_santos.jcinema.controller.request.CategoryRequest;
import io.github.gabriel_so_santos.jcinema.controller.response.CategoryResponse;
import io.github.gabriel_so_santos.jcinema.entity.Category;
import io.github.gabriel_so_santos.jcinema.mapper.CategoryMapper;
import io.github.gabriel_so_santos.jcinema.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jcinema/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> getAll() {
        List<CategoryResponse> categories = categoryService.findAll()
                .stream()
                .map(CategoryMapper::toCategoryResponse)
                .toList();

        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> getById(@PathVariable Long id) {
        return categoryService.findById(id)
                .map(CategoryMapper::toCategoryResponse)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CategoryResponse> save(@RequestBody CategoryRequest request) {
        Category newCategory = CategoryMapper.toCategory(request);

        CategoryResponse response = CategoryMapper.toCategoryResponse(
                categoryService.save(newCategory)
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        categoryService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
