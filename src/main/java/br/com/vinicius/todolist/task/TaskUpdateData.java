package br.com.vinicius.todolist.task;

public record TaskUpdateData(Long id, String title, String description, String time) {
}
