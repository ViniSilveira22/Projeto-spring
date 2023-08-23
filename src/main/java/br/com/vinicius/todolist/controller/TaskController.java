package br.com.vinicius.todolist.controller;

import br.com.vinicius.todolist.task.Task;
import br.com.vinicius.todolist.task.TaskData;
import br.com.vinicius.todolist.task.TaskRepository;
import br.com.vinicius.todolist.task.TaskUpdateData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskRepository repository;

    @GetMapping("/form")
    public String loadPageList(Long id, Model model) {
        if (id != null) {
            var task = repository.getReferenceById(id);
            model.addAttribute("task", task);
        }
        return "tasks/form";
    }

    @GetMapping
    public String loadTaskList(Model model) {
        model.addAttribute("list", repository.findAll());
        return "tasks/list";
    }

    @PostMapping
    @Transactional
    public String registerTask(TaskData data) {
        var task = new Task(data);
        repository.save(task);
        return "redirect:/tasks";

    }

    @PutMapping
    @Transactional
    public String updateTask(TaskUpdateData data) {
        var task = repository.getReferenceById(data.id());
        task.updateTask(data);
        return "redirect:/tasks";

    }

    @DeleteMapping
    @Transactional
    public String deleteTask(Long id){
        repository.deleteById(id);
        return "redirect:/tasks";
    }
}
