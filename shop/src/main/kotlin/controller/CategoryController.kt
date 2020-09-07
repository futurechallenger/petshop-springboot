package controller

import CategoryService
import com.petshop.dao.domain.Category
import com.petshop.shop.common.ResponseWrapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.lang.Exception
import java.util.*

@RestController
class CategoryController {
  @Autowired
  lateinit var categoryService: CategoryService

  @GetMapping("/category/{id}")
  fun getCategory(@PathVariable("id") categoryId: Long?): ResponseWrapper {
    try {
      if (categoryId == null) {
        return ResponseWrapper.getBlankResponseJson("Invalid", "Category ID is empty or invalid!")
      }

      val category = categoryService.getCategoryById(categoryId)
      if (category == null) {
        return ResponseWrapper.getBlankResponseJson("Empty", "Category is empty")
      }

      val ret = ResponseWrapper.getResponseJson("OK", "OK", category)
    } catch (e: Exception) {
      // Log exception
    }

    return ResponseWrapper.getBlankResponseJson("Error", "")
  }
}