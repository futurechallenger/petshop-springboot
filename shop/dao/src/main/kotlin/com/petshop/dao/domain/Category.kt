package com.petshop.dao.domain

data class Category(
    val id: Long,
    val categoryName: String,
    val description: String,
    val createdAt: Long,
    val updatedAt: Long) {
}