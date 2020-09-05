package com.petshop.dao.domain

data class Product(
    val id: Long,
    val categoryId: Long,
    val productName: String,
    val description: String,
    val productImage: String) {}