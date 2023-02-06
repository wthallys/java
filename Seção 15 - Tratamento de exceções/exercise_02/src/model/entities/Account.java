package model.entities;

import model.exceptions.BusinessException;

public class Account {
    private Integer number;
    private String holder;
    private Double balance;
    private Double withdrawLimit;

    public Account(Integer number, String holder, Double balance, Double withdrawLimit){
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public Double getBalance() {
        return balance;
    }

    public void withdraw(double amount) {
        validateWithdraw(amount);
        balance -= amount;
    }

    private void validateWithdraw(double amount) {
        if (amount > balance) {
            throw new BusinessException("Insufficient funds");
        }
        if (amount > withdrawLimit) {
            throw new BusinessException("The amounts exceeds withdraw limit");
        }
    }
}
