
void main() {

    BankService bank = new BankService();

   User User1 = new User("Aaron");
   User User2 = new User("LLuvia");

   Account Account1 = new Account(User1);
   Account Account2 = new Account(User2);

   Account1.credit(100.00f);

   bank.saveAccount(Account1);
   bank.saveAccount(Account2);

   Transaction receipt = bank.executeTransfer(Account1.getAccountId(), Account2.getAccountId(), 50.00f);

    System.out.println(User1.getUsername() + "'s Balance is: " + Account1.getAccountBalance());
    System.out.println(User2.getUsername() + "'s Balance is: " + Account2.getAccountBalance());
    System.out.println(receipt);
    System.out.println(receipt);
    System.out.println("we made it");

}
