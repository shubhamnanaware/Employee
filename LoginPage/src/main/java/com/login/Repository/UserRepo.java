package com.login.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.login.model.User;
@Repository
public interface UserRepo extends JpaRepository<User, String> {

	User findByUserId(int userId);


}
