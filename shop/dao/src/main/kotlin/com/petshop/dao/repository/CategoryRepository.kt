package com.petshop.dao.repository

import com.petshop.dao.domain.Category
import org.apache.ibatis.annotations.*

const val TABLE_NAME = "category"
const val FIELDS = "id, category_name, description, created_at, updated_at"

@Mapper
interface CategoryRepository {

  @Select("select $FIELDS from $TABLE_NAME where id=#{id}")
  fun getCategoryById(@Param("id") categoryId: Long): Category

  @Select("select $FIELDS from $TABLE_NAME")
  fun getCategoryList(): List<Category>

  @Insert("insert into $TABLE_NAME (category_name, description)" +
      " values (#{categoryName}, #{description})")
  @Options(useGeneratedKeys = true, keyProperty = "id")
  fun insertCategory(): Long

  @Update("update category set category_name=#{categoryName}, description=#{description} where id=#{id}")
  fun updateCategory(@Param("id") categoryId: Long): Long
}