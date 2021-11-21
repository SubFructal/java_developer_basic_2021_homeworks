package ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture11_homework;

import java.util.*;

/*
У нас есть банк, в котором хранятся золотые монеты.
У банка есть клиенты, у которых есть имя и нам как банку важно знать их возраст для ограничений на операции.
У одного клиента может быть несколько счетов, на которых хранятся золотые монеты.
Нужно реализовать следующую функциональность :
- Найти все счета по клиенту (например List<Account> getAccounts(Client client) )
- Найти клиента по счету (например Client findClient(Account account) )
Поиск должен работать максимально быстро(!!!) с использованием стандартных коллекций Java.
В классах Client и Account должно быть минимальное кол-во полей, достаточное для этой задачи.
*/

public class SberBank implements Bank {

    private final Map<Account, Client> accountClients = new HashMap<>();

    public static void main(String[] args) {

        Client clientIvan = new Client(1, 33, "Ivan");
        Client clientMaria = new Client(2, 28, "Maria");
        Client clientPetr = new Client(3, 28, "Petr");

        Account accountIvan1 = new Account(1, 100, "accountIvan1");
        Account accountIvan2 = new Account(2, 200, "accountIvan2");

        Account accountMaria = new Account(3, 300, "accountMaria");
        Account accountPetr = new Account(4, 700, "accountPetr");

        SberBank sberBank = new SberBank();

        sberBank.addNewEntry(accountIvan1, clientIvan);
        sberBank.addNewEntry(accountIvan2, clientIvan);
        sberBank.addNewEntry(accountMaria, clientMaria);
        sberBank.addNewEntry(accountPetr, clientPetr);

        System.out.println(sberBank.getClient(new Account(1, 100, "accountIvan1")));
        System.out.println(sberBank.getClient(new Account(2, 200, "accountIvan2")));
        System.out.println(sberBank.getClient(new Account(3, 300, "accountMaria")));
        System.out.println(sberBank.getClient(new Account(4, 700, "accountPetr")));

        System.out.println(sberBank.getAccounts(new Client(1, 33, "Ivan")));

    }

    @Override
    public void addNewEntry(Account account, Client client) {
        this.accountClients.put(account, client);
    }

    @Override
    public List<Account> getAccounts(Client client) {
        List<Account> accounts = new ArrayList<>();

        for (Map.Entry<Account, Client> pairs : accountClients.entrySet()) {
            if (pairs.getValue().equals(client)) {
                accounts.add(pairs.getKey());
            }
        }

        return accounts;
    }

    @Override
    public Client getClient(Account account) {
        return this.accountClients.get(account);
    }

}