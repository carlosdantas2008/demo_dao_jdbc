package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("==== TEST 1: department findById ====");
		Department departmentFindById = departmentDao.findById(2);
		System.out.println(departmentFindById);
		
		System.out.println("==== TEST 2: department findAll ====");
		List<Department> departmentFindAll = departmentDao.findAll();
		for (Department department : departmentFindAll) {
			System.out.println(department);
		}
		
		System.out.println("==== TEST 3: department deleteById ====");
		departmentDao.deleteById(3);
		System.out.println("Deleted!");
		
		System.out.println("==== TEST 4: department update ====");
		Department departmentUpdate = new Department();
		departmentUpdate = departmentDao.findById(6);
		departmentUpdate.setName("Parts");
		departmentDao.update(departmentUpdate);
		System.out.println("Updated!");
		
		System.out.println("==== TEST 5: department insert ====");
		Department departmentInsert = new Department(null, "HR");
		departmentDao.insert(departmentInsert);
		System.out.println("Inserted!");
		
	}
}
