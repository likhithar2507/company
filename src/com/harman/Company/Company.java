package com.harman.Company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Company {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int option;
        while(true) {

            System.out.println("1. Add Employee ");
            System.out.println("2. View All Employees");
            System.out.println("3. EXIT");
            System.out.println("Enter Your Choice from the above Menu : ");
            option=in.nextInt();
            switch(option) {
                case 1:
                    try {
                        Connection c= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/company?autoReconnect=true&useSSL=false","root","");
                        Scanner s=new Scanner(System.in);
                        String empCode, name, phone, email, designation,salary, companyname, address;
                        System.out.println("Emp_code :");
                        empCode=s.nextLine();
                        System.out.println("Name :");
                        name=s.nextLine();
                        System.out.println("Mobile Number :");
                        phone=s.nextLine();
                        System.out.println("Email :");
                        email=s.nextLine();
                        System.out.println("Designation :");
                        designation=s.nextLine();
                        System.out.println("Salary :");
                        salary=s.nextLine();
                        System.out.println("Company :");
                        companyname=s.nextLine();
                        System.out.println("Address :");
                        address=s.nextLine();


                        Statement stmt=c.createStatement();
                        stmt.executeUpdate("INSERT INTO employees(empCode, `name`, `phone`, `email`, `designation`, `salary`, `company`, `address`) VALUES ("+empCode+",'"+name+"',"+phone+",'"+email+"','"+designation+"',"+salary+",'"+companyname+"','"+address+"')");
                        System.out.println("Inserted Successfully");
                    }
                    catch(Exception e) {
                        System.out.println(e);
                    }
                    break;
                case 2:
                    try {
                        Connection c= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/company?autoReconnect=true&useSSL=false","root","");
                        Statement stmt=c.createStatement();
                        ResultSet rs=stmt.executeQuery("select ID,empCode,name,phone,email,designation,salary,company,address from employees");
                        while(rs.next()) {
                            System.out.println("ID :"+rs.getInt("ID"));
                            System.out.println("Employee Code :"+rs.getInt("empCode"));
                            System.out.println("Name :"+rs.getString("name"));
                            System.out.println("Phone :"+rs.getBigDecimal("phone"));
                            System.out.println("Email :"+rs.getString("email"));
                            System.out.println("Designation :"+rs.getString("designation"));
                            System.out.println("Salary :"+rs.getInt("salary"));
                            System.out.println("Companyname :"+rs.getString("company"));
                            System.out.println("Address :"+rs.getString("address"));
                        }
                    }
                    catch(Exception e) {
                        System.out.println(e);
                    }
                    break;

                case 3:
                    System.exit(0);

                default:
                    System.out.println("YouR choosed Ivalid option .....try again by choosing valid choice!");

            }
        }
    }

}