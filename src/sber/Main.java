package sber;
import java.util.*;

//Программа изменения остатков на карте
public class Main {
    public static void main(String[] args) {
        Account account1122 = new Account(1122, 1000, "Герман");
        Account.setAnnualInterestRate(5.5D);

        /** Проведение операций по счету*/
        account1122.deposit(300);
        account1122.deposit(400);
        account1122.deposit(500);

        account1122.withdraw(500);
        account1122.withdraw(400);
        account1122.withdraw(200);

        /** Ввыдот сводки аккаунта*/
        System.out.print(account1122);

        ArrayList<Transaction> transactions = account1122.getTransactions();

        System.out.println("\n\t\t\tДата\t\t\tТип транзакции\t\t\tСумма, руб.\tБаланс, руб. ");

        for (Transaction transaction: transactions) {
            System.out.format("%28s%8c%24.2f%12.2f%n", transaction.getDate(), transaction.getType(),
                    transaction.getAmount(), transaction.getBalance());
        }
    }
}
