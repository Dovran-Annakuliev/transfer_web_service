package ru.sberstart.transfer.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class Card extends DomainModel{
    private Long userIdl;
    private Long cardNumber;
    @NotEmpty(message = "Balance should not be empty")
    @Min(value = 0, message = "Balance cannot be negative")
    private Float balance = 0.f;

    public Long getUserIdl() {
        return userIdl;
    }

    public void setUserIdl(Long userIdl) {
        this.userIdl = userIdl;
    }

    public Long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Card{" +
                "userIdl=" + userIdl +
                ", cardNumber='" + cardNumber + '\'' +
                ", balance=" + balance +
                '}';
    }
}
