package com.petshop.service.impl

import com.petshop.dao.domain.Category
import CategoryService
import com.petshop.dao.repository.CategoryRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CategoryServiceImpl : CategoryService {
  @Autowired
  lateinit var categoryRepository: CategoryRepository

  override fun getCategoryById(categoryId: Long): Category? {
    try {
      return categoryRepository.getCategoryById(categoryId)
    } catch (e: Exception) {
      // Log exception
    }

    return null
  }

  override fun getCategoryList(): List<Category>? {
    try {
      return categoryRepository.getCategoryList();
    } catch (e: Exception) {
      // Log exception
    }

    return null
  }
}