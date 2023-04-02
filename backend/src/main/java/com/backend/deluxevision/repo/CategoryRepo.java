package com.backend.deluxevision.repo;

import com.backend.deluxevision.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo  extends JpaRepository<Category, Long> {
}
