package ru.samozanet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.samozanet.entity.UserEntity;

public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByEmail(String email);
}
