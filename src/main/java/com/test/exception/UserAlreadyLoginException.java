package com.test.exception;

/**
 * Created by IntelliJ IDEA.
 * User: luxer
 * Date: 10/15/2017
 * Time: 18:14
 * To change this template use File | Settings | File Templates.
 */
public class UserAlreadyLoginException extends Exception {
    private long serialVersionUID = 1L;

    /*private String message = "已登录，不需要重复登录...";
    public UserAlreadyLoginException() {
        System.out.println("======================");
        System.out.println(message);
        System.out.println("======================");
    }*/

    public UserAlreadyLoginException() {
        super();
    }

    public UserAlreadyLoginException(String message) {
        super(message);
    }

   /* @Override
    public void printStackTrace() {
//        super.printStackTrace();
        System.out.println("======================");
        System.out.println(message);
        System.out.println("======================");
    }*/
}
