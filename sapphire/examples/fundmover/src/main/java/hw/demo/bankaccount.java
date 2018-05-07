package hw.demo;

import java.io.Serializable;

public class bankaccount implements Serializable{
    private int balance;

    public void credit(int amount) {
        this.balance += amount;
    }

    public void debit(int amount) {
        this.balance -= amount;
    }

    public int getBalance() {
        return this.balance;
    }
}