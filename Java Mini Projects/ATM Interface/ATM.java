import java.util.*;
class Program {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int balance = 10000;
        int pin = 1234;

        System.out.print("Enter PIN: ");
        int enteredPin = sc.nextInt();

        if (enteredPin == pin) {
            int choice;
            do {
                System.out.println("\n1. Check Balance\n2. Deposit\n3. Withdraw\n4. Exit");
                System.out.print("Choose an option: ");
                choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        System.out.println("Balance: Rs." + balance);
                        break;

                    case 2:
                        System.out.print("Enter amount to deposit: ");
                        int dep = sc.nextInt();
                        balance += dep;
                        System.out.println("Deposited. New Balance: Rs." + balance);
                        break;

                    case 3:
                        System.out.print("Enter amount to Withdraw: ");
                        int with = sc.nextInt();
                        if (with <= balance) {
                            balance -= with;
                            System.out.println("Withdrawn. New Balance: Rs." + balance);
                        } else {
                            System.out.println("Insufficient Balance");
                        }
                        break;

                    case 4:
                        System.out.println("Thank you! Exiting...");
                        break;

                    default:
                        System.out.println("Invalid choice");

                }

            } while (choice != 4);

        } else {
            System.out.println("Incorrect PIN");
        }
    }

}



