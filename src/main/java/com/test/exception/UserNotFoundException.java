package com.test.exception;

/**
 * Created by IntelliJ IDEA.
 * User: luxer
 * Date: 10/15/2017
 * Time: 19:38
 * To change this template use File | Settings | File Templates.
 */
public class UserNotFoundException extends Exception {
    private final long serialVersionUID = 1L;

    /*private String message = "没有该用户...";
    public UserNotFoundException() {
        System.out.println("======================");
        System.out.println(message);
        System.out.println("======================");
    }*/

    public UserNotFoundException(String message) {
        super(message);
    }
/*@Override
    public void printStackTrace() {
//        super.printStackTrace();
        System.out.println("======================");
        System.out.println(message);
        System.out.println("======================");
    }*/
}
