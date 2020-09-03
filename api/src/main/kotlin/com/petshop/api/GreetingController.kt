package com.petshop.api

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class GreetingController {

  @GetMapping("/greetings")
  fun greeting(@RequestParam(value = "name", defaultValue = "World") name: String) : ResponseEntity<Map<String, String>>{
    try{
      return ResponseEntity.status(200).body(mapOf("Hello  $name" to "message"))
    } catch(e: Exception) {
      return ResponseEntity.status(500).body(mapOf(e.localizedMessage to "message"))
    }
  }
}