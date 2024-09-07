package dev.spring.todomate.todomate_app.service;

import dev.spring.todomate.todomate_app.model.Todo;
import dev.spring.todomate.todomate_app.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Transactional
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;

    public void addTodoDetails(Todo todo) {
        todoRepository.save(todo);
    }

    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    public Todo getTodoById(Long id) {
        return todoRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Todo not found with id " + id));
    }

    public void delete(Long id){
        Todo todo = todoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당하는 Todo 항목이 없습니다. id=" + id));
        this.todoRepository.delete(todo);
    }
}
