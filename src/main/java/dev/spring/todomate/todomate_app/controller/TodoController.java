package dev.spring.todomate.todomate_app.controller;

import dev.spring.todomate.todomate_app.model.Option;
import dev.spring.todomate.todomate_app.model.Todo;
import dev.spring.todomate.todomate_app.model.User;
import dev.spring.todomate.todomate_app.service.TodoService;
import dev.spring.todomate.todomate_app.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private final TodoService todoService;
    @Autowired
    private final UserService userService;


    @GetMapping("/list")
    public String showTodoList(Model model) {
        List<Todo> todos = todoService.getAllTodos();
        model.addAttribute("todos", todos);
        return "todoList";
    }

    @GetMapping("/createOrUpdateTodoForm")
    public String createOrUpdateTodoForm(@RequestParam(name = "id", required = false) Long id, Model model) {
        Todo todo;
        if (id != null) {
            todo = todoService.getTodoById(id); // ID가 제공되면 해당 Todo를 가져옵니다.
        } else {
            todo = new Todo(); // ID가 없으면 새 Todo 객체를 생성합니다.
        }
        model.addAttribute("todo", todo);
        return "createOrUpdateTodoForm"; // 수정 또는 생성 폼 JSP 파일 이름
    }

    @GetMapping("/addTodo")
    public String processAddForm(Model model) {
        model.addAttribute("todo", Todo.builder().build());
        return "createOrUpdateTodoForm";
    }

    @PostMapping("/add")
    public String addTodo(@ModelAttribute Todo todo) {
        todo.setStartDate(LocalDate.now());
        todo.setDueDate(LocalDate.now());

        // 로그인 세션에서 User id를 가져와서 Repository에서 해당하는 id를 가져와서 해야하는데, 우선은 test용으로 1을 넣고 해 보자
        // User service에서 findbyid 가져오기
        // 여기에 setter로 해당 id 넣어주기
        // 테스트용 User ID: 1
        Long userId = 1L;
        User user = userService.findById(userId);
        todo.setUser(user);
        todoService.addTodoDetails(todo);

        return "redirect:/todos/list";
    }

    @PostMapping("/update")
    public String updateTodo(@ModelAttribute Todo todo) {
        todo.setStartDate(LocalDate.now());
        todo.setDueDate(LocalDate.now());

        // 테스트용 ID: 1
        Long userId = 1L;
        User user = userService.findById(userId);
        todo.setUser(user);
        todoService.addTodoDetails(todo);

        return "redirect:/todos/list";

    }
}
