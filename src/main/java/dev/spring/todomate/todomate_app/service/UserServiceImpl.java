package dev.spring.todomate.todomate_app.service;

import dev.spring.todomate.todomate_app.model.User;
import dev.spring.todomate.todomate_app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public Optional<User> findByUsername(String username){
        return userRepository.findByUsername(username);
    }

}
