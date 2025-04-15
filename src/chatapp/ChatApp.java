/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package chatapp;

import java.io.Console;

/**
 *
 * @author maxwe
 */
public class ChatApp {

    /**
     * @param args the command line arguments
     */
    public static boolean checkUserName(String userName){
        boolean hasUnderScore = false;
        boolean fiveCharactersPlus = false;
        
        for (char ch: userName.toCharArray()){
            if(ch == '_'){
                hasUnderScore = true;
            }else if(userName.length() > 5){
                fiveCharactersPlus = true;
            }
            
            
        }
        return hasUnderScore && fiveCharactersPlus;
    }
    //Password validation method
    public static boolean checkPasswordComplexity(String password){
        boolean hasLetter = false;
        boolean hasDigit = false;
        boolean hasSymbole = false;
        boolean eightCharactersPlus = false;
        
        for(char c: password.toCharArray()){
            if (Character.isUpperCase(c)){
                hasLetter = true;
            }else if (Character.isDigit(c)){
                hasDigit =true;
            }else if (!Character.isLetterOrDigit(c)){
                hasSymbole = true;
            }else if(password.length() > 8){
                eightCharactersPlus = true;
            }
                    
        }
        
        return hasLetter && hasDigit && hasSymbole && eightCharactersPlus;


    }
    
    public static boolean loginUser(String userName, String password) {
    boolean loggedIn = false;

    System.out.println("ACCOUNT SUCCESSFULLY CREATED");
    System.out.println("Use your credentials to login");

    Console input = System.console();

    String loginUserName = input.readLine("Enter Username: ");
    String loginPassword = input.readLine("Enter Password: ");

    while (!loginUserName.equals(userName) || !loginPassword.equals(password)) {
        System.out.println("Incorrect Username or Password");
        loginUserName = input.readLine("Enter Username: ");
        loginPassword = input.readLine("Enter Password: ");
    }

    System.out.println("Login successful");
    loggedIn = true;
    dashboard(userName);

    return loggedIn;
    
}

    
    
    
//    public static boolean checkCellPhoneNumber(){
//        
//    }
    
    public static void dashboard(String userName){
        System.out.print("Hey " + userName + "!, welcome to you Chatapp dashboard");
    }
    public static void main(String[] args) {
        
        registerUser();
        
    }
    
   // REGISTER USER method updated:
    public static void registerUser() {
        Console input = System.console();

        System.out.println("Hello");

        String userName = input.readLine("Enter Username: ");

        if (!checkUserName(userName)) {
            System.out.println("Username should contain an underscore and be more than 5 characters long.");
            return; // Exit if username is invalid
        }

        System.out.println("Username successfully captured");

        String password = input.readLine("Enter Password: ");

        if (!checkPasswordComplexity(password)) {
            System.out.println("Password should be more than 8 characters, and contain a capital letter, number, and symbol.");
            return; // Exit if password is invalid
        }

        System.out.println("Password successfully captured");

        // Proceed to login
        loginUser(userName, password);
    }
    
}
