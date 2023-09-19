import java.util.Scanner;

public class Account {

    double balance;
    int pin;

    Scanner scanner = new Scanner(System.in); //Initialize the scanner

    void initialize(){
        setBalance(10000); //Starting balance set to 10000 credits.
        setPin(1000); //Starting pin that will get changed
    }

    public int getPin(){
        return pin;
    }
    public void setPin(int pin){
        this.pin=pin;
    }

    public int getPinLength(int pin){
        String pinString = Integer.toString(pin); //converts the pin to a String
        return pinString.length(); //returns the length of the PIN
    }

    public boolean checkPin(){
        return getPin() == 6364;
    }

    public double getBalance(){  //Returns the value of balance.
        return balance;
    }

    public void setBalance(double balance){ //Sets the value of balance.
        this.balance = balance;
    }




}




