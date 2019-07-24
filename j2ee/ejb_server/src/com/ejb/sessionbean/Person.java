package com.ejb.sessionbean;

import javax.ejb.Remote;

/**
 * Created by IntelliJ IDEA.
 * User: lixiaofan0122@gmail.com
 * Date: 3/15/19
 * Time: 2:34 PM
 */
@Remote
public interface Person {
    void createPerson();
}
