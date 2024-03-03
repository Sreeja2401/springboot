package com.epam.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.epam.entity.AdminAndUser;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
@Repository
public class AdminAndUserDaoImpl implements AdminAndUserDao {
	
	
	@Autowired
	EntityManager em;

	public AdminAndUser findMatchingUser(String userType, String userName, String password) {
		TypedQuery<AdminAndUser> query = em.createQuery( "SELECT u FROM AdminAndUser u WHERE u.userType = :userType AND u.userName = :userName AND u.password = :password"
		, AdminAndUser.class);
		query.setParameter("userType", userType);
		query.setParameter("userName", userName);
		query.setParameter("password", password);
		System.out.println(query.getSingleResult());
		return query.getSingleResult();
	}
   
	public AdminAndUser saveUsers(AdminAndUser t) {
			em.getTransaction().begin();
			em.persist(t);
			em.getTransaction().commit();
			return t;
	}
}


