package io.github.gabriel_so_santos.jcinema.controller;

import io.github.gabriel_so_santos.jcinema.controller.request.CategoryRequest;
import io.github.gabriel_so_santos.jcinema.controller.response.CategoryResponse;
import io.github.gabriel_so_santos.jcinema.entity.Category;
import io.github.gabriel_so_santos.jcinema.mapper.CategoryMapper;
import io.github.gabriel_so_santos.jcinema.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jcinema/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public List<CategoryResponse> getAll(){
        List<Category> categories = categoryService.findAll();

        return categories.stream()
                .map(CategoryMapper::toCategoryResponse)
                .toList();
    }

    @GetMapping("/{id}")
    public CategoryResponse getById(@PathVariable Long id){
        Optional<Category> category = categoryService.findById(id);
        return category.map(CategoryMapper::toCategoryResponse)
                .orElse(null);
    }

    @PostMapping
    public CategoryResponse save(@RequestBody CategoryRequest request){
        Category category = CategoryMapper.toCategory(request);
        return CategoryMapper.toCategoryResponse(categoryService.save(category));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        categoryService.deleteById(id);
    }
}
