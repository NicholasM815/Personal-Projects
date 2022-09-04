import java.util.Random;

//This class contains ten functions. The first function,
//make, serves to call 8 of the other functions depending on what
//the user enters, and what password will be created based on those inputs.
//The last function, show, will convert the password, which is contained
//in a character array, into a string. It will then print the string.

public class Combine {

    //This function will help to assemble the password, by calling
    //all of the neccesary functions in order to assemble a certain
    //password with specific contents, such as lowercase/uppecase letters,
    //numbers, and symbols.

    public void make(int length, String uppercase, String numbers, String symbols) {

        if(uppercase.equals("Yes") || uppercase.equals(("yes"))) {

            if(numbers.equals("Yes") || numbers.equals("yes")) {

                if(symbols.equals("Yes") || symbols.equals("yes")) { //if uppercase, symbols and numbers.
                    upperNumberSymbol(length);
                }
                
                else { //uppercase and numbers, but no symbols.
                    upperNumber(length);
                }
            }

            else { 

                if(symbols.equals("Yes") || symbols.equals("yes")) { //if uppercase and symbols but no numbers.
                    upperSymbol(length);
                }

                else { //if only uppercase letters.
                    upper(length);
                }
            }
        }

        else { //if not uppercase letters.

            if(numbers.equals("Yes") || numbers.equals("yes")) {

                if(symbols.equals("Yes") || symbols.equals("yes")) { //lowercase letters, numbers and symbols.
                    lowerNumberSymbol(length);
                }

                else { //lowercase and numbers, but no special characters.
                    lowerNumber(length);
                }
            }

            else { 

                if(symbols.equals("Yes") || symbols.equals("yes")) { //if lowercase and symbols but no numbers.
                    lowerSymbol(length);
                }

                else { //if only lowercase letters.
                    lower(length);
                }
            }
        }
    }

    //This function will be responsible for assembling a password
    //that contains uppercase letters, numbers, and symbols. It will then
    //call another function to show the finished password, after converting
    //it into a string.

    public void upperNumberSymbol(int length) {

        char letter; //for getting a letter in the password
        char passNum; //for getting a number in the password.
        char symbol; //for getting a symbol in the password.
        int minimumChoiceNumber; //for figuring out which character to use.
        int maximumChoiceNumber; //for figuring out which character to use.
        int choiceNumber; //number between maximum and minimum
        int firstVal; //location in array for guarenteed letter
        int secondVal; //location in array for guarenteed number
        int thirdVal; //location in array for gaurenteed symbol
        int i; //for looping

        Assembly make = new Assembly();
        char [] password = new char [length]; //will be converted to string.
        Random intIndex = new Random(); //random number to call 

        i = 0;
        firstVal = 0;
        secondVal = 0;
        thirdVal = 0;

        //gaurenteeing a number, letter, and symbol are used at least once each:
        letter = make.uppercase();
        passNum = make.number();
        symbol = make.symbol();

        //This while loop is for making sure that a number, 
        //letter, and symbol are all used at least once.
        
        while(firstVal == secondVal || firstVal == thirdVal || secondVal == thirdVal) {
            choiceNumber = intIndex.nextInt(0 + length);
            firstVal = choiceNumber;
            choiceNumber = intIndex.nextInt(0 + length);
            secondVal = choiceNumber;
            choiceNumber = intIndex.nextInt(0 + length);
            thirdVal = choiceNumber;
        }

        minimumChoiceNumber = 0; 
        maximumChoiceNumber = 3; 
        
        password[firstVal] = letter;
        password[secondVal] = passNum;
        password[thirdVal] = symbol;

        while(i < length) {

            if(password[i] != '\u0000') { //if the position in the password is full.
                i = i + 1;
            }

            else { //if the position in the password is not full.

                choiceNumber = intIndex.nextInt(minimumChoiceNumber + maximumChoiceNumber);

                if(choiceNumber == 0) {
                    letter = make.uppercase();
                    password[i] = letter;
                    i = i + 1;
                }

                if(choiceNumber == 1) {
                    passNum = make.number();
                    password[i] = passNum;
                    i = i + 1;
                }

                if(choiceNumber == 2) {
                    symbol = make.symbol();
                    password[i] = symbol;
                    i = i + 1;
                }
            }
        }

        show(password);

    }

    //This function will be responsible for assembling a password
    //that contains uppercase letters and numbers, but no symbols.
    //It will also call another function in order to convert the password to
    //a string, then print out the final password.

    public void upperNumber(int length) {

        char letter; //for getting a letter in the password
        char passNum; //for getting a number in the password.
        int minimumChoiceNumber; //for figuring out which character to use.
        int maximumChoiceNumber; //for figuring out which character to use.
        int choiceNumber; //number between maximum and minimum
        int firstVal; //location in array for guarenteed letter
        int secondVal; //location in array for guarenteed number
        int i; //for looping

        i = 0;
        firstVal = 0;
        secondVal = 0;
        
        Assembly make = new Assembly();
        char [] password = new char [length]; //will be converted to string.
        Random intIndex = new Random(); //random number to call 

        //gaurenteeing a letter, and number are used at least once each:
        letter = make.uppercase();
        passNum = make.number();

        while(firstVal == secondVal) {
            choiceNumber = intIndex.nextInt(0 + length);
            firstVal = choiceNumber;
            choiceNumber = intIndex.nextInt(0 + length);
            secondVal = choiceNumber;
        }
        
        password[firstVal] = letter;
        password[secondVal] = passNum;

        minimumChoiceNumber = 0; 
        maximumChoiceNumber = 2; 

        while(i < length) {

            if(password[i] != '\u0000') { //if the position in the password is full.
                i = i + 1;
            }

            else { //if the position in the password is not full.

                choiceNumber = intIndex.nextInt(minimumChoiceNumber + maximumChoiceNumber);

                if(choiceNumber == 0) {
                    letter = make.uppercase();
                    password[i] = letter;
                    i = i + 1;
                }

                if(choiceNumber == 1) {
                    passNum = make.number();
                    password[i] = passNum;
                    i = i + 1;
                }
            }
        }

        show(password);

    }

    //This function will be responsible for assembling a password that contains
    //uppercase letters and symbols, but no numbers. It will then call another
    //function to have the password be converted to a string, then printed.

    public void upperSymbol(int length) {

        char letter; //for getting a letter in the password
        char symbol; //for getting a symbol in the password.
        int minimumChoiceNumber; //for figuring out which character to use.
        int maximumChoiceNumber; //for figuring out which character to use.
        int choiceNumber; //number between maximum and minimum
        int firstVal; //location in array for guarenteed letter
        int secondVal; //location in array for guarenteed symbol
        int i; //for looping

        i = 0;
        firstVal = 0;
        secondVal = 0;

        Assembly make = new Assembly();
        char [] password = new char [length]; //will be converted to string.
        Random intIndex = new Random(); //random number to call 

        //gaurenteeing a letter, and symbol are used at least once each:
        letter = make.uppercase();
        symbol = make.symbol();

        while(firstVal == secondVal) {
            choiceNumber = intIndex.nextInt(0 + length);
            firstVal = choiceNumber;
            choiceNumber = intIndex.nextInt(0 + length);
            secondVal = choiceNumber;
        }
        
        password[firstVal] = letter;
        password[secondVal] = symbol;

        minimumChoiceNumber = 0; 
        maximumChoiceNumber = 2; 

        while(i < length) {

            if(password[i] != '\u0000') { //if the position in the password is full.
                i = i + 1;
            }

            else { //if the position in the password is not full.

                choiceNumber = intIndex.nextInt(minimumChoiceNumber + maximumChoiceNumber);

                if(choiceNumber == 0) {
                    letter = make.uppercase();
                    password[i] = letter;
                    i = i + 1;
                }

                if(choiceNumber == 1) {
                    symbol = make.symbol();
                    password[i] = symbol;
                    i = i + 1;
                }
            }
        }

        show(password);

    }

    //This function will be responsible for assembling a password that contains
    //only uppercase letters, and nothing else. It will then call another function
    //to convert the password to a string, and then print it out.

    public void upper(int length) {

        char letter; //for getting a letter in the password
        int i;

        i = 0;
        Assembly make = new Assembly();
        char [] password = new char [length]; //will be converted to string.

        while(i < length) {

            if(password[i] != '\u0000') { //if the position in the password is full.
                i = i + 1;
            }

            else { //if the position in the password is not full.
                
                letter = make.uppercase();
                password[i] = letter;
                i = i + 1;

            }
        }

        show(password);

    }

    //This function will be responsible for assembling a password
    //that contains lowercase letters, numbers, and symbols. it will
    //also call another function to print out the finished password, after
    //converting it into a string.

    public void lowerNumberSymbol(int length) {

        char letter; //for getting a letter in the password
        char passNum; //for getting a number in the password.
        char symbol; //for getting a symbol in the password.
        int minimumChoiceNumber; //for figuring out which character to use.
        int maximumChoiceNumber; //for figuring out which character to use.
        int choiceNumber; //number between maximum and minimum
        int firstVal; //location in array for guarenteed letter
        int secondVal; //location in array for guarenteed number
        int thirdVal; //location in array for gaurenteed symbol
        int i; //for looping

        Assembly make = new Assembly();
        char [] password = new char [length]; //will be converted to string.
        Random intIndex = new Random(); //random number to call 

        i = 0;
        firstVal = 0;
        secondVal = 0;
        thirdVal = 0;

        //gaurenteeing a number, letter, and symbol are used at least once each:
        letter = make.lowercase();
        passNum = make.number();
        symbol = make.symbol();

        //This while loop is for making sure that a number, 
        //letter, and symbol are all used at least once.
        
        while(firstVal == secondVal || firstVal == thirdVal || secondVal == thirdVal) {
            choiceNumber = intIndex.nextInt(0 + length);
            firstVal = choiceNumber;
            choiceNumber = intIndex.nextInt(0 + length);
            secondVal = choiceNumber;
            choiceNumber = intIndex.nextInt(0 + length);
            thirdVal = choiceNumber;
        }

        minimumChoiceNumber = 0;
        maximumChoiceNumber = 3; 
        
        password[firstVal] = letter;
        password[secondVal] = passNum;
        password[thirdVal] = symbol;

        while(i < length) {

            if(password[i] != '\u0000') { //if the position in the password is full.
                i = i + 1;
            }

            else { //if the position in the password is not full.

                choiceNumber = intIndex.nextInt(minimumChoiceNumber + maximumChoiceNumber);

                if(choiceNumber == 0) {
                    letter = make.lowercase();
                    password[i] = letter;
                    i = i + 1;
                }

                if(choiceNumber == 1) {
                    passNum = make.number();
                    password[i] = passNum;
                    i = i + 1;
                }

                if(choiceNumber == 2) {
                    symbol = make.symbol();
                    password[i] = symbol;
                    i = i + 1;
                }
            }
        }

        show(password);

    }

    //This function will be responsible for assembling a password that
    //contains lowercase letters, as well as numbers, but no symbols.
    //It will then call another function to convert the password into a 
    //string, and print it out.

    public void lowerNumber(int length) {

        char letter; //for getting a letter in the password
        char passNum; //for getting a number in the password.
        int minimumChoiceNumber; //for figuring out which character to use.
        int maximumChoiceNumber; //for figuring out which character to use.
        int choiceNumber; //number between maximum and minimum
        int firstVal; //location in array for guarenteed letter
        int secondVal; //location in array for guarenteed symbol
        int i; //for looping

        i = 0;
        firstVal = 0;
        secondVal = 0;
        
        Assembly make = new Assembly();
        char [] password = new char [length]; //will be converted to string.
        Random intIndex = new Random(); //random number to call 

        //gaurenteeing a letter, and number are used at least once each:
        letter = make.lowercase();
        passNum = make.number();

        while(firstVal == secondVal) {
            choiceNumber = intIndex.nextInt(0 + length);
            firstVal = choiceNumber;
            choiceNumber = intIndex.nextInt(0 + length);
            secondVal = choiceNumber;
        }
        
        password[firstVal] = letter;
        password[secondVal] = passNum;

        minimumChoiceNumber = 0; 
        maximumChoiceNumber = 2; 

        while(i < length) {

            if(password[i] != '\u0000') { //if the position in the password is full.
                i = i + 1;
            }

            else { //if the position in the password is not full.

                choiceNumber = intIndex.nextInt(minimumChoiceNumber + maximumChoiceNumber);

                if(choiceNumber == 0) {
                    letter = make.lowercase();
                    password[i] = letter;
                    i = i + 1;
                }

                if(choiceNumber == 1) {
                    passNum = make.number();
                    password[i] = passNum;
                    i = i + 1;
                }
            }
        }

        show(password);

    }

    //This function will be responsible for assembling a password that contains
    //lowercase letters, and symbols, but no numbers. It will then call
    //another function to convert the password into a string, and
    //print out the final password.

    public void lowerSymbol(int length) {

        char letter; //for getting a letter in the password
        char symbol; //for getting a symbol in the password.
        int minimumChoiceNumber; //for figuring out which character to use.
        int maximumChoiceNumber; //for figuring out which character to use.
        int choiceNumber; //number between maximum and minimum
        int firstVal; //location in array for guarenteed letter
        int secondVal; //location in array for guarenteed symbol
        int i; //for looping

        i = 0;
        firstVal = 0;
        secondVal = 0;

        Assembly make = new Assembly();
        char [] password = new char [length]; //will be converted to string.
        Random intIndex = new Random(); //random number to call 

        //gaurenteeing a letter, and symbol are used at least once each:
        letter = make.lowercase();
        symbol = make.symbol();

        while(firstVal == secondVal) {
            choiceNumber = intIndex.nextInt(0 + length);
            firstVal = choiceNumber;
            choiceNumber = intIndex.nextInt(0 + length);
            secondVal = choiceNumber;
        }
        
        password[firstVal] = letter;
        password[secondVal] = symbol;

        minimumChoiceNumber = 0; 
        maximumChoiceNumber = 2; 

        while(i < length) {

            if(password[i] != '\u0000') { //if the position in the password is full.
                i = i + 1;
            }

            else { //if the position in the password is not full.

                choiceNumber = intIndex.nextInt(minimumChoiceNumber + maximumChoiceNumber);

                if(choiceNumber == 0) {
                    letter = make.lowercase();
                    password[i] = letter;
                    i = i + 1;
                }

                if(choiceNumber == 1) {
                    symbol = make.symbol();
                    password[i] = symbol;
                    i = i + 1;
                }
            }
        }

        show(password);

    }

    //This function will be responsible for assembling a password that
    //contains only lowercase letters, and nothing else. It will
    //then call another function to convert the password into
    //a string, and then print out the final password.

    public void lower(int length) {

        char letter; //for getting a letter in the password
        int i;

        i = 0;
        Assembly make = new Assembly();
        char [] password = new char [length]; //will be converted to string.

        while(i < length) {

            if(password[i] != '\u0000') { //if the position in the password is full.
                i = i + 1;
            }

            else { //if the position in the password is not full.
                
                letter = make.lowercase();
                password[i] = letter;
                i = i + 1;

            }
        }

        show(password);

    }

    //This function will be responsible for converting the password
    //into a string, and then printing the string out.

    public void show(char[] password) {
        String finalPassword;

        finalPassword = new String(password); //convert array to string.

        System.out.println(finalPassword); //the completed password
    }

}