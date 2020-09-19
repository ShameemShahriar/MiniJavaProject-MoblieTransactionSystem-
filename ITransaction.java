interface ITransaction{
    public void cashIn(double amount);
    public void cashOut(double amount);
    public void send(Account a, double amount);
    public void show();
    }