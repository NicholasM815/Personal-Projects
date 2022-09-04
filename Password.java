import java.util.Scanner;

//This class will be responsible for obtaining user input.
//It only contains a single function, which is response.
//it will use the scanner to obtain input from the user,
//about what to include in the password.

public class Password {

    //This function will be responsible for getting input from the user
    //related to how the user wants their password to be generated.
    //They can choose between upercase and lowercase letters, and they can
    //decide if the want to use numbers and/or if they want to use symbols.
    //This function will then call the make function in the combine class.

    public void response() {

        //Introduction to the password generator:
        System.out.println("Welcome to the password generator");
        System.out.println();
        //End of introduction

        //This portion of code will be responsible for getting user input
        //and asking the user if they want to use uppercase letters in their
        //password. If answered "yes" or "Yes", then uppercase letters will be used.
        //If answered anything else, then lowercase letters will be used.

        System.out.println("Would you like to use Uppercase Letters? If yes, enter 'yes' or 'Yes'. if not, enter anything else.");
        System.out.println();
        Scanner scan = new Scanner(System.in);

        String uppercase = scan.nextLine();

        if(uppercase.equals("Yes") || uppercase.equals("yes")) {
            System.out.println();
            System.out.println("Uppercase letters will be used.");
            System.out.println();
        }

        else {
            System.out.println();
            System.out.println("Lowercase letters will be used.");
            System.out.println();
        }

        //This is the end of the lowercase/undercase portion of the user input.

        //This portion of code will ask the user if they want to use numbers in their passcode.'
        //If they answer "yes" or "Yes", then numbers will be used in the password.
        //If they answer anything else, Then numbers will not be used in the passcode.

        System.out.println("Would you like to use numbers? If yes, enter 'yes' or 'Yes'. if not, enter anything else.");
        System.out.println();

        String numbers = scan.nextLine();

        if(numbers.equals("Yes") || numbers.equals("yes")) {
            System.out.println();
            System.out.println("Numbers will be used.");
            System.out.println();
        }

        else {
            System.out.println();
            System.out.println("Numbers will not be used.");
            System.out.println();
        }

        //This is the end of the numbers portion of the code.

        //This portion of the code will ask the user if they want to use symbols in their password.
        //If the user enters "yes" or "Yes", then symbols will be used in the generation of this password.
        //If the user enters anything else, then symbols will not be used in the generation of this password.

        System.out.println("Would you like to use symbols? If yes, enter 'yes' or 'Yes'. if not, enter anything else.");
        System.out.println();

        String symbols = scan.nextLine();


        if(symbols.equals("Yes") || symbols.equals("yes")) {
            System.out.println();
            System.out.println("Symbols will be used.");
            System.out.println();
        }

        else {
            System.out.println();
            System.out.println("Symbols will not be used.");
            System.out.println();
        }

        //This is the end of the symbols portion of the code.

        System.out.println("How large would you like the passowrd to be(minimum of 8 charachters)?");
        System.out.println();

        int length = scan.nextInt();

        if(length < 8) {
            System.out.println();
            System.out.println("Length of the password is too small. Must be at least 8 characers. Please try again.");
            System.out.println();
            response(); //start again if password is too small.
            System.exit(1);
        }

        else {
            System.out.println();
            System.out.println("The password will be " + length + " charachters long.");
            System.out.println();
            scan.close();
        }

        Combine finish = new Combine(); 

        //this function will call other functions to assemble the password:
        finish.make(length, uppercase, numbers, symbols); 
    }
}
