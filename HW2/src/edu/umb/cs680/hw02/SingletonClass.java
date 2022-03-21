package edu.umb.cs680.hw02;

public class SingletonClass {
    private SingletonClass(){}
    private static SingletonClass instance = null;

    public static SingletonClass getInstance(){
        if(instance == null){
            instance = new SingletonClass();
        }
        return instance;
    }

    public static void main(String[] args) {

    }
}
