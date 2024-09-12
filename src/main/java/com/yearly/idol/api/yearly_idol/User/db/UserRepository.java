package com.yearly.idol.api.yearly_idol.User.db;


import com.yearly.idol.api.yearly_idol.User.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
