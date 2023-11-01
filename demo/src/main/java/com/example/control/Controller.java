package com.example.control;

public class Controller {

    private static Controller controller;

    public static Controller getInstance(){
        if(controller==null) controller = new Controller();
        return controller;
    }

    private Controller(){

    }

}
