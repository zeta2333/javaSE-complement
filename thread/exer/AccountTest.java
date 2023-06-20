package usts.pycro.thread.exer;

/**
 * @author Pycro
 * @version 1.0
 * 2023-06-20 5:54 PM
 */
public class AccountTest {
    public static void main(String[] args) {
        Account account = new Account(0);
        Customer customer1 = new Customer(account, "A");
        Customer customer2 = new Customer(account, "B");
        customer1.start();
        customer2.start();
    }
}

class Account {
    double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public synchronized void deposit(double amount) {
        // 存完之后睡觉，睡完觉再打印
        if (amount > 0) {
            balance += amount;
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + "存钱成功，余额为：" + balance);
    }

}

class Customer extends Thread {
    Account account;

    public Customer(Account account, String name) {
        super(name);
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            account.deposit(1000);
        }
    }
}