package com.example.store.users;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public Iterable<UserDto> getAllUsers(String sortBy) {
        if(!Set.of("name","email").contains(sortBy)){
            sortBy = "name";
        }
        return userRepository.findAll(Sort.by(sortBy))
                .stream().map(user -> userMapper.toDto(user))
                .toList();
    }

    public UserDto getUser(Integer userId) {
        User user = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        return userMapper.toDto(user);
    }

    public UserDto registerUser(RegisterUserRequest registerUserRequest) {
        if(userRepository.existsByEmail(registerUserRequest.getEmail())){
            throw new DuplicateUserException();
        }
        User user = userMapper.toEntity(registerUserRequest);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.CUSTOMER);
        userRepository.save(user);

        return userMapper.toDto(user);
    }

    public UserDto updateUser(Integer userId, UpdateUserRequest updateUserRequest) {
        User user = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        userMapper.update(updateUserRequest, user);
        userRepository.save(user);

        return userMapper.toDto(user);
    }

    public void deleteUser(Integer userId) {
        User user = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        userRepository.delete(user);
    }

    public void changePassword(Integer userId, ChangePasswordRequest changePasswordRequest) {
        User user = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        if(!passwordEncoder.matches(changePasswordRequest.getOldPassword(), user.getPassword())){
            throw new AccessDeniedException("Passwords don't match");
        }

        user.setPassword(changePasswordRequest.getNewPassword());
        userRepository.save(user);
    }
}