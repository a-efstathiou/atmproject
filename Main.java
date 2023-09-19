import java.util.InputMismatchException;
import java.util.Scanner;





public class Main {
    public static void main(String[] args) {

        Account account = new Account(); //Account constructor
        Scanner scanner = new Scanner(System.in); //Initialize the scanner
        account.initialize(); //Initializes the account
        int iteration = 1;


        do {
            try {
                if (iteration == 1) {
                    System.out.println("Hello. Please enter your PIN");
                    iteration++;
                } else {
                    System.out.println("Your PIN needs to be 4 digits");
                }
                account.setPin(scanner.nextInt());
                scanner.nextLine();
                System.out.println("Please enter the correct PIN");
            } catch (InputMismatchException e) {
                System.out.println("ERROR! Enter a 4 digit integer!!");
                scanner.nextLine();
            }
        } while(!account.checkPin() || (account.getPinLength(account.getPin()) != 4));//checks if pin is 4 numbers long and if it is 6364
                                                                                    // which is the default set pin for the account

        System.out.println("You have successfully entered your PIN. Proceed.");

        int breakValue = 0; /* When breakValue becomes 1, the program will end. While breakValue = 0 the user will get
                               the prompts with the options. */

        while (breakValue != 1) {
            //Display of options
            System.out.println("Please enter the desired action: ");
            System.out.println("1. See balance");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Exit ");
            System.out.println();
            try {
                int x = scanner.nextInt();
                scanner.nextLine();

                switch (x) {
                    case 1:
                        System.out.println("Your balance is: " + account.getBalance()); //Displays the current balance
                        System.out.println();
                        break;
                    case 2:
                        System.out.println("Input the amount you want to withdraw:");
                        double withdrawAmount = scanner.nextDouble(); //Reads the amount to withdraw
                        if (account.getBalance() - withdrawAmount > 0) { //Checks if the balance is larger than 0
                            account.setBalance(account.getBalance() - withdrawAmount); //sets the new balance after the withdrawal
                            System.out.println("Your new balance is: " + account.getBalance());
                            System.out.println();
                        } else {
                            System.out.println("The amount you try to withdraw is larger than your account balance");
                            System.out.println();
                        }
                        break;
                    case 3:
                        System.out.println("Enter the amount you want to deposit");
                        double depositAmount = scanner.nextDouble(); //reads the amount to deposit
                        account.setBalance(account.getBalance() + depositAmount);
                        System.out.println("Your new balance is " + account.getBalance());
                        System.out.println();
                        break;
                    case 4:
                        breakValue = 1; //the while loop breaks and the program ends
                        scanner.close();
                        break;
                    default:
                        System.out.println("Please enter a number from 1 to 4 \n");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid option \n");
                scanner.next();
            }

        }
    }
}
