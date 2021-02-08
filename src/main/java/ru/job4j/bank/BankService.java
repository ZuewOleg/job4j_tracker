package ru.job4j.bank;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

/**
 * Класс описывает работу сервиса банка: срегистрация пользователя, регистрация счета,
 * перевод денежных средств и т.д.
 */
public class BankService {
    /**
     * поле содержит всех пользователей системы с привязанными к ним счетами
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * @param user пользователь, который добавляется в систему
     * метод проверяет, что такого пользователя еще нет в системе, если его нет то,
     * добавить пользователя в систему, если он есть, то нового добавлять не надо
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * метод @addAcount добавляет новый счет к пользователю
     * @param passport осуществляет поиск пользователя по паспорту
     * @param account осуществляет поиск счета пользователя, если его нет, то добавляет к нему новый
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> userAccount = users.get(user);
                if (!userAccount.contains(account)) {
                    userAccount.add(account);
                }
        }
    }

    /**
     * метод @findByPassport ищет пользователя по номеру паспорта
     *  осуществляет поиск пользователя по паспорту
     * @return осуществляет поиск пользователя по паспорта
     */
    public User findByPassport(String passport) {
        User rsl = null;
        for (User key : users.keySet()) {
            if (key.getPassport().equals(passport)) {
                rsl = key;
                break;
            }
        }
        return rsl;
    }

    /**
     *
     * @return осуществляет поиск счета по реквизитам,
     * для запрашиваемого пользователя(поиск по паспорту)
     */
    public Account findByRequisite(String passport, String requisite) {
        Account rsl = null;
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account a : accounts) {
                if (a.getRequisite().equals(requisite)) {
                    rsl = a;
                    break;
                }
            }
        }
        return rsl;
    }

    /**
     * Метод для перечисления денег с одного счёта на другой счёт
     * @param srcPassport паспорт отправителя
     * @param srcRequisite реквизиты отправителя
     * @param destPassport паспорт получателя
     * @param destRequisite реквизиты получателя
     * @param amount сумма перевода
     * @return метод возвращает вероятность перевода денежных средств,
     * с условиям того, что данные счета существуют и с переводимого
     * счета хватает денежных средств для перевода
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null && srcAccount.getBalance() >= amount) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
