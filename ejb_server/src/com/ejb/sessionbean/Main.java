package com.ejb.sessionbean;

import javax.ejb.EJB;

/**
 * Created by IntelliJ IDEA.
 * User: lixiaofan0122@gmail.com
 * Date: 3/18/19
 * Time: 1:23 PM
 */
public class Main {
    @EJB
    private static Address person;

    public static void main(String args[]) {
        person.createAddress();
    }
}
