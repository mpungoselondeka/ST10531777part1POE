
package com.mycompany.main;

//imports Scanner so we can get user input
import java.util.Scanner;

//creates the main class
public class Main {
    //creates Scanner for user input
    static Scanner input = new Scanner(System.in);
    
    //stores the user's entered details
    static String username;
    static String password;
    static String cellphone;
    
    //stores the registered username
    static String registeredUsername;
    
    //stores the registered password
    static String registeredPassword;
    
    //stores the registered cellphone number
    static String registeredCellPhone;
    
    //creates the username checking method
    public static boolean checkUserName(String username) {
        //Username must have exactly 5 characters and must contain an underscore
        if(username.length()== 5 && username.contains("_")){;
        return(true);
    }else{
    return false;
}
}
 
    //creates the password checking method
    public static boolean checkPasswordComplexity(String password) {
        
        //password must have at least 8 characters
        //and contains uppercase, lowercase, number, special characters
        if(password.length()>= 8 
                && password.matches (".*[A-Z].*")
                && password.matches(".*[a-z].*")
                && password.matches(".*[0-9].*")
                && password.matches(".*[^a-zA-Z0-9].*")){
            return true;
        }else{
        return false;
        }
    }
    
    //creates the cellphone checking method
    public static boolean checkCellPhoneNumber(String number) {
        
        //Number must start with +27 followed by exactly 9 digits
       if (number.matches("^\\+27[0-9]{9}$")){
        return true;
    }else{
        return false;
            }
    }
    
   //creates the registration method
    public static void registerUser(){
        //Infinite loop for userename
       while (true){
        
            //Ask for username
            System.out.print("Enter your username:");
            username = input.nextLine();
            
            //check username
            boolean usernameCorrect = checkUserName(username);
            
            //check if username is correct
            if(usernameCorrect){
                break;
            }else{
                System.out.println("username is incorrectly formatted. please try again");
            }
       }
        //Infinite loop for password
        while (true){
            //Ask for password
            System.out.print("Enter your password:");
            password = input.nextLine();
            
            //check password
            boolean passwordCorrect = checkPasswordComplexity(password);

            //check if password is correct
            if(passwordCorrect){
                break;
            }else{
                System.out.println("password is incorrectly formatted. please try again.");
            }
        }
        
        //Infinite loop for cellphone number
        while(true){
            //Ask for cellphone number
            System.out.print("Enter your cellphone number(+27:");
            cellphone = input.nextLine();
            
            //check cellphone number
             boolean phoneCorrect = checkCellPhoneNumber(cellphone);
             
             //check if cellphone number is correct
             if(phoneCorrect){
                 break;
             }else{
                 System.out.println("cellphone number is incorrectly formatted. please try again.");
             }
        }
            
                //check if all registration details are correct
                //save the valid username
                registeredUsername= username;
                //save the valid password
                registeredPassword= password;
                //save the valid cellphone number
                registeredCellPhone= cellphone;
                //display success message
                System.out.println("User registered successfully.");
    }
          //checks the login details
          public static boolean loginUser(String username, String password) {
              //Infinite loop for login
              while(true){
                  //compare the entered details with registered details
                  if(username.equals(registeredUsername)
                          && password.equals(registeredPassword)){
                      return true;
                  }else{
                //login details are incorrect
                System.out.println("username or password is incorrect, please try again.");
                //Re-prompt the user for username
                System.out.print("Enter your username to login:");
                username= input.nextLine();
                //Re-prompt the user for password
                System.out.print("Enter your password to login: ");
                password= input.nextLine();
            }
        }
    }
    
      //Returns the login status message
          public static String returnLoginStatus(boolean loginSuccessful) {
              //check if login was successful
              if(loginSuccessful) {
                  return"welcome,it is great to see you again.";
              }else{
                  return"username or password incorrect, please try again.";
              }
          }
    
    //main method where the program starts
    public static void main(String[] args) {
        
        //call the registration method
        registerUser();
        
        //ask the user to login
        System.out.print("Enter username to login:");
        String loginUsername= input.nextLine();
        
        System.out.print("Enter password to login:");
        String loginPassword= input.nextLine();
        
        //call login method
        boolean loginSuccessful= loginUser(loginUsername,loginPassword);
        
        //call login status method
        System.out.println(returnLoginStatus(loginSuccessful));
    }
}
        
