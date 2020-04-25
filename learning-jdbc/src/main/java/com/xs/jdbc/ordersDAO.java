package com.xs.jdbc;

import com.xs.jdbc.util.DataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ordersDAO extends DataAccessObject<orderInfo>{

    private static final String FINDBYID = "SELECT " +
                                            "c.first_name cFirstName, c.last_name cLastName, c.email cEmail, o.order_id, " +
                                            "o.creation_date, o.total_due, o.status, " +
                                            "s.first_name sFirstName, s.last_name sLastName, s.email sEmail, " +
                                            "ol.quantity, p.code, p.name, p.size, p.variety, p.price " +
                                            "FROM orders o " +
                                            "JOIN customer c on o.customer_id = c.customer_id " +
                                            "JOIN salesperson s on o.salesperson_id = s.salesperson_id " +
                                            "JOIN order_item ol on ol.order_id = o.order_id " +
                                            "JOIN product p on ol.product_id = p.product_id " +
                                            "WHERE o.order_id = ?";



    public ordersDAO(Connection connection) {
        super(connection);
    }

    @Override
    public orderInfo findById(long id) {

        orderInfo order = new orderInfo();
        List<OrderItem> items = new ArrayList<>();
        int i = 0;

        try(PreparedStatement statement = this.connection.prepareStatement(FINDBYID))
        {

            statement.setLong(1,id);
            ResultSet rs = statement.executeQuery();
            while(rs.next())
            {
                if(i ==0)
                {
                    //order details
                    order.setId(rs.getLong("order_id"));
                    order.setTotalDue(rs.getLong("total_due"));
                    order.setStatus(rs.getString("status"));
                    order.setCreationDate(rs.getString("creation_date"));

                    //customer details
                    order.setcFirstName(rs.getString("cFirstName"));
                    order.setcLastName(rs.getString("cLastName"));
                    order.setcEmail(rs.getString("cEmail"));

                    //sales details
                    order.setsFirstName(rs.getString("sFirstName"));
                    order.setsLastName(rs.getString("sLastName"));
                    order.setsEmail(rs.getString("sEmail"));

                    i++;
                }
                //product details
                OrderItem item = new OrderItem();
                item.setCode(rs.getString("code"));
                item.setPrice(rs.getDouble("price"));
                item.setSize(rs.getLong("size"));
                item.setName(rs.getString("name"));
                item.setVariety(rs.getString("variety"));

                //order_item details
                item.setQuantity(rs.getLong("quantity"));

                items.add(item);
            }

        }catch(Exception e){e.printStackTrace();}

        order.setOrderlines(items);
        return order;
    }


    @Override
    public List<orderInfo> findAll() {
        return null;
    }

    @Override
    public orderInfo update(orderInfo dto) {
        return null;
    }

    @Override
    public orderInfo create(orderInfo dto) {
        return null;
    }

    @Override
    public void delete(long id) {

    }

    @Override
    protected int getLastVal(String sequence) {
        return super.getLastVal(sequence);
    }
}
