public class Account implements ITransaction {
  protected String accName;
  protected int phoneNumber;
  protected Double balance = 0.0;
  protected String password;

  public void setName(String accName) {
    this.accName = accName;
  }

  public void setPhoneNumber(int phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public int getPhoneNumber() {
    return phoneNumber;
  }

  public String getPassword() {
    return password;
  }

  public String getName() {
    return accName;
  }

  public Double getBalance() {
    return balance;
  }

  public void cashIn(double amount) {
    if (amount >= 0) {
      balance += amount;
      System.out.println("-----------------------");
      System.out.println("Deposit amount:" + amount);
      System.out.println("Balance:" + balance);
      System.out.println("-----------------------");
    }
  }

  public void cashOut(double withDamount) {}

  public void show() {
    System.out.println("-----------------------");
    System.out.println("Name:" + accName);
    System.out.println("Phone number:" + phoneNumber);
    System.out.println("Balance:" + balance);
    System.out.println("-----------------------");
  }

  public void send(Account a, double amount) {
    if (amount > 0 && amount <= balance) {
      System.out.println("-----------------------");
      System.out.println("\nPrevious Balance:    " + this.balance);
      System.out.println("Transfer Amount: " + amount);

      this.balance = this.balance - amount;
      a.balance = a.balance + amount;

      System.out.println("Current Balance: " + this.balance);
      System.out.println("-----------------------");
    } else {
      System.out.println("Can Not Transfer,Invalid Or Insufficient Amount...");
    }
  }
}
