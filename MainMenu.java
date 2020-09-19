import java.util.Scanner;

public class MainMenu {

  public static void main(String[] args) {
    Scanner sin = new Scanner(System.in);
    Scanner sc = new Scanner(System.in);
    int exit, c1; //exit,c1,c2 .. for switch case value
    int acc = 0; //to count how many accounts are created

    Account[] a = new transactionAccount[10];
    do {
      System.out.println("***** Main Menu *****");
      System.out.println("-------------------------------");
      System.out.println("1.Add new account");
      System.out.println("2.Cash In");
      System.out.println("3.Cash Out");
      System.out.println("4.Send Money");
      System.out.println("5.Show Account Details.");
      System.out.println("6.Exit");
      System.out.println("Please Enter Number to Select:");
      System.out.println("-------------------------------");
      exit = sin.nextInt();

      switch (exit) {
        case 1:
          do {
            System.out.println("Please select an option:");
            System.out.println("-----------------------");
            System.out.println("1.Add transaction account");
            System.out.println("2.Back");
            System.out.println("-----------------------");

            c1 = sin.nextInt();

            switch (c1) {
              case 1:
                System.out.println(
                  "Please Create 2 or more account (limit is set to 10 accounts highest) to see how this system works"
                );
                System.out.println(
                  "Enter how many accounts you want to create:"
                );
                int ca = sin.nextInt();

                for (int i = 0; i < ca; i++) {
                  a[i] = new transactionAccount();

                  System.out.println("Enter Name for account no[" + i + "]:");
                  String name = sc.next();
                  a[i].setName(name);

                  boolean continueLoop = true;
                  do {
                    try {
                      System.out.println(
                        "Enter phone number for account no[" + i + "]: "
                      );
                      int phoneNumber = sin.nextInt();
                      a[i].setPhoneNumber(phoneNumber);
                      continueLoop = false;
                    } catch (Exception e) {
                      System.err.printf("\nException: %s\n", e);
                      sin.nextLine();
                      System.out.println(
                        "You must enter Numbers(integer). Please try again"
                      );
                    }
                  } while (continueLoop);

                  System.out.println(
                    "Enter password for account no[" + i + "] :"
                  );
                  String password = sin.next();
                  a[i].setPassword(password);
                  acc++;
                }

                break;
            }
          } while (c1 != 2);
          break;
        
        case 2:
          int pb = 0;

          boolean continueLoop1 = true;
          do {
            try {
              System.out.println("Enter phone number : ");
              int phoneNumber = sin.nextInt();
              pb = phoneNumber;
              continueLoop1 = false;
            } catch (Exception e) {
              System.err.printf("\nException: %s\n", e);
              sin.nextLine();
              System.out.println(
                "You must enter Numbers(integer). Please try again"
              );
            }
          } while (continueLoop1);

          for (int i = 0; i < acc; i++) {
            int apn = a[i].getPhoneNumber();
            if (apn == pb) {
              System.out.println("Enter money amount you want to cash in:");
              double amount = sin.nextDouble();
              System.out.println("Enter you password:");
              String p = sc.next();
              String ap = a[i].getPassword();
              if (ap.equals(p)) {
                a[i].cashIn(amount);
              } else {
                System.out.println("Wrong password");
              }
            } else {}
          }
          break;
        
        case 3:
          int pc = 0;

          boolean continueLoop2 = true;
          do {
            try {
              System.out.println("Enter phone number : ");
              int phoneNumber = sin.nextInt();
              pc = phoneNumber;
              continueLoop2 = false;
            } catch (Exception e) {
              System.err.printf("\nException: %s\n", e);
              sin.nextLine();
              System.out.println(
                "You must enter Numbers(integer). Please try again"
              );
            }
          } while (continueLoop2);

          for (int i = 0; i < acc; i++) {
            int apn = a[i].getPhoneNumber();
            if (apn == pc) {
              System.out.println("Enter money amount you want to cash out:");
              double amount = sin.nextDouble();
              System.out.println("Enter you password:");
              String p = sc.next();
              String ap = a[i].getPassword();
              if (ap.equals(p)) {
                a[i].cashOut(amount);
              } else {
                System.out.println("Wrong password");
              }
            } else {}
          }
          break;
        
        case 4:
          int pd = 0;
          int pe = 0;
          Account n1 = null;

          boolean continueLoop3 = true;
          do {
            try {
              System.out.println(
                "Enter phone number of account you want to transfer from: "
              );
              int phoneNumber = sin.nextInt();
              pd = phoneNumber;
              continueLoop3 = false;
            } catch (Exception e) {
              System.err.printf("\nException: %s\n", e);
              sin.nextLine();
              System.out.println(
                "You must enter Numbers(integer). Please try again"
              );
            }
          } while (continueLoop3);

          for (int i = 0; i < acc; i++) {
            int apn = a[i].getPhoneNumber();

            if (apn == pd) {
              System.out.println(
                "Enter phone number of account you want to transfer to:"
              );
              pe = sin.nextInt();
              System.out.println("Enter amount:");
              Double tAmount = sin.nextDouble();
              System.out.println("Enter Password:");
              String p = sc.next();
              String ap = a[i].getPassword();
              if (ap.equals(p)) {
                for (int j = 0; j < acc; j++) {
                  int apn1 = a[j].getPhoneNumber();
                  if (apn1 == pe) {
                    a[i].send(a[j], tAmount);
                  }
                }
              } else {
                System.out.println("Wrong password");
              }
            } else {}
          }
          break;
        
        case 5:
          int pn = 0;

          boolean continueLoop5 = true;
          do {
            try {
              System.out.println("Enter phone number to show details: ");
              int phoneNumber = sin.nextInt();
              pn = phoneNumber;
              continueLoop5 = false;
            } catch (Exception e) {
              System.err.printf("\nException: %s\n", e);
              sin.nextLine();
              System.out.println(
                "You must enter Numbers(integer). Please try again"
              );
            }
          } while (continueLoop5);

          for (int i = 0; i < acc; i++) {
            int apn = a[i].getPhoneNumber();
            if (apn == pn) {
              System.out.println("Enter you password:");
              String p = sc.next();
              String ap = a[i].getPassword();
              if (ap.equals(p)) {
                a[i].show();
              } else {
                System.out.println("Wrong password");
              }
            } else {}
          }
          break;
        case 6:
          System.out.println("<<<Exited>>>");
          break;
      }
    } while (exit != 6);
  }
}
