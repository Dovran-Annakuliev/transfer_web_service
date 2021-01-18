package ru.sberstart.transfer.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

public class History extends DomainModel{
    private Long cardId;
    private Long userId;

    @NotEmpty(message = "Sender id not be empty")
    @Min(value = 0, message = "Sender id must be greater than 0")
    private Long senderId;

    @NotEmpty(message = "Recipient id not be empty")
    @Min(value = 0, message = "Recipient id must be greater than 0")
    private Long recipientId;

    @NotEmpty(message = "Balance id not be empty")
    @Min(value = 0, message = "Becipient id must be greater than 0")
    private float balance;

    private Date date;


    public Long getCardId() {
        return cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public Long getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(Long recipientId) {
        this.recipientId = recipientId;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "History{" +
                "cardId=" + cardId +
                ", userId=" + userId +
                ", senderId=" + senderId +
                ", recipientId=" + recipientId +
                ", balance=" + balance +
                ", date=" + date +
                '}';
    }
}
