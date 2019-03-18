package com.ejb.sessionbean;

import com.ejb.entity.AddressEntityBean;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.Timestamp;

/**
 * Created by IntelliJ IDEA.
 * User: lixiaofan0122@gmail.com
 * Date: 3/7/19
 * Time: 1:49 PM
 */

public @Stateless class AddressBean implements Address {
    @PersistenceContext(unitName = "Transaction-ejb")
    EntityManager entityManager;

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public void createAddress() {
        AddressEntityBean addressEntityBean = new AddressEntityBean();
        addressEntityBean.setId(1);
        addressEntityBean.setCountry("China");
        addressEntityBean.setCity("Xi'an");
        addressEntityBean.setStreet("KeJi 2'nd Road");
        addressEntityBean.setPostCode("710000");
        addressEntityBean.setAttribute("Required");
        addressEntityBean.setCreateTime(new Timestamp(System.currentTimeMillis()));

        entityManager.persist(addressEntityBean);

        System.out.println("-----------Address EJB execute completely!-----------------");
    }
}
