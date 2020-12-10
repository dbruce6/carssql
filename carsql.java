import java.sql.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

/*
public class Lab_9 {
    private Connection c = null;
    private String dbName;
    private boolean isConnected = false;
    private void openConnection(String _dbName) {
        dbName = _dbName;
        if (false == isConnected) {
            System.out.println("++++++++++++++++++++++++++++++++++");
            System.out.println("Open database: " + _dbName);
            try {
                String connStr = new String("jdbc:sqlite:");
                connStr = connStr + _dbName;
                // STEP: Register JDBC driver
                Class.forName("org.sqlite.JDBC");
                
              
*/

public class carsql {

	public static void choice1() {
		try {

			String dbName;
			dbName = "C://Users//bruce duong//eclipse-workspace//Final.zip_expanded//Final//data.db";
			String connStr = new String("jdbc:sqlite:");
			connStr = connStr + dbName;
			Statement stmt;
			Connection c;
			c = DriverManager.getConnection(connStr);
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery(
					"Select car_names.model, car_details.year, car_details.horsepower " + "From car_details, car_names "
							+ "Where car_details.ID = car_names.ID AND year = '1975' AND horsepower > '100';");
			while (rs.next()) {
				String cModel = rs.getString("model");
				String cYear = rs.getString("year");
				String cHorse = rs.getString("horsepower");
				System.out.println(cYear + "\t" + "\t " + cModel + "\t" + "\t" + cHorse);
				// for some reason the column for horsepower does not line up in spacing??
			}
			rs.close();
			stmt.close();
			c.close();

			System.out.println();
		} catch (Exception e) {
			System.err.println("Invalid entries.  Exiting.");
			System.exit(0);
		}
	}

	public static void choice2() {
		try {
			String dbName;
			dbName = "C://Users//bruce duong//eclipse-workspace//Final.zip_expanded//Final//data.db";
			String connStr = new String("jdbc:sqlite:");
			connStr = connStr + dbName;
			Statement stmt;
			Connection c;
			c = DriverManager.getConnection(connStr);
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery(
					"Select DISTINCT CountryID, Model, CountryName " + "From countries, car_names, car_makers "
							+ "Where CountryName = 'usa' AND car_names.ID = car_makers.ID;");

			while (rs.next()) {
				String cModel = rs.getString("Model");
				String cName = rs.getString("CountryName");
				System.out.println(cModel + "\t" + "\t" + cName);
			}

			rs.close();
			stmt.close();
			c.close();
			System.out.println();
		} catch (Exception e) {
			System.err.println("Invalid entries.  Exiting.");
			System.exit(0);
		}
	}

	public static void choice3() {
		try {
			String dbName;
			dbName = "C://Users//bruce duong//eclipse-workspace//Final.zip_expanded//Final//data.db";
			String connStr = new String("jdbc:sqlite:");
			connStr = connStr + dbName;
			Statement stmt;
			Connection c;
			c = DriverManager.getConnection(connStr);
			stmt = c.createStatement();
			ResultSet rs = stmt
					.executeQuery("Select car_names.model, Max(car_details.accel)" + "From car_Details, car_names "
							+ "Where car_details.ID = car_names.ID " + "Group by car_names.model;");

			while (rs.next()) {
				String cModel = rs.getString("Model");
				String cAccel = rs.getString("max(Car_Details.accel)");
				System.out.println(cModel + "\t" + "\t" + cAccel);
			}

			rs.close();
			stmt.close();
			c.close();
			System.out.println();
		} catch (Exception e) {
			System.err.println("Invalid entries.  Exiting.");
			System.exit(0);
		}
	}

	public static void choice4() {
		try {
			String dbName;
			dbName = "C://Users//bruce duong//eclipse-workspace//Final.zip_expanded//Final//data.db";
			String connStr = new String("jdbc:sqlite:");
			connStr = connStr + dbName;
			Statement stmt;
			Connection c;
			c = DriverManager.getConnection(connStr);
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("Select Car_Names.Model, MAX(Car_Details.weight), MIN(Car_Details.weight) "
					+ "From Car_Names, Car_Details " + "Where Car_Names.ID = Car_Details.ID "
					+ "Group by Car_Names.Model;");

			while (rs.next()) {
				String cModel = rs.getString("model");
				String cWeight = rs.getString("Max(Car_Details.weight)");
				String cMWeight = rs.getString("MIN(Car_Details.weight)");
				System.out.println(cModel + "\t\t" + cWeight + "\t\t" + cMWeight);
			}
			rs.close();
			stmt.close();
			c.close();
			System.out.println();
		} catch (Exception e) {
			System.err.println("Invalid entries.  Exiting.");
			System.exit(0);
		}
	}



	public static void choice6(String Cyl) {
		try {
			String dbName;
			dbName = "C://Users//bruce duong//eclipse-workspace//Final.zip_expanded//Final//data.db";
			String connStr = new String("jdbc:sqlite:");
			connStr = connStr + dbName;
			Statement stmt;
			Connection c;
			c = DriverManager.getConnection(connStr);
			stmt = c.createStatement();
			ResultSet rs = stmt
					.executeQuery("SELECT Car_Names.Descr, Car_Details.cylinders " + "FROM Car_Details, Car_Names "
							+ "WHERE Car_Details.ID = Car_Names.ID AND Car_Details.cylinders = '" + Cyl + "' ;");

			while (rs.next()) {
				String cDescr = rs.getString("Descr");
				String cCyl = rs.getString("cylinders");
				System.out.println(cDescr + "\t\t\t" + cCyl);
			}

			rs.close();
			stmt.close();
			c.close();
			System.out.println();
		} catch (Exception e) {
			System.err.println("Invalid entries.  Exiting.");
			System.exit(0);
		}
	}

	public static void choice7(String inputType) {
		try {
			String dbName;
			dbName = "C://Users//bruce duong//eclipse-workspace//Final.zip_expanded//Final//data.db";
			String connStr = new String("jdbc:sqlite:");
			connStr = connStr + dbName;
			Statement stmt;
			Connection c;
			c = DriverManager.getConnection(connStr);
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery(
					"Select maker, FullName " + "From car_makers " + "Where country = '" + inputType + "';");
			while (rs.next()) {
				String columnOne = rs.getString("maker");
				String columnTwo = rs.getString("FullName");
				System.out.println(columnTwo + "\t" + columnOne);
			}

			rs.close();
			stmt.close();
			c.close();
			System.out.println();
		} catch (Exception e) {
			System.err.println("Invalid entries.  Exiting.");
			System.exit(0);
		}
	}

	public static void choice8(String inputType) {
		try {
			String dbName;
			dbName = "C://Users//bruce duong//eclipse-workspace//Final.zip_expanded//Final//data.db";
			String connStr = new String("jdbc:sqlite:");
			connStr = connStr + dbName;
			Statement stmt;
			Connection c;
			c = DriverManager.getConnection(connStr);
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("Select *" + "From car_names " + "Where Model LIKE '" + inputType + "';");
			while (rs.next()) {
				String columnOne = rs.getString("ID");
				String columnTwo = rs.getString("Descr");
				System.out.println(columnOne + "\t" + columnTwo + "\t");
			}

			rs.close();
			stmt.close();
			c.close();
			System.out.println();
		} catch (Exception e) {
			System.err.println("Invalid entries.  Exiting.");
			System.exit(0);
		}
	}

	public static void choice9(String inputType) {
		try {
			String dbName;
			dbName = "C://Users//bruce duong//eclipse-workspace//Final.zip_expanded//Final//data.db";
			String connStr = new String("jdbc:sqlite:");
			connStr = connStr + dbName;
			Statement stmt;
			Connection c;
			c = DriverManager.getConnection(connStr);
			stmt = c.createStatement();

			ResultSet rs = stmt.executeQuery("Select *" + "From car_details " + "Where ID = '" + inputType + "';");
			while (rs.next()) {
				String cMpg = rs.getString("mpg");
				String cCyl = rs.getString("cylinders");
				String cEd = rs.getString("edispl");
				String cHorse = rs.getString("horsepower");
				String cWeight = rs.getString("weight");
				String cAccel = rs.getString("accel");
				String cYear = rs.getString("year");
				System.out.println("This car has the following car ");

				System.out.println("Mpg" + "\t\t" + "Cylinders" + "   " + "Engine Displacement" + "\t" + "horsepower"
						+ "\t" + "weight   " + "\t" + "Acceleration" + "\t" + " Year");
				System.out.println(cMpg + "\t\t" + cCyl + "\t\t" + cEd + "\t\t" + cHorse + "\t\t" + cWeight + "\t\t"
						+ cAccel + "\t\t" + cYear);
			}

			rs.close();
			stmt.close();
			c.close();
			System.out.println();
		} catch (Exception e) {
			System.err.println("Invalid entries.  Exiting.");
			System.exit(0);
		}
	}

	public static void choice10(String column, String inputType, String var) {
		try {
			String dbName;
			dbName = "C://Users//bruce duong//eclipse-workspace//Final.zip_expanded//Final//data.db";
			String connStr = new String("jdbc:sqlite:");
			connStr = connStr + dbName;
			Statement stmt;
			Connection c;
			c = DriverManager.getConnection(connStr);
			stmt = c.createStatement();
			stmt.executeUpdate("Update car_details " + "Set " + column + " = " + inputType + " "
					+ "Where car_details.ID = '" + var + "';");

			stmt.close();
			c.close();
			System.out.println();
		} catch (Exception e) {
			System.err.println("Invalid entries.  Exiting.");
			System.exit(0);
		}
	}

	public static void choice11(String inputType) {
		try {
			String dbName;
			dbName = "C://Users//bruce duong//eclipse-workspace//Final.zip_expanded//Final//data.db";
			String connStr = new String("jdbc:sqlite:");
			connStr = connStr + dbName;
			Statement stmt;
			Connection c;
			c = DriverManager.getConnection(connStr);
			stmt = c.createStatement();
			stmt.execute("DELETE " + "From car_details " + "Where ID =" + inputType + ";");
			String IDdeleted = inputType;
			System.out.println("Rows impacted : " + IDdeleted);
			System.out.println("You have successfully deleted the car entry with the ID: " + inputType);
			stmt.close();
			c.close();
			System.out.println();
		} catch (Exception e) {
			System.err.println("Invalid entries.  Exiting.");
			System.exit(0);
		}
	}

	public static void choice12(int ID, int mpg, int cylinders, int edispl, int horsepower, int weight, int accel,
			int year) {
		try {
			String dbName;
			dbName = "C://Users//bruce duong//eclipse-workspace//Final.zip_expanded//Final//data.db";
			String connStr = new String("jdbc:sqlite:");
			connStr = connStr + dbName;
			Statement stmt;
			Connection c;
			c = DriverManager.getConnection(connStr);
			c.setAutoCommit(false);
			stmt = c.createStatement();
			String sql = "INSERT INTO car_details(`ID`,mpg,cylinders,edispl,horsepower,weight,accel,`year`) "
					+ "VALUES( '" + ID + "', " + mpg + ", " + cylinders + ", '" + edispl + "', '" + horsepower + "',"
					+ " '" + weight + "', '" + accel + "', '" + year + "');";
			stmt.executeUpdate(sql);
			System.out.println("You have successfully Added the car entry. ");
			c.commit();
			stmt.close();
			c.close();
			System.out.println();
		} catch (Exception e) {
			System.err.println("Invalid entries.  Exiting.");
			System.exit(0);
		}
	}
}
