package dev.spring.todomate.todomate_app.controller;

import dev.spring.todomate.todomate_app.model.User;
import dev.spring.todomate.todomate_app.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/users")
public class UserController {
  private final UserService userService;

  @PostMapping("/login")
  public String login(@RequestParam String username, @RequestParam String password, HttpSession session){
      Optional<User> userOptional = userService.findByUsername(username);

      if (userOptional.isPresent() && userOptional.get().getPassword().equals(password)) {
        session.setAttribute("username", userOptional.get().getUsername());
        return "redirect:/";
      } else {
        return "redirect:/login?error";
      }
  }

}
