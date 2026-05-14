package io.github.gabriel_so_santos.jcinema.controller;

import io.github.gabriel_so_santos.jcinema.entity.Category;
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
    public List<Category> getAll(){
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public Category getById(@PathVariable Long id){
        Optional<Category> category = categoryService.findById(id);
        return category.orElse(null);
    }

    @PostMapping
    public Category save(@RequestBody Category category){
        return categoryService.save(category);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        categoryService.deleteById(id);
    }
}
