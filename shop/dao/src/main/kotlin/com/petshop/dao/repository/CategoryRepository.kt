package com.petshop.dao.repository

import com.petshop.dao.domain.Category
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Select

const val TABLE = "category"
const val FIELDS = "id, category_name, description, created_at, updated_at"

@Mapper
interface CategoryRepository {

  @Select("select $FIELDS from $TABLE where id=#{id}")
  fun getCategoryById(@Param("id") categoryId: Long): Category

  @Select("select $FIELDS from $TABLE")
  fun getCategoryList(): List<Category>
}