package ru.samozanet.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import ru.samozanet.entity.UserEntity;
import ru.samozanet.entity.enums.Role;
import ru.samozanet.repository.UserEntityRepository;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserEntityRepository userEntityRepository;
    private final PasswordEncoder passwordEncoder;

    public boolean createAdmin(Long phonenumber, String lastname, String firstname, UserEntity user) {
        String email = user.getEmail();
        if (userEntityRepository.findByEmail(email) != null) return false;
        if (userEntityRepository.findByPhoneNumber(phonenumber) != null) return false;
        user.setActive(true);
        user.setPhoneNumber(phonenumber);
        user.setLastName(lastname);
        user.setFirstName(firstname);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.getRoles().add(Role.ROLE_ADMIN);
        log.info("Saving new Client with email: {}", email);
        userEntityRepository.save(user);
        return true;
    }

    public boolean createMaster(Long phonenumber, String lastname, String firstname, UserEntity user) {
        String email = user.getEmail();
        if (userEntityRepository.findByEmail(email) != null) return false;
        if (userEntityRepository.findByPhoneNumber(phonenumber) != null) return false;
        user.setActive(true);
        user.setPhoneNumber(phonenumber);
        user.setLastName(lastname);
        user.setFirstName(firstname);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.getRoles().add(Role.ROLE_MASTER);
        log.info("Saving new Client with email: {}", email);
        userEntityRepository.save(user);
        return true;
    }

    public boolean createClient(Long phonenumber, String lastname, String firstname, UserEntity user) {
        String email = user.getEmail();
        if (userEntityRepository.findByEmail(email) != null) return false;
        if (userEntityRepository.findByPhoneNumber(phonenumber) != null) return false;
        user.setActive(true);
        user.setPhoneNumber(phonenumber);
        user.setLastName(lastname);
        user.setFirstName(firstname);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.getRoles().add(Role.ROLE_CLIENT);
        log.info("Saving new Client with email: {}", email);
        userEntityRepository.save(user);
        return true;
    }

    public List<UserEntity> list() {
        return userEntityRepository.findAll();
    }

    public void banUser(Long id) {
        UserEntity userEntity = userEntityRepository.findById(id).orElse(null);
        if (userEntity != null) {
            if (userEntity.isActive()){
                userEntity.setActive(false);
                log.info("UnBan user with id = {}; email: {}", userEntity.getId(), userEntity.getEmail());
            }
            else {
                userEntity.setActive(true);
                log.info("UnBan user with id = {}; email: {}", userEntity.getId(), userEntity.getEmail());
            }
        }
        userEntityRepository.save(userEntity);
    }

    public void changeUserRoles(UserEntity userEntity, Map<String, String> form) {
        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());
        userEntity.getRoles().clear();
        for (String key : form.keySet()) {
            if (roles.contains(key)) {
                userEntity.getRoles().add(Role.valueOf(key));
            }
        }
        userEntityRepository.save(userEntity);
    }
}
