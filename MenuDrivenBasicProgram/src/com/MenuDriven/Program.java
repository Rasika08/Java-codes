package com.MenuDriven;
import java.util.*;
public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int choice;
		
		while(true) {
			
			System.out.println("Enter 1st number : ");
			int a = sc.nextInt();
			
			System.out.println("Enter 2nd number : ");
			int b = sc.nextInt();
			
			System.out.println("Operation to perform : ");
			
			System.out.println("1. Addition : ");
			System.out.println("2. Subtraction : ");
			System.out.println("3. Multiplication : ");
			System.out.println("4. Division : ");
			System.out.println("5. Exit : ");
			
			System.out.println("Choose a option {1,2,3,4,5}");
			
			choice = sc.nextInt();
			
			switch(choice) {
			
			case 1:
				System.out.println("Addition is : " + (a + b) );
				break;
			case 2:
				System.out.println("Subtraction is : " + (a - b) );
				break;
			case 3:
				System.out.println("Multiplication is : " + (a * b) );
				break;
			case 4:
				System.out.println("Division is : " + (a / b) );
				break;
			case 5:
				System.out.println("Exiting the program..." );
				sc.close();
				System.exit(0);
			default:
				System.out.println("Invalid Input.." );
				
					
			}
				
			



			
		}
		
		
		

	}

}
