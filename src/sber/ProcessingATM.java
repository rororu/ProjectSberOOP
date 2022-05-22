package sber;
import java.util.Scanner;

public class ProcessingATM {
    private Scanner input = new Scanner(System.in);
    private Account[] accounts = new Account[10];

    public ProcessingATM() {
        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = new Account(i, 10000, "");
        }
    }

    public void includeATM(ProcessingATM include) {
        int id;
        while (true) {
            System.out.print("Введите ID = ");
            id = input.nextInt();
            if (id < 0 || id > accounts.length) {
                System.out.println("Введите другой id: ");
                continue;
            }

            while (true) {
                int change = include.getMenu();

                if(change == 1) {
                    System.out.print("Баланс равен: " + include.accounts[id].getBalance());
                    System.out.println("\n");
                } else if (change == 2) {
                    include.withdraw(id);
                    System.out.println("\n");
                } else if (change == 3) {
                    include.deposit(id);
                    System.out.println("\n");
                } else {
                    System.out.println();
                    break;
                }
            }
        }
    }

    public int getMenu() {
        int change;
        System.out.println("Основное меню\n" + "1: проверить баланс счета\n" +
                "2: снять со счета\n" + "3: положить на счет\n" + "4: выход");
        System.out.print("Введите пункт меню: ");
        do {
            int score = 0;
            if (score != 0) {
                System.out.print("Введите число из пунктов меню !\n" +
                        "Ваш пункт меню равен: ");
            }
            change = input.nextInt();
            score ++;
        } while (change < 0 || change > 4);
        return change;
    }

    public void withdraw (int id) {
        System.out.print("Введите сумму для снятия: ");
        double num = input.nextDouble();
        if (num < 0) {
            System.out.println("Сумма отрицательная.");
        } else if (num <= accounts[id].getBalance()) {
            accounts[id].withdraw(num);
        } else {
            System.out.println("Недостаточно средств на счете.");
        }
    }

    public void deposit(int id) {
        System.out.print("Введите сумму для внесения: ");
        double num = input.nextDouble();
        if (num < 0) {
            System.out.println("Сумма отрицательная.");
        } else {
            accounts[id].deposit(num);
        }
    }
}
