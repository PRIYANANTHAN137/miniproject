package com.kce.util;

import java.util.Scanner;
import com.kce.bean.courier;
import com.kce.dao.DAO;
import java.sql.SQLException;
import com.kce.bean.LocalCourier;
public class Main {

	public static void main(String[] args) {
		DAO courierDAO = new DAO();
		try {
			 Scanner scanner = new Scanner(System.in);
			 int choice = -1;

			 while (choice != 0) {
			 System.out.println("\t\t****Courier Management System****");
			 System.out.println("\t\t\t1. Create Courier");
			 System.out.println("\t\t\t2. Read Courier");
			 System.out.println("\t\t\t3. Update Courier");
			 System.out.println("\t\t\t4. Delete Courier");
			 System.out.println("\t\t\t0. Exit");
			 System.out.print("\t\tEnter your choice: ");
			 choice = scanner.nextInt();
			 scanner.nextLine();

			 switch (choice) {
			 case 1:
				 System.out.println("Create Courier");
				 System.out.print("Enter the courier ID: ");
				 int createId = scanner.nextInt();
				 scanner.nextLine();
				 System.out.print("Enter the courier name: ");
				 String createName = scanner.nextLine();
				 LocalCourier localcourier = new LocalCourier();
				 localcourier.setId(createId);
				 localcourier.setName(createName);
				 localcourier.setCity("London");
				 courierDAO.createCourier(localcourier);
				 System.out.println("Courier created successfully");
				 break;

			 case 2:
				 System.out.println("Read Courier");
				 System.out.print("Enter the courier ID: ");
				 int readId = scanner.nextInt();
				 courier retrievedCourier =courierDAO.readCourier(readId);
				 if (retrievedCourier != null) {
					 System.out.println("Retrieved Courier: " +retrievedCourier.getName());
				 } else {
					 System.out.println("Courier not found");
				 }
				 break;

			 case 3:
				 System.out.println("Update Courier");
				 System.out.print("Enter the courier ID: ");
				 int updateId = scanner.nextInt();
				 scanner.nextLine();
				 System.out.print("Enter the updated courier name:");
				 String updateName = scanner.nextLine();
				 courier updateCourier =courierDAO.readCourier(updateId);
				 if (updateCourier != null) {
					 updateCourier.setName(updateName);
					 courierService.validateCourier(updateCourier);
					 courierDAO.updateCourier(updateCourier);
					 System.out.println("Courier updated successfully");
				} else {
					System.out.println("Courier not found");
				}
				 break;

			case 4:
			 System.out.println("Delete Courier");
			 System.out.print("Enter the courier ID: ");
			 int deleteId = scanner.nextInt();

			// Read the courier
			courier deleteCourier =courierDAO.readCourier(deleteId);
			 if (deleteCourier != null) {
			 courierDAO.deleteCourier(deleteId);
			 System.out.println("Courier deleted successfully");
			 } 
			 else {
			 System.out.println("Courier not found");
			 }
			break;

			case 0:
				System.out.println("Exiting...");
				break;

			 default:
				 System.out.println("Invalid choice");
				 break;
			 }

			 	System.out.println();
			 }

			 courierDAO.disconnect();
			 } catch (SQLException e) {
			 e.printStackTrace();
			 }

	}

}
