package com.xs.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public class JDBCExecutor {

    public static void main(String... args){
        DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost",
                "hplussport", "puanxuesheng", "");
        try{
            Connection connection = dcm.getConnection();
            CustomerDAO customerDAO = new CustomerDAO(connection);
            Customer customer = new Customer();
//            customer.setFirstName("George");
//            customer.setLastName("Washington");
//            customer.setEmail("george.washington@wh.gov");
//            customer.setPhone("(555) 555-6543");
//            customer.setAddress("1234 Main St");
//            customer.setCity("Mount Vernon");
//            customer.setState("VA");
//            customer.setZipCode("22121");
//            customerDAO.create(customer);

            //find customer by ID
            customer = customerDAO.findById(120);

            System.out.println("ID: "+customer.getId());
            System.out.println("FirstName: "+customer.getFirstName());

            //set the coustomer name to something else in the database.
            customer.setFirstName("Ronald");
            customer = customerDAO.update(customer);
            System.out.println("ID: "+customer.getId());
            System.out.println("FirstName: "+customer.getFirstName());


            //Execute a function that key in the order number and return a order with a list of order items.

           orderInfo info = new orderInfo();
            ordersDAO orderdao = new ordersDAO(connection);
            info = orderdao.findById(1117);
                System.out.println(info.toString());


        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
