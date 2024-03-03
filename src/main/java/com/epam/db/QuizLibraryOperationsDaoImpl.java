package com.epam.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.epam.entity.QuizLibrary;

import jakarta.persistence.EntityManager;
@Repository
public class QuizLibraryOperationsDaoImpl implements QuizLibraryOperationsDao {

	@Autowired
	EntityManager em;
	@Override
	public QuizLibrary save(QuizLibrary t) {
			em.getTransaction().begin();
			em.persist(t);
			em.getTransaction().commit();

		return t;
	}
	@Override
	public List<QuizLibrary> viewAll() {
		List<QuizLibrary> availableQuestions;
			availableQuestions = em.createQuery("Select t from QuizLibrary t").getResultList();
		return availableQuestions;
	}


	@Override
	public QuizLibrary update(QuizLibrary q) {
			em.getTransaction().begin();
			em.persist(q);
			em.getTransaction().commit();
		return q;
	}

	@Override
	public boolean delete(int id) {
		em.getTransaction().begin();
		em.remove(em.find(QuizLibrary.class, id));
		em.getTransaction().commit();
		return true;

	}

}
