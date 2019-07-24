package com.ejb.sessionbean;

import javax.ejb.Local;
import javax.ejb.Remote;

/**
 * Created by IntelliJ IDEA.
 * User: lixiaofan0122@gmail.com
 * Date: 3/7/19
 * Time: 1:47 PM
 */
@Remote
public interface Address {
    void createAddress();
}
