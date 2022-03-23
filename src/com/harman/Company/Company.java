package com.harman.Company;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Company {

    public static void main(String[] args) {
        try {
            Connection c= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/company?autoReconnect=true&useSSL=false","root","");
            Scanner s =new Scanner(System.in);
            String empcode,empname,designation,salary,mobnum;
            System.out.println(" Enter Employee Code :");
            empcode=s.nextLine();
            System.out.println(" Enter Employee Name :");
            empname=s.nextLine();
            System.out.println(" Enter Designation :");
            designation=s.nextLine();
            System.out.println(" Enter Salary :");
            salary=s.nextLine();
            System.out.println(" Enter Mobile Number :");
            mobnum=s.nextLine();

            Statement stmt=c.createStatement();
            stmt.executeUpdate("INSERT INTO employee(  `empCode`, `empName`, `designation`, `Salary`, `MobNum`) VALUES('"+empcode+"','"+empname+"','"+designation+"',"+salary+","+mobnum+")");
            System.out.println("Inserted Successfully");
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }

}