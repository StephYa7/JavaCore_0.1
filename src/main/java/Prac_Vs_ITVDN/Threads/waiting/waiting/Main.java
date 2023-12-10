package Prac_Vs_ITVDN.Threads.waiting.waiting;

public class Main {
    public static void main(String[] args) {
        Product p = new Product();
        Producer pr = new Producer(p, 5);
        Consumer cons = new Consumer(p, 5);
        pr.start();
        cons.start();
    }
}

class Product {
    int id;

    synchronized void getIdProduct() {
        System.out.println("Get " + this.id);
    }

    synchronized void setIdProduct(int id) {
        this.id = id;
        System.out.println("Set " + this.id);
    }
}

class Producer extends Thread {
    Product p;
    int count;

    Producer(Product p, int count) {
        this.p = p;
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 1; i < count + 1; i++) {
            p.setIdProduct(i);
        }
    }
}

class Consumer extends Thread {
    Product p;
    int count;

    Consumer(Product p, int count) {
        this.p = p;
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 1; i < count + 1; i++) {
            p.getIdProduct();
        }
    }
}