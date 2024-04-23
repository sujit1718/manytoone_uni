package manytoone_uni.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import manytoone_uni.dao.StudentDao;
import manytoone_uni.dto.College;
import manytoone_uni.dto.Student;

public class Main {

	public static void main(String[] args) {
		
		College college = new College();
		college.setId(104);
		college.setName("Modern");
		college.setFees(100000.0);
		
		Student student = new Student();
		student.setId(5);
		student.setName("Rohan");
		student.setPhone(123439372);
		student.setAddress("Nashik");
		student.setC(college);
		
		Student student1 = new Student();
		student1.setId(6);
		student1.setName("MaheshKshirsagar");
		student1.setPhone(909012321);
		student1.setAddress("Pune");
		student1.setC(college);
		
//		EntityManagerFactory factory = Persistence.createEntityManagerFactory("sujit");
//        EntityManager manager = factory.createEntityManager();
//		EntityTransaction transaction = manager.getTransaction();
//		
//		transaction.begin();
//		manager.persist(college);
//		manager.persist(student);
//		manager.persist(student1);
//		transaction.commit();
		
		StudentDao dao = new StudentDao();
//		dao.saveStudent(student);
//		dao.saveStudent(student1);
		
//		dao.getStudent(2);
//		dao.deleteStudent(5);
//		dao.updateStudent(4, student1);
		dao.updateBoth(2, student1);
		
		
	}

}
