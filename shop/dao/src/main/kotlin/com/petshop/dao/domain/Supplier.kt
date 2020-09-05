package com.petshop.dao.domain

data class Supplier(
    val id: Long,
    val supplierName: String,
    val status: String,
    val addr1: String,
    val addr2: String,
    val city: String,
    val state: String,
    val zip: String,
    val phone: String) {
}