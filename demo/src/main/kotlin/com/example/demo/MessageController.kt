package com.example.demo

import org.springframework.web.bind.annotation.*
import org.springframework.data.repository.CrudRepository
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@RestController
class MessageController(var service: MessageService) {
    @GetMapping("/")
    fun index(): List<Message> = service.findMessages()

    @GetMapping("/{id}")
    fun index(@PathVariable id: String): List<Message> = service.findMessageById(id)

    @PostMapping("/")
    fun post(@RequestBody message: Message) {
        service.save(message)
    }
}


interface MessageRepository: CrudRepository<Message, String>

@Table("MESSAGES")
data class Message(@Id val id: String?, val text: String)