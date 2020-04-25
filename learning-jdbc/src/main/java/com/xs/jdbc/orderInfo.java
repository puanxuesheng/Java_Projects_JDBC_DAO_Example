package com.xs.jdbc;

import com.xs.jdbc.util.DataTransferObject;

import java.util.List;

public class orderInfo implements DataTransferObject {

    private long id;
    private String cFirstName;
    private String cLastName;
    private String cEmail;
    private String CreationDate;
    private long totalDue;
    private String status;
    private String sFirstName;
    private String sLastName;
    private String sEmail;
    private List<OrderItem> orderlines;

    public List<OrderItem> getOrderlines() {
        return orderlines;
    }

    public void setOrderlines(List<OrderItem> orderlines) {
        this.orderlines = orderlines;
    }

    @Override
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getcFirstName() {
        return cFirstName;
    }

    public void setcFirstName(String cFirstName) {
        this.cFirstName = cFirstName;
    }

    public String getcLastName() {
        return cLastName;
    }

    public void setcLastName(String cLastName) {
        this.cLastName = cLastName;
    }

    public String getcEmail() {
        return cEmail;
    }

    public void setcEmail(String cEmail) {
        this.cEmail = cEmail;
    }

    public String getCreationDate() {
        return CreationDate;
    }

    public void setCreationDate(String creationDate) {
        CreationDate = creationDate;
    }

    public long getTotalDue() {
        return totalDue;
    }

    public void setTotalDue(long totalDue) {
        this.totalDue = totalDue;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getsFirstName() {
        return sFirstName;
    }

    public void setsFirstName(String sFirstName) {
        this.sFirstName = sFirstName;
    }

    public String getsLastName() {
        return sLastName;
    }

    public void setsLastName(String sLastName) {
        this.sLastName = sLastName;
    }

    public String getsEmail() {
        return sEmail;
    }

    public void setsEmail(String sEmail) {
        this.sEmail = sEmail;
    }

    @Override
    public String toString() {
        String data = "orderInfo{" +
                "id=" + id +
                ", cFirstName='" + cFirstName + '\'' +
                ", cLastName='" + cLastName + '\'' +
                ", cEmail='" + cEmail + '\'' +
                ", CreationDate='" + CreationDate + '\'' +
                ", totalDue=" + totalDue +
                ", status='" + status + '\'' +
                ", sFirstName='" + sFirstName + '\'' +
                ", sLastName='" + sLastName + '\'' +
                ", sEmail='" + sEmail + '\'' + '}';

        StringBuilder sb = new StringBuilder();
        for(OrderItem i : orderlines)
        {
            sb.append(i.toString());
                    sb.append("\n");
        }

        return data + sb.toString();
    }
}
