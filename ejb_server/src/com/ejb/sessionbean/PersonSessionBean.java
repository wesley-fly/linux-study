package com.ejb.sessionbean;

import com.ejb.entity.PersonEntityBean;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.Timestamp;

/**
 * Created by IntelliJ IDEA.
 * User: lixiaofan0122@gmail.com
 * Date: 3/15/19
 * Time: 2:34 PM
 */
@Stateless
public class PersonSessionBean implements PersonSessionBeanRemote {
    @PersistenceContext(unitName = "Transaction-ejb")
    EntityManager entityManager;
    @EJB
    private AddressSessionBeanRemote addressSessionBeanRemote;
    @Override
    public void createPerson() {
        PersonEntityBean personEntityBean = new PersonEntityBean();
        personEntityBean.setId(1);
        personEntityBean.setFirstName("Lee");
        personEntityBean.setLastName("Xiaofan");
        personEntityBean.setAge(28);
        personEntityBean.setAttribute("Required");
        personEntityBean.setCreateTime(new Timestamp(System.currentTimeMillis()));

        entityManager.persist(personEntityBean);
        addressSessionBeanRemote.createAddress();

        System.out.println("-----------Person EJB execute completely!-----------------");
    }
}
