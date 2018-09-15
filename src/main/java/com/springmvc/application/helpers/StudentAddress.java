package com.springmvc.application.helpers;

import javax.persistence.*;

@Entity
@Table(name = "StudentAddress")
public class StudentAddress {

    @Id
    @GeneratedValue
    private int addressId;


    private String addressDetail;

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }

    public int getAddressId() {
        return addressId;
    }

    public String getAddressDetail() {
        return addressDetail;
    }
}
