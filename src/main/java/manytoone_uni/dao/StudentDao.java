package manytoone_uni.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import manytoone_uni.dto.Student;

public class StudentDao {

	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("sujit").createEntityManager();
	}
	
	public void saveStudent(Student student) {
		EntityManager manager = getEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(student.getC());
		manager.persist(student);
		transaction.commit();
	}
	
	public void getStudent(int id) {
		EntityManager manager = getEntityManager();
		Student student = manager.find(Student.class, id);
		if (student!=null) {
			System.out.println(student);
		} else {
            System.out.println("No student found with id : "+id);
		}
	}
	
	public void deleteStudent(int id) {
		EntityManager manager = getEntityManager();
		Student student = manager.find(Student.class, id);
		
		if (student != null) {
			EntityTransaction transaction  = manager.getTransaction();
			transaction.begin();
			//manager.remove(student.getC());
			manager.remove(student);
			transaction.commit();
		}else {
			System.out.println("Student not found with id : "+id);
		}
	}
	
	public void updateStudent(int id, Student student) {
		EntityManager manager = getEntityManager();
		Student student2 = manager.find(Student.class, id);
		if (student2 != null) {
			EntityTransaction transaction = manager.getTransaction();
			student.setId(id);
			student.setC(student2.getC());
			transaction.begin();
			manager.merge(student);
			transaction.commit();
		} else {
             System.out.println("No student found with id: "+id);
		}
	}
	
	public void updateBoth(int id, Student student) {
		EntityManager manager = getEntityManager();
		Student student2 = manager.find(Student.class, id);
		
		if (student2!=null) {
			student.setId(id);
			student.getC().setId(student2.getC().getId());
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			manager.merge(student.getC());
			manager.merge(student);
			transaction.commit();
		} else {

		}
	}
}
