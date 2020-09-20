import com.petshop.dao.domain.Category

interface CategoryService {
  fun getCategoryById(categoryId: Long): Category?
  fun getCategoryList(): List<Category>?
}