import java.util.Random;

//This class is contains 4 different functions.
//These functions will be called by the functions
//contained in the combine class, in order to obtain
//charachters, numbers, and symbols.

public class Assembly {

    //This function is responsible for finding uppercase letters when called.
    //It will then return these values to contribute to the construction of a 
    //password. It will return a random letter, to ensure that the password it
    //generates is strong.

    public char uppercase() {
        int minimumUpper; //minimum value for randomly finding an index
        int maximumUpper; //maximum value for randomly finding an index
        int upperIndex; //The index that is randomly found. Will be assigned a value once it is found.

        minimumUpper = 0; //lowest index in array.
        maximumUpper = 25; //Highest index in array.

        Random intIndex = new Random();

        upperIndex = intIndex.nextInt(minimumUpper + maximumUpper); //generating the index number.

        char [] letters = new char [26];
        letters[0] = 'A';
        letters[1] = 'B';
        letters[2] = 'C';
        letters[3] = 'D';
        letters[4] = 'E';
        letters[5] = 'F';
        letters[6] = 'G';
        letters[7] = 'H';
        letters[8] = 'I';
        letters[9] = 'J';
        letters[10] = 'K';
        letters[11] = 'L';
        letters[12] = 'M';
        letters[13] = 'N';
        letters[14] = 'O';
        letters[15] = 'P';
        letters[16] = 'Q';
        letters[17] = 'R';
        letters[18] = 'S';
        letters[19] = 'T';
        letters[20] = 'U';
        letters[21] = 'V';
        letters[22] = 'W';
        letters[23] = 'X';
        letters[24] = 'Y';
        letters[25] = 'Z'; 

        return letters[upperIndex];
    }

    //This function will be responsible for returning a
    //charachter each time it is called in order to assemble
    //a password. It will do so randomly, to ensure that a random
    //charachter is sent back each time. It is for lower case letters only.

    public char lowercase() {
        int minimumLower; //minimum value for randomly finding an index
        int maximumLower; //maximum value for randomly finding an index
        int lowerIndex; //The index that is randomly found. Will be assigned a value once it is found.

        minimumLower = 0; //lowest index in array.
        maximumLower = 25; //Highest index in array.

        Random intIndex = new Random();

        lowerIndex = intIndex.nextInt(minimumLower + maximumLower); //generating the index number.

        char [] letters = new char [26];
        letters[0] = 'a';
        letters[1] = 'b';
        letters[2] = 'c';
        letters[3] = 'd';
        letters[4] = 'e';
        letters[5] = 'f';
        letters[6] = 'g';
        letters[7] = 'h';
        letters[8] = 'i';
        letters[9] = 'j';
        letters[10] = 'k';
        letters[11] = 'l';
        letters[12] = 'm';
        letters[13] = 'n';
        letters[14] = 'o';
        letters[15] = 'p';
        letters[16] = 'q';
        letters[17] = 'r';
        letters[18] = 's';
        letters[19] = 't';
        letters[20] = 'u';
        letters[21] = 'v';
        letters[22] = 'w';
        letters[23] = 'x';
        letters[24] = 'y';
        letters[25] = 'z'; 

        return letters[lowerIndex]; //returning the random letter.
    }

    //This function will be responsible for returning a number
    //each time it is called. It will do so randomly to ensure that
    //a random number is sent each time. This will allow the password
    //to be more secure.

    public char number() {
        int minimumNumber; //minimum value for randomly finding an index
        int maximumNumber; //maximum value for randomly finding an index
        int numIndex; //The index that is randomly found. Will be assigned a value once it is found.

        minimumNumber = 0; //lowest index in array.
        maximumNumber = 9; //highest index in array.

        Random intIndex = new Random();

        numIndex = intIndex.nextInt(minimumNumber + maximumNumber); //generating the index number.

        //The array of numbers 0 through 9 is created here.
        //It will be used to randomly obtain a number for use in the password.

        char [] numbers = new char [10];
        numbers[0] = '0';
        numbers[1] = '1';
        numbers[2] = '2';
        numbers[3] = '3';
        numbers[4] = '4';
        numbers[5] = '5';
        numbers[6] = '6';
        numbers[7] = '7';
        numbers[8] = '8';
        numbers[9] = '9';

        return numbers[numIndex]; //returning the random number.
    }

    //This function will help to send back special charachters
    //such as "@", and "$" when it is called. It will do so randomly
    //in order to ensure that the password is more secure.

    public char symbol() {
        int minimum; //minimum value for randomly finding an index
        int maximum; //maximum value for randomly finding an index
        int index; //The index that is randomly found. Will be assigned a value once it is found.

        minimum = 0; //lowest index in array.
        maximum = 10; //highest index in array.

        Random charIndex = new Random();

        index = charIndex.nextInt(minimum + maximum); //generating the index number.

        //The array of 11 different symbols is created here, and
        //it is assigned a different symbol for each spot.

        char [] symbols = new char [11];
        symbols[0] = '!';
        symbols[1] = '@';
        symbols[2] = '#';
        symbols[3] = '$';
        symbols[4] = '%';
        symbols[5] = '^';
        symbols[6] = '&';
        symbols[7] = '*';
        symbols[8] = '+';
        symbols[9] = '=';
        symbols[10] = '?';

        return symbols[index]; //returning the random symbol.
    }
}
