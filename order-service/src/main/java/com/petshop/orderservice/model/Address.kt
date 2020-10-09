package com.petshop.orderservice.model

data class Address(
    val firstName: String? = null,
    val lastName: String? = null,
    val address1: String? = null,
    val address2: String? = null,
    val city: String? = null,
    val state: String? = null,
    val zip: String? = null,
    val country: String? = null,
    val phone: String? = null,
    val email: String? = null
) {
}