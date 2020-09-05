package com.petshop.dao.domain

data class Item(
    val itemId: Long,
    val productId: Long,
    val listPrice: Double,
    val unitCost:Double,
    val supplier: String,
    val status: String,
    val itemName: String,
    val itemImage: String,
    val createdAt: Long,
    val updatedAt: Long) {
}