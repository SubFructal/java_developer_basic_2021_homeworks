package ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture11_homework;

public class Account {

    private final int id;
    private final long balance;
    private String comment;

    public Account(int id, long balance, String comment) {
        this.id = id;
        this.balance = balance;
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (id != account.id) return false;
        if (balance != account.balance) return false;
        return comment.equals(account.comment);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (int) (balance ^ (balance >>> 32));
        result = 31 * result + comment.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", balance=" + balance +
                ", comment='" + comment + '\'' +
                '}';
    }
}
