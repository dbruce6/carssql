import java.sql.*;
import java.io.*;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

public class projectFinal extends carsql {
	public static Connection c;
	public static Scanner sc = new Scanner(System.in);

	public static void administrator() {
		System.out.println("What would you like to do?");
		System.out.println("9) View Car Details");
		System.out.println("10) Update Details of certain Car");
		System.out.println("11) Delete Existing Car");
		System.out.println("12) Insert New Car Entry");

		int userInput = sc.nextInt();

		if (userInput < 9 || userInput > 12) {
			System.out.println("You have entered an invalid input, please try again...");
			System.out.println();
			administrator();

		} else if (userInput == 9) {
			System.out.println("Please enter a car ID");
			sc.nextLine();
			String inputType = sc.nextLine();
			System.out.println("You entered: " + inputType);
			choice9(inputType);
		} else if (userInput == 10) {
			System.out.println("Please enter car ID");
			sc.nextLine();
			String var = sc.nextLine();
			System.out.println("What would you like to edit about Car " + var);
			String column = sc.nextLine();
			System.out.println("Please enter new" + column + " for car");
			String inputType = sc.nextLine();
			choice10(column, inputType, var);
		} else if (userInput == 11) {
			System.out.println("Please enter a car ID");
			sc.nextLine();
			String inputType = sc.nextLine();
			System.out.println("You entered: " + inputType);
			choice11(inputType);
		} else if (userInput == 12) {
			System.out.println("Please enter a car ID");
			int ID = sc.nextInt();
			System.out.println("Please enter a car mpg");
			int mpg = sc.nextInt();
			System.out.println("Please enter a car cylinders");
			int cylinders = sc.nextInt();
			System.out.println("Please enter a car edispl");
			int edispl = sc.nextInt();
			System.out.println("Please enter a car horsepower");
			int horsepower = sc.nextInt();
			System.out.println("Please enter a car weight");
			int weight = sc.nextInt();
			System.out.println("Please enter a car accel");
			int accel = sc.nextInt();
			System.out.println("Please enter a car year");
			int year = sc.nextInt();
			choice12(ID, mpg, cylinders, edispl, horsepower, weight, accel, year);
		}
	}

	public static void choices() {
		System.out.println(
				"\n==============WELCOME TO THE ANTIQUE CARBUYERS SHOP==============\nWhat would you like to do?\n"
						+ "1. View cars from 1975 with horsepower greater than 100"
						+ "\n2. List of all the car models from the USA" + "\n3. View the fastest cars from each model"
						+ "\n4. View heaviest and lighest weight of each model from each manufacturer"
						+ "\n6. Select cars with numbers of cylinders specified"
						+ "\n7. Search manufacturer by country of origin"
						+ "\n(^START HERE!^)\n8. Search cars by manufacturer" + "\n9. Search car details");

		System.out.println("0. Back");
		int userInput = sc.nextInt();
		if (userInput < 0 || userInput > 13) {
			System.out.println("You have entered an invalid input, please try again...");
			System.out.println();
			choices();
		}
		if (userInput == 1) {
			choice1();
		} else if (userInput == 2) {
			choice2();
		} else if (userInput == 3) {
			choice3();
		} else if (userInput == 4) {
			choice4();
		} 

		else if (userInput == 6) {
			System.out.print("Enter amount of cylinders (4,6,8)");
			sc.nextLine();
			String Cyl = sc.nextLine();
			System.out.println();
			choice6(Cyl);
		}

		else if (userInput == 7) {
			System.out.println("Please enter a country code that you wish to search for");
			System.out.print("(You may enter: \n1	usa\n" + "2	germany\n" + "3	france\n" + "4	japan\n" + "5	italy\n"
					+ "6	sweden\n" + "7	uk\n" + "8	korea" + ": ");
			sc.nextLine();
			String inputType = sc.nextLine();
			System.out.println("You entered: " + inputType);
			choice7(inputType);
		} else if (userInput == 8) {
			System.out.println("Please enter the manufacturer:");
			System.out.print("Full List:\n" + "amc\n" + "audi\n" + "bmw\n" + "buick\n" + "cadillac\n" + "capri\n"
					+ "chevrolet\n" + "chrysler\n" + "citroen\n" + "datsun\n" + "dodge\n" + "fiat\n" + "ford\n"
					+ "honda\n" + "toyota\n" + "mazda\n" + "mercedes-benz\n" + "mercury\n" + "pontiac\n" + "renault\n"
					+ "saab\n" + "subaru\n" + "toyota\n" + "triumph\n" + "volkswagen\n" + "volvo\n\n\n\n"
					+ "(Full list is above.\n What kind of manufacturer are you looking for?\n Enter: honda, audi,bmw,chevrolet,toyota, ford, fiat, volkswagen, etc..\n");
			sc.nextLine();
			String inputType = sc.nextLine();
			System.out.println("You entered: " + inputType);
			choice8(inputType);
		} else if (userInput == 9) {
			System.out.println("Please enter a car ID");
			sc.nextLine();
			String inputType = sc.nextLine();
			System.out.println("You entered: " + inputType);
			choice9(inputType);
		}

		else if (userInput == 10) {
			System.out.println("Please enter car ID");
			sc.nextLine();
			String var = sc.nextLine();
			System.out.println("What would you like to edit about Car " + var);
			String column = sc.nextLine();
			System.out.println("Please enter new" + column + " for car");
			String inputType = sc.nextLine();
			choice10(column, inputType, var);
		}

		else if (userInput == 11) {
			System.out.println("Please enter a car ID");
			sc.nextLine();
			String inputType = sc.nextLine();
			System.out.println("You entered: " + inputType);
			choice11(inputType);
		}

		else if (userInput == 12) {
//			ID,mpg,cylinders,edispl,horsepower,weight,accel,year
			
			System.out.println("Please enter a car ID");
			int ID = sc.nextInt();
			System.out.println("Please enter the car mpg");
			int mpg = sc.nextInt();
			System.out.println("Please enter the car's cylinders");
			int cylinders = sc.nextInt();
			System.out.println("Please enter the car engin displacement");
			int edispl = sc.nextInt();
			System.out.println("Please enter the car horsepower");
			int horsepower = sc.nextInt();
			System.out.println("Please enter a car weight");
			int weight = sc.nextInt();
			System.out.println("Please enter the car acceleration");
			int accel = sc.nextInt();
			System.out.println("Please enter the car year");
			int year = sc.nextInt();
			choice12(ID, mpg, cylinders, edispl, horsepower, weight, accel, year);
		}

		else {
			buyerOrAdmin();
		}
		choices();

	}

	public static void end() {
		sc.close();
		System.exit(0);
	}

	public static void buyerOrAdmin() {
		System.out.println("Are you looking for a car?");
		System.out.println("1) Yes");
		System.out.println("2) No");
		System.out.println("3) Administrator Access");
		int input = sc.nextInt();
		if (input < 0 || input > 3) {
			System.out.println("Please enter a valid choice.");
			System.out.println();
			buyerOrAdmin();
		}
		if (input == 1) {
			System.out.print("\nHello Valued Customer.\n");
			choices();
		} else if (input == 2) {
			System.out.print("Thank you for stopping by.  Goodbye.");
			end();

		}

		else if (input == 3) {
			System.out.print("Admin Access ");
			administrator();
		}

	}

	public static void main(String[] args) {
		System.out.println("==============WELCOME TO THE ANTIQUE CARBUYERS SHOP==============");
		buyerOrAdmin();

	}

}
