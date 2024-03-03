package com.epam.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.epam.entity.QuestionsLibrary;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class QuestionsLibraryOperationsDaoImpl implements QuestionsLibraryOperationsDao {

	@Autowired
	EntityManager em;

	public QuestionsLibrary save(QuestionsLibrary q) {
		em.getTransaction().begin();
		em.persist(q);
		em.getTransaction().commit();
		return q;
	}

	public boolean delete(int questionId) {
		em.getTransaction().begin();
		em.remove(em.find(QuestionsLibrary.class, questionId));
		em.getTransaction().commit();
		return true;
	}

	
	public List<QuestionsLibrary> viewAll() {
		TypedQuery<QuestionsLibrary> query = em.createQuery("select q from QuestionsLibrary q", QuestionsLibrary.class);
		 return query.getResultList();
		 
	}

	public QuestionsLibrary viewById(int id) {
		return em.find(QuestionsLibrary.class, id);

	}

	public QuestionsLibrary update(QuestionsLibrary question) {
		em.getTransaction().begin();
		em.persist(question);
		em.getTransaction().commit();
		return question;
	}
	/*
	 * @Override public boolean existsByQuestionTitle(String title) {
	 * TypedQuery<Long> query = em.createQuery(
	 * "SELECT COUNT(q) FROM QuestionsLibrary q WHERE q.questionTitle = :title",
	 * QuestionsLibrary.class); query.setParameter("title", title); return
	 * query.getSingleResult() > 0; }
	 */
}
