package aplication;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Department obj = new Department(1,"Books");
		System.out.println(obj);
		
		Seller seller= new Seller(1, "Bob", "bob.gmail", new Date(), 3000.0, obj);
		System.out.println(seller);
		
		SellerDao sellerDao=DaoFactory.createSellerDao();
		System.out.println();
		
		System.out.println("***********teste 1 findById*********");
		Seller seller1=sellerDao.findById(3);
		System.out.println(seller1);
		System.out.println();
		
		System.out.println("***********teste 2 findByDepartment*********");
		Department department = new Department(2,null);
		List<Seller>list=sellerDao.findByDepartment(department);
		for (Seller obj1:list) {
			System.out.println(obj1);
		}
		
		System.out.println();
		System.out.println("***********teste 3 findAll*********");
		
		List<Seller>list1=sellerDao.findAll();
		for (Seller obj1:list1) {
			System.out.println(obj1);
		}
		
		
		System.out.println();
		System.out.println("***********teste 4 insert*********");
		
		Seller newSeller = new Seller(null,"Greg", "greg@gmail.com",new Date(),4000.0,department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted new Id = "+ newSeller.getId());
		
	}

}
