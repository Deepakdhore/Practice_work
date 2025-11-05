import java.util.concurrent.locks.ReentrantLock;

class BankAccount {
    private double balance;
    private final ReentrantLock lock = new ReentrantLock();
    private final String name;

    public BankAccount(String name, double initialBalance) {
        this.name = name;
        this.balance = initialBalance;
    }

    public boolean withdraw(double amount) {
        lock.lock();
        try {
            if (balance >= amount) {
                balance -= amount;
                System.out.println(name + " withdrew " + amount);
                return true;
            } else {
                System.out.println(name + " failed to withdraw: Insufficient funds");
                return false;
            }
        } finally {
            lock.unlock();
        }
    }

    public void deposit(double amount) {
        lock.lock();
        try {
            balance += amount;
            System.out.println(name + " deposited " + amount);
        } finally {
            lock.unlock();
        }
    }

    public boolean transferTo(BankAccount target, double amount) {
        if (withdraw(amount)) {
            target.deposit(amount);
            System.out.println("Transferred " + amount + " from " + name + " to " + target.name);
            return true;
        }
        return false;
    }

    public double getBalance() {
        return balance;
    }
}
