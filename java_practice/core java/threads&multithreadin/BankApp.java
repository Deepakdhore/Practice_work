public class BankApp {
    public static void main(String[] args) throws InterruptedException {
        BankAccount acc1 = new BankAccount("Alice", 1000);
        BankAccount acc2 = new BankAccount("Bob", 1000);

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1; i++) {
                acc1.transferTo(acc2, 100);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1; i++) {
                acc2.transferTo(acc1, 50);
            }
        });

        t1.start();
        t2.start();
       //t1.join();
       t2.join();

        System.out.println("Final balance - Alice: " + acc1.getBalance());
        System.out.println("Final balance - Bob: " + acc2.getBalance());
    }
}
