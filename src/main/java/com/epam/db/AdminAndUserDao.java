package com.epam.db;

import java.util.List;
import java.util.Optional;

import com.epam.entity.AdminAndUser;

public interface AdminAndUserDao {
   public AdminAndUser saveUsers(AdminAndUser t);
   public AdminAndUser findMatchingUser(String userType, String userName, String password);
}
