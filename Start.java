//This class only contains one function, which
//is of course the main function. This is where
//the password generator will start. The main method will
//call the response function in the password class, in order 
//to obtain user input for what kind of class to make.

public class Start {
    public static void main(String[] args) throws Exception {
        Password pass = new Password();
        pass.response();
    }
}