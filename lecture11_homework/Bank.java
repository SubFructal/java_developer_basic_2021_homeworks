package ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture11_homework;

import java.util.List;

public interface Bank {

    void addNewEntry(Account account, Client client);

    List<Account> getAccounts(Client client);

    Client getClient(Account account);

}