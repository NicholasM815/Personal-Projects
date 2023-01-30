//Author: Nicholas Milonni

//This program is a Caesar Cipher. It can encrypt a message,
//as well as decrypt a message based on a key that the user
//inputs.

#include <iostream>
#include <string>
#include <cstdlib>

using namespace std;

string decrypt() {
    string message; //The message given by the user.
    string alphabet; //The sequence of letters you to decrypt a message.
    int key; //User entered key for decrypting the message.
    int i; //Used for iteration and finding spaces.
    int j; //Used for iteration and finding spcaes/non-capital letters.
    int upper; //Assigned a value based on a charachter being uppercase or not.
    int messageLength; //Length of the message entered by the user.
    int startingPoint; //Added to the key to find out how characters change.
    int finalPoint; //Used to find the letter in the alphabet to change to.
    
    cout << "Please enter the message you want to decrypt(letters A-Z and uppercase only): ";
    cin.ignore();
    getline(cin, message);
    
    j = 0;
    
    messageLength = message.length();
    
    while(j < messageLength) {
        
        
        //If there is a space in the message,
        //Make sure it is included, and move over it.
        if(isspace(message[j]) != 0) {
            j = j + 1;
        }
        
        upper = isupper(message[j]);
        
        //If a charachter is not uppercase, then
        //give an error message, stop the program,
        //and ask the user to start the program again.
        
        if(upper == 0) {
            cout << "Invalid input. Please start the program Again." << endl;
            exit(0);
        }
        
        else {
            j = j + 1;
        }
        
    }
    
    //Getting user input for the key:
    
    cout << "Please enter the key you would like to use!" << endl;
    cout << "(Enter a number to decrypt, or enter anything else for no changes): ";
    cin >> key;
    
    key = 26 - key;
    key = abs(key);
    
    //Selection of availible letters:
    
    alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    
    i = 0;
    
    //Loop chekcs each character to see if it is
    //a space. If it is not a space, the characters
    //positon in the alphabet is found, and set to be
    //the starting point. a modulo operation is then
    //conducted to fiugre out how many letters must be
    //passed to change the current letter to the desired letter.
    
    while(i < messageLength) {
        
        if(isspace(message[i]) != 0) {
            i = i + 1;
        }
        
        else {
            startingPoint = alphabet.find(message[i]);
            finalPoint = (startingPoint + key) % 26;
            finalPoint = abs(finalPoint);
            cout << "Start: " << startingPoint << endl;
            cout << "Key: " << key << endl;
            cout << "Calculation: " << finalPoint << endl;
            message[i] = alphabet[finalPoint];
            i = i + 1;
        }
    }
    //Return decrypted message:
    return message;
    
}

//This function will be responsible for
//encrypting a message that the user chooses to enter,
//based on the key that the user decides to use.
//Only capital letters, and spaces are allowed.
//Special characters are also not allowed.

string encrypt() {
    
    string message; //The message given by the user.
    string alphabet; //The sequence of letters you to encrypt a message.
    int key; //User entered key for encrypting the message.
    int i; //Used for iteration and finding spaces.
    int j; //Used for iteration and finding spcaes/non-capital letters.
    int upper; //Assigned a value based on a charachter being uppercase or not.
    int messageLength; //Length of the message entered by the user.
    int startingPoint; //Added to the key to find out how characters change.
    
    cout << "Please enter the message you want to encrypt(letters A-Z and uppercase only): ";
    cin.ignore();
    getline(cin, message);
    
    j = 0;
    
    messageLength = message.length();
    
    while(j < messageLength) {
        
        
        //If there is a space in the message,
        //Make sure it is included, and move over it.
        if(isspace(message[j]) != 0) {
            j = j + 1;
        }
        
        upper = isupper(message[j]);
        
        //If a charachter is not uppercase, then
        //give an error message, stop the program,
        //and ask the user to start the program again.
        
        if(upper == 0) {
            cout << "Invalid input. Please start the program Again." << endl;
            exit(0);
        }
        
        else {
            j = j + 1;
        }
        
    }
    
    //Getting user input for the key:
    
    cout << "Please enter the key you would like to use!" << endl;
    cout << "(Enter a number to encrypt, or enter anything else for no changes): ";
    cin >> key;
    
    //Selection of availible letters:
    
    alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    
    i = 0;
    
    //Loop chekcs each character to see if it is
    //a space. If it is not a space, the characters
    //positon in the alphabet is found, and set to be
    //the starting point. a modulo operation is then
    //conducted to fiugre out how many letters must be
    //passed to change the current letter to the desied letter.
    
    while(i < messageLength) {
        
        if(isspace(message[i]) != 0) {
            i = i + 1;
        }
        
        else {
            startingPoint = alphabet.find(message[i]);
            message[i] = alphabet[(startingPoint + key) % 26];
            i = i + 1;
        }
    }
    //Return encrypted message:
    return message;
    
}

//The main function welcomes the user and asks
//if they would like to encrypt a message.
//The user can enter 'YES' if yes, or anything
//else if the answer is no. If the answer is
//yes, then the encrypt function is called.
//If anything else is selected, then the user
//is asked if they would like to decrypt a message.
//if the answer is 'YES', the decrypt function is
//called. If the answer is anything else, then the
//program ends.

int main(void) {

    int numResult; //used for determining if the answer was yes.
    int numResultTwo; //used for determining if the answer was yes.
    string answer; //user input to determine if the want to encrypt/decrypt.
    string answerTwo; //user input to determine if the want to encrypt/decrypt.
    string cmpAnswer; //value compares to user input.
    string cmpAnswerTwo; //value compares to user input.
    string message; //The encrypted/decrypted message.
    
    //Introduction, and user input:
    
    cout << "Welcome to the Caesar Cipher!" << endl;
    cout << "Do you want to encrypt a message?" << endl;
    cout << "(Enter YES if yes, or enter anything else if no): ";
    
    cin >> answer;
    
    cmpAnswer = "YES";
    
    numResult = cmpAnswer.compare(answer);
    
    if (numResult == 0) {
        message = encrypt();
        cout << "Final Message: " << message;
    }
    
    else {
        cout << "Do you want to decrypt a message?" << endl;
        cout << "(Enter YES if yes, or enter anything else if no): ";
        cin >> answerTwo;
    
        cmpAnswerTwo = "YES";
        numResultTwo = cmpAnswerTwo.compare(answerTwo);
        
        if (numResultTwo == 0) {
            message = decrypt();
            cout << "Final Message: " << message;
        }
        
    }

}

