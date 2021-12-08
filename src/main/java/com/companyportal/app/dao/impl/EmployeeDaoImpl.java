package com.companyportal.app.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.companyportal.app.dao.EmployeeDao;
import com.companyportal.app.entity.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private SessionFactory sessionFactory;

//	private ArrayList<Employee> employeeList = new ArrayList<Employee>();

	@Override
	public void saveOrUpdateEmployeeData(Employee employee) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.saveOrUpdate(employee);

		session.getTransaction().commit();
		session.close();

	}

	@Override
	public List<Employee> getEmployeesData() {

		List<Employee> emplist = new ArrayList<Employee>();

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		emplist = session.createQuery("From Employee").list();

		session.getTransaction().commit();
		session.close();
		return emplist;
	}

	@Override
	public void deleteEmployeeData(Employee employee) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.delete(employee);

		session.getTransaction().commit();
		session.close();
	}

	@Override
	public Employee getEmployeeById(int employeeId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Employee employee = session.get(Employee.class, employeeId);
		session.getTransaction().commit();
		session.close();

		return employee;
	}

	@Override
	public List<Employee> searchEmployeeByName(String employeeName) {
		// TODO Auto-generated method stub
		List<Employee> emplist = new ArrayList<Employee>();

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Query query = session.createQuery("From Employee where name like :employeeName");
		query.setParameter("employeeName", "%" + employeeName + "%");

		emplist = query.list();

		session.getTransaction().commit();
		session.close();
		return emplist;
	}

}
