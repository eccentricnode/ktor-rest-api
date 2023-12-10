package com.example.models

import kotlinx.serialization.Serializable
import java.util.UUID.*

@Serializable
data class Todo(val id: String, val title: String, val description: String, val completed: Boolean)

val todoStorage = mutableListOf<Todo>(
    Todo(
        id = randomUUID().toString(),
        title = "Test Title",
        description = "Test Description",
        completed = false,
    )
)