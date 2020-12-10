import java.sql.*;
import java.io.*;
import java.util.Scanner;
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
	
	public static void userOption1(){
		try{
			
			String dbName;
			dbName = "C://Users//bruce duong//eclipse-workspace//Final.zip_expanded//Final//data.db";
			String connStr = new String("jdbc:sqlite:");
			connStr = connStr + dbName;
			Statement stmt;
			Connection c;
			c = DriverManager.getConnection(connStr);
			stmt = c.createStatement();
			//transactions are automatic
			//Insert SQL here
			ResultSet rs = stmt.executeQuery(
					"Select car_names.model, car_details.year, car_details.horsepower "+
					"From car_details, car_names " +
					"Where car_details.ID = car_names.ID AND year = '1975' AND horsepower > '100';");
			while(rs.next()){
				String cModel = rs.getString("model");
				String cYear = rs.getString("year");
				String cHorse = rs.getString("horsepower");	
				System.out.println(cYear + "\t" + "\t " + cModel + "\t" + "\t" + cHorse);
				//for some reason the column for horsepower does not line up in spacing??
			}	
			rs.close();
			stmt.close();
			c.close();
			
			System.out.println();
		}
		catch(Exception e){
			//System.out.print("There was a problem connecting to the database...");
			System.err.println(e.getMessage());
			System.out.println("Program Ending...");
			System.exit(0);
		}
	}
	
	public static void userOption2(){
		try{
			String dbName;
			dbName = "C://Users//bruce duong//eclipse-workspace//Final.zip_expanded//Final//data.db";
			String connStr = new String("jdbc:sqlite:");
			connStr = connStr + dbName;
			Statement stmt;
			Connection c;
			c = DriverManager.getConnection(connStr);
			stmt = c.createStatement();
			//Insert SQL here
			//Use our tables/columns for this query
			ResultSet rs = stmt.executeQuery(
					"Select DISTINCT CountryID, Model, CountryName " +
					"From countries, car_names, car_makers " +
					"Where CountryName = 'usa' AND car_names.ID = car_makers.ID;");
			
			while(rs.next()){
				String cModel = rs.getString("Model");
				String cName = rs.getString("CountryName");
				System.out.println(cModel + "\t" + "\t" + cName);
			}
			
			rs.close();
			stmt.close();
			c.close();
			System.out.println();
		}
		catch(Exception e){
			//System.err.print("You entered an invalid item type(please check your spelling and make sure it is all capitalized");
			System.err.println(e.getMessage());
			System.out.println("Program Ending...");
			System.exit(0);
		}
	}
	
	public static void userOption3(){
		try{
			String dbName;
			dbName = "C://Users//bruce duong//eclipse-workspace//Final.zip_expanded//Final//data.db";
			String connStr = new String("jdbc:sqlite:");
			connStr = connStr + dbName;
			Statement stmt;
			Connection c;
			c = DriverManager.getConnection(connStr);
			stmt = c.createStatement();
			//Insert SQL here
			ResultSet rs = stmt.executeQuery(
					"Select car_names.model, Max(car_details.accel)"+
							"From car_Details, car_names " +
							"Where car_details.ID = car_names.ID " +
					"Group by car_names.model;");
			
			while(rs.next()){
				String cModel = rs.getString("Model");
				String cAccel = rs.getString("max(Car_Details.accel)");
				System.out.println (cModel + "\t" + "\t" + cAccel);
			}
			
			rs.close();
			stmt.close();
			c.close();
			System.out.println();
		}
		catch(Exception e){
			//System.err.print("You entered an invalid supplier");
			System.err.println(e.getMessage());
			System.out.println("Program Ending...");
			System.exit(0);
		}
	}
	
	public static void userOption4(){
		try{
			String dbName;
			dbName = "C://Users//bruce duong//eclipse-workspace//Final.zip_expanded//Final//data.db";
			String connStr = new String("jdbc:sqlite:");
			connStr = connStr + dbName;
			Statement stmt;
			Connection c;
			c = DriverManager.getConnection(connStr);
			stmt = c.createStatement();
			//Insert SQL here
			ResultSet rs = stmt.executeQuery(
					"Select Car_Names.Model, MAX(Car_Details.weight), MIN(Car_Details.weight) " +
							"From Car_Names, Car_Details " +
							"Where Car_Names.ID = Car_Details.ID " +
					"Group by Car_Names.Model;");
		
			while(rs.next()){
				String cModel = rs.getString("model");
				String cWeight = rs.getString("Max(Car_Details.weight)");
				String cMWeight = rs.getString("MIN(Car_Details.weight)");
				System.out.println(cModel + "\t\t" + cWeight + "\t\t" + cMWeight);
			}
			rs.close();
			stmt.close();
			c.close();
			System.out.println();
		}
		catch(Exception e){
			//System.err.print("You entered an invalid supplier");
			System.err.println(e.getMessage());
			System.out.println("Program Ending...");
			System.exit(0);
		}
	}

	public static void userOption5(){
		try{
			String dbName;
			dbName = "C://Users//bruce duong//eclipse-workspace//Final.zip_expanded//Final//data.db";
			String connStr = new String("jdbc:sqlite:");
			connStr = connStr + dbName;
			Statement stmt;
			Connection c;
			c = DriverManager.getConnection(connStr);
			stmt = c.createStatement();
			//Insert SQL here
			ResultSet rs = stmt.executeQuery(
					"SELECT Car_Names.Model, MAX(Car_Details.mpg), MIN(Car_Details.horsepower) " +
							"FROM Car_Names, Car_Details " +
							"WHERE Car_Names.ID = Car_Details.ID " +
					"Group By Car_Names.Model;");
			
			
			while(rs.next()){
				String cModel = rs.getString("Car_Names.Model");
				String cMpg = rs.getString("MAX(Car_Details.mpg)");
				String cHorse = rs.getString("MIN(Car_Details.horsepower");
				System.out.println(cModel + "\t$" + cMpg + "\t" + cHorse);
			}
			rs.close();
			stmt.close();
			c.close();
			System.out.println();
		}
		catch(Exception e){
			//System.err.print("You entered an invalid supplier");
			System.err.println(e.getMessage());
			System.out.println("Program Ending...");
			System.exit(0);
		}
	}
	
	public static void userOption6(String Cyl){
		try{
			String dbName;
			dbName = "C://Users//bruce duong//eclipse-workspace//Final.zip_expanded//Final//data.db";
			String connStr = new String("jdbc:sqlite:");
			connStr = connStr + dbName;
			Statement stmt;
			Connection c;
			c = DriverManager.getConnection(connStr);
			stmt = c.createStatement();
			//Insert SQL here
			ResultSet rs = stmt.executeQuery(
					"SELECT Car_Names.Descr, Car_Details.cylinders " +
					"FROM Car_Details, Car_Names " +
					"WHERE Car_Details.ID = Car_Names.ID AND Car_Details.cylinders = '" + Cyl + "' ;");
			
			while(rs.next()){
				String cDescr = rs.getString("Descr");
				String cCyl = rs.getString("cylinders");
				System.out.println(cDescr + "\t\t\t" + cCyl);
			}
			
			rs.close();
			stmt.close();
			c.close();
			System.out.println();
		}
		catch(Exception e){
			//System.err.print("You entered an invalid supplier");
			System.err.println(e.getMessage());
			System.out.println("Program Ending...");
			System.exit(0);
		}
	}
	
	public static void userOption7(String inputType){
		try{
			String dbName;
			dbName = "C://Users//bruce duong//eclipse-workspace//Final.zip_expanded//Final//data.db";
			String connStr = new String("jdbc:sqlite:");
			connStr = connStr + dbName;
			Statement stmt;
			Connection c;
			c = DriverManager.getConnection(connStr);
			stmt = c.createStatement();
			//Insert SQL here
			//Use our tables/columns for this query
			ResultSet rs = stmt.executeQuery(
					"Select maker, FullName " +
					"From car_makers " +
					"Where country = '" + inputType +"';");
			while(rs.next()){
				String pName = rs.getString("maker");
				String pType = rs.getString("FullName");
				System.out.println(pType + "\t" + pName);
			}

			rs.close();
			stmt.close();
			c.close();
			System.out.println();
		}
		catch(Exception e){
			//System.err.print("You entered an invalid item type(please check your spelling and make sure it is all capitalized");
			System.err.println(e.getMessage());
			System.out.println("Program Ending...");
			System.exit(0);
		}
	}
	
	public static void userOption8(String inputType){
		try{
			String dbName;
			dbName = "C://Users//bruce duong//eclipse-workspace//Final.zip_expanded//Final//data.db";
			String connStr = new String("jdbc:sqlite:");
			connStr = connStr + dbName;
			Statement stmt;
			Connection c;
			c = DriverManager.getConnection(connStr);
			stmt = c.createStatement();
			//Insert SQL here
			//Use our tables/columns for this query
			ResultSet rs = stmt.executeQuery(
					"Select *" +
					"From car_names " +
					"Where Model LIKE '" + inputType +"';");
			while(rs.next()){
				String pName = rs.getString("ID");
				String pType = rs.getString("Descr");
				System.out.println(pName + "\t" + pType+ "\t");
			}

			rs.close();
			stmt.close();
			c.close();
			System.out.println();
		}
		catch(Exception e){
			//System.err.print("You entered an invalid item type(please check your spelling and make sure it is all capitalized");
			System.err.println(e.getMessage());
			System.out.println("Program Ending...");
			System.exit(0);
		}
	}	
	
	public static void userOption9(String inputType){
		try{
			String dbName;
			dbName = "C://Users//bruce duong//eclipse-workspace//Final.zip_expanded//Final//data.db";
			String connStr = new String("jdbc:sqlite:");
			connStr = connStr + dbName;
			Statement stmt;
			Connection c;
			c = DriverManager.getConnection(connStr);
			stmt = c.createStatement();
			//Insert SQL here
			//Use our tables/columns for this query
			ResultSet rs = stmt.executeQuery(
					"Select *" +
					"From car_details " +
					"Where ID = '" + inputType +"';");
			while(rs.next()){
              String cMpg = rs.getString("mpg");
              String cCyl = rs.getString("cylinders");
              String cEd = rs.getString("edispl");
              String cHorse = rs.getString("horsepower");
              String cWeight = rs.getString("weight");
              String cAccel = rs.getString("accel");
              String cYear = rs.getString("year");
              System.out.println("This car has the following car ");

              System.out.println("Mpg" + "\t\t" + "Cylinders" + "   " + "Engine Displacement"+ "\t" + "horsepower" + "\t" + "weight   " + "\t" + "Acceleration" + "\t" + " Year");
              System.out.println(cMpg + "\t\t" + cCyl + "\t\t" + cEd + "\t\t" + cHorse + "\t\t" + cWeight + "\t\t" + cAccel + "\t\t" + cYear);
			}

			rs.close();
			stmt.close();
			c.close();
			System.out.println();
		}
		catch(Exception e){
			//System.err.print("You entered an invalid item type(please check your spelling and make sure it is all capitalized");
			System.err.println(e.getMessage());
			System.out.println("Program Ending...");
			System.exit(0);
		}
	}
	
	
	public static void userOption10(String inputType, String var){
        try{
            String dbName;
            dbName = "/Users/emeliobarba/eclipse-workspace/proj.zip_expanded/proj/Final/data.db";
            String connStr = new String("jdbc:sqlite:");
            connStr = connStr + dbName;
            Statement stmt;
            Connection c;
            c = DriverManager.getConnection(connStr);
            stmt = c.createStatement();
            //Insert SQL here
            //Use our tables/columns for this query
            stmt.executeUpdate(
                    "Update car_details " +
                    "Set year = " + inputType + " " +
                    "Where car_details.ID = '" + var + "';");

            stmt.close();
            c.close();
            System.out.println();
        }
        catch(Exception e){
            //System.err.print("You entered an invalid item type(please check your spelling and make sure it is all capitalized");
            System.err.println(e.getMessage());
            System.out.println("Program Ending...");
            System.exit(0);
        }
    }
	
	public static void userOption11(String inputType){
		try{
			String dbName;
			dbName = "C://Users//bruce duong//eclipse-workspace//Final.zip_expanded//Final//data.db";
			String connStr = new String("jdbc:sqlite:");
			connStr = connStr + dbName;
			Statement stmt;
			Connection c;
			c = DriverManager.getConnection(connStr);
			stmt = c.createStatement();
			//Insert SQL here
			//Use our tables/columns for this query
			stmt.execute(
					"DELETE " +
					"From car_details " +
					"Where ID =" + inputType +";");
			String IDdeleted = inputType;
		     System.out.println("Rows impacted : " + IDdeleted );
             System.out.println("You have successfully deleted the car entry with the ID: " + inputType);
			stmt.close();
			c.close();
			System.out.println();
		}
		catch(Exception e){
			//System.err.print("You entered an invalid item type(please check your spelling and make sure it is all capitalized");
			System.err.println(e.getMessage());
			System.out.println("Program Ending...");
			System.exit(0);
		}
	}	
	

	public static void userOption12(){
		try{
			String dbName;
			dbName = "C://Users//bruce duong//eclipse-workspace//Final.zip_expanded//Final//data.db";
			String connStr = new String("jdbc:sqlite:");
			connStr = connStr + dbName;
			Statement stmt;
			Connection c;
			c = DriverManager.getConnection(connStr);
			stmt = c.createStatement();
			//Insert SQL here
			//Use our tables/columns for this query
			stmt.executeUpdate(
					"INSERT into car_details" +" (`ID`,mpg,cylinders,edispl,horsepower,weight,accel,`year`) VALUES(1,18,8,307,130,3504,12,1970)");
            System.out.println("You have successfully Added the car entry ");
			stmt.close();
			c.close();
			System.out.println();
		}
		catch(Exception e){
			//System.err.print("You entered an invalid item type(please check your spelling and make sure it is all capitalized");
			System.err.println(e.getMessage());
			System.out.println("Program Ending...");
			System.exit(0);
		}
	}	
	
	
	
	public static void adminOutputAvailability(String name, String supplier){
		try{
			String dbName;
			dbName = "C://Users//bruce duong//eclipse-workspace//Final.zip_expanded//Final//data.db";
			String connStr = new String("jdbc:sqlite:");
			connStr = connStr + dbName;
			Statement stmt;
			Connection c;
			c = DriverManager.getConnection(connStr);
			stmt = c.createStatement();
			
			ResultSet rs;
			String sql = "SELECT s_name, p_name, ps_availibility " +
						 "FROM supplier, part, partsupp " +
						 "WHERE p_partid = ps_partid and s_suppid = ps_suppid " +
						 "and p_name LIKE '%" + name + "%' " +
				 		 "and s_name = '" + supplier + "'; ";
			
			//System.out.println(sql);
			rs = stmt.executeQuery(sql);
			
			String S = rs.getString("s_name");
			String N = rs.getString("p_name");
			int amount = rs.getInt("ps_availibility");
			
			System.out.println(S + " | " + N + " | " + "Amount: " + amount);
			
			
			rs.close();
			stmt.close();
			c.close();
		}
		catch(Exception e){
			System.err.println(e.getMessage());
			System.out.println("Program Ending...");
			System.exit(0);
		}
	}
	
	//Admin: List parts from specific supplier
	public static void adminListParts(String supplier){
		try{
			String dbName;
			dbName = "C://Users//bruce duong//eclipse-workspace//Final.zip_expanded//Final//data.db";
			String connStr = new String("jdbc:sqlite:");
			connStr = connStr + dbName;
			Statement stmt;
			Connection c;
			c = DriverManager.getConnection(connStr);
			stmt = c.createStatement();
			
			ResultSet rs = stmt.executeQuery(
					"Select p_name " +
					"From part, partsupp, supplier " +
					"Where " +
					" p_partid = ps_partid and ps_suppid = s_suppid and s_name= '" + supplier + "';");
			int counter = 1;
			while(rs.next()){
				String pName = rs.getString("p_name");
				System.out.println(counter++ + "\t" + pName);
			}

			rs.close();
			stmt.close();
			c.close();
			System.out.println();
		}
		catch(Exception e){
			System.err.println(e.getMessage());
			System.out.println("Program Ending...");
			System.exit(0);
		}
	}
	
	//Admin: Get price of specific part from specific supplier
	public static double adminPriceOfOnePart(String supplier, String item){
		double retailedprice = 0;
		try{
			String dbName;
			dbName = "C://Users//bruce duong//eclipse-workspace//Final.zip_expanded//Final//data.db";
			String connStr = new String("jdbc:sqlite:");
			connStr = connStr + dbName;
			Statement stmt;
			Connection c;
			c = DriverManager.getConnection(connStr);
			stmt = c.createStatement();
			
			ResultSet rs = stmt.executeQuery(
					"SELECT ps_retailprice " +
					"FROM part, partsupp, supplier " +
					"WHERE p_partid = ps_partid and ps_suppid = s_suppid " +
					"and p_name LIKE '%" + item + "%' " +
					"and s_name = '"+ supplier + "';");
			
			retailedprice = rs.getDouble("ps_retailprice");
			rs.close();
			stmt.close();
			c.close();
			System.out.println();
		}
		catch(Exception e){
			
			System.err.println(e.getMessage());
			System.out.println("Program Ending...");
			System.exit(0);
		}
		return retailedprice;
	}
	
	//Admin Option 1 and Manual Option(1)
	public static void adminOption1o1(String supplier, String item, double price){
		try{
			String dbName;
			dbName = "C://Users//bruce duong//eclipse-workspace//Final.zip_expanded//Final//data.db";
			String connStr = new String("jdbc:sqlite:");
			connStr = connStr + dbName;
			Statement stmt;
			Connection c;
			c = DriverManager.getConnection(connStr);
			stmt = c.createStatement();
			
			stmt.executeUpdate(
				"UPDATE partsupp " +
				"SET ps_retailprice = " + price + " " +
				"WHERE ps_partid = (SELECT p_partid " +
				 				   "FROM part " +
				 				   "WHERE p_name LIKE '%" + item + "%') " +
				"and ps_suppid = (SELECT s_suppid " +
				                 "FROM supplier " +
								 "WHERE s_name = '" + supplier + "'); ");
			//System.out.println("5");
			
			stmt.close();
			c.close();
			System.out.println();
		}
		catch(Exception e){
			System.err.println(e.getMessage());
			System.out.println("Program Ending...");
			System.exit(0);
		}
	}
	
	public static void adminOption2(String name, String type){//Insert new Part
		try{
			String dbName;
			dbName = "C://Users//bruce duong//eclipse-workspace//Final.zip_expanded//Final//data.db";
			String connStr = new String("jdbc:sqlite:");
			connStr = connStr + dbName;
			Statement stmt;
			Connection c;
			c = DriverManager.getConnection(connStr);
			stmt = c.createStatement();
			
			ResultSet rs;
			String sql;
			
			//Find Last Part ID
				sql = "SELECT max(p_partid) " +
					  "FROM part ";
				
				rs = stmt.executeQuery(sql);
				
				int partid = rs.getInt("max(p_partid)");
				partid++;
			//Insert into part table
			
				sql = "INSERT into part " +
					  "VALUES( '" + name + "', " + partid + ", '" + type + "', 909);";
				
				System.out.println(sql);
				
				stmt.executeUpdate(sql);
			
			System.out.println();
			System.out.println("Added Sucessfully!");
			
			
			stmt.close();
			c.close();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public static void adminOption3(String delete){
		try{
			String dbName;
			dbName = "C://Users//bruce duong//eclipse-workspace//Final.zip_expanded//Final//data.db";
			String connStr = new String("jdbc:sqlite:");
			connStr = connStr + dbName;
			Statement stmt;
			Connection c;
			c = DriverManager.getConnection(connStr);
			stmt = c.createStatement();
			
			String sql = "DELETE from part " +
						"WHERE p_name LIKE '%" + delete + "%' ;";
			
			stmt.executeUpdate(sql);
			
			System.out.println("Deletion Successful!");
			
			stmt.close();
			c.close();
		}
		catch(Exception e){
			System.err.println(e.getMessage());
			System.out.println("Program Ending...");
			System.exit(0);
		}
	}
	
	public static void adminOption4(String name, String supplier, int amount){//Change amount in ps_availibility
		try{
			String dbName;
			dbName = "C://Users//bruce duong//eclipse-workspace//Final.zip_expanded//Final//data.db";
			String connStr = new String("jdbc:sqlite:");
			connStr = connStr + dbName;
			Statement stmt;
			Connection c;
			c = DriverManager.getConnection(connStr);
			stmt = c.createStatement();
			
			
			//Insert sql here.
			String sql = "UPDATE partsupp " +
						 "SET ps_availibility = " + amount + " " +
						 "WHERE ps_partid = (SELECT p_partid " +
				 				   			"FROM part, partsupp " +
				 				   			"WHERE " +
				 				   			"p_name LIKE '%" + name + "%' )" +
				 		 "and " +
				 		 "ps_suppid = (SELECT s_suppid " +
				 		 				   "FROM supplier " +
				 		 				   "WHERE s_name = '" + supplier + "'); ";
			stmt.executeUpdate(sql);
			System.out.println("Update Successful!");
			
			stmt.close();
			c.close();
		}
		catch(Exception e){
			System.err.println(e.getMessage());
			System.out.println("Program Ending...");
			System.exit(0);
		}
	}
	
	
}
