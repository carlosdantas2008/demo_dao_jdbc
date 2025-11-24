package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {
	
	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("==== TEST 1: seller findById ====");
		Seller sellerById = sellerDao.findById(3);
		System.out.println(sellerById);
		
		System.out.println("==== TEST 2: seller findByDepartment ====");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("==== TEST 3: seller findAll ====");
		List<Seller> list1 = sellerDao.findAll();
		for (Seller obj : list1) {
			System.out.println(obj);
		}
		
		System.out.println("==== TEST 4: seller insert ====");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department); 
		sellerDao.inser(newSeller);
		System.out.println("Inserted! New Id: " + newSeller.getId());
		
		System.out.println("==== TEST 5: seller update ====");
		Seller updatedSeller = new Seller();
		updatedSeller = sellerDao.findById(1);
		updatedSeller.setName("Martha Waine");
		sellerDao.update(updatedSeller);
		System.out.println("Update completed!");
		
		System.out.println("==== TEST 6: seller delete ====");
		int deletedSellerId = 8;
		sellerDao.deleteById(deletedSellerId);
		System.out.println("Delete completed!");
		
		System.out.println("==== TEST 7: seller update2 ====");
		Seller updatedSeller2 = new Seller();
		updatedSeller2 = sellerDao.findById(5);
		updatedSeller2.setDepartment(department);
		sellerDao.update(updatedSeller2);
		System.out.println("Update completed!");
		
	}
}
