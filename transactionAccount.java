public class transactionAccount extends Account{
    public void cashOut(double amount){
          if(super.balance-amount>=100 && amount<super.balance){
              super.balance-=amount;
              System.out.println("-----------------------");
              System.out.println("cash out amount:"+amount);
              System.out.println("Remaining balance:"+super.balance);
              System.out.println("-----------------------");
  
          }
          else{
              System.out.println("invalid amount or your balance is lower than 100");
          }
          
      }
} 