package com.ejb.test;

import com.ejb.sessionbean.Person;
import org.junit.Test;

import javax.ejb.EJB;

/**
 * Created by IntelliJ IDEA.
 * User: lixiaofan0122@gmail.com
 * Date: 3/15/19
 * Time: 2:41 PM
 */
public class Junit {
    @EJB
    private static Person person;

    @Test
    public void MyTest() {
        System.out.println("Start Junit Test [MyTest] Start...");
        person.createPerson();
        System.out.println("Start Junit Test [MyTest] End...");
    }
}
