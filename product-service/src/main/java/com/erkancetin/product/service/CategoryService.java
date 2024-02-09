package com.erkancetin.product.service;

import com.erkancetin.product.model.Category;
import com.erkancetin.product.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository repository;

    public Category add(Category category) {
        return repository.save(category);
    }
}
