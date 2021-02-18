package ru.job4j.bank;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

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
        Optional<User> user = Optional.empty();
        if (user.isPresent()) {
            List<Account> userAccount = users.get(user.get());
                if (!userAccount.contains(account)) {
                    userAccount.add(account);
                }
        }
    }

    /**
     * метод @findByPassport ищет пользователя по номеру паспорта
     *  осуществляет поиск пользователя по паспорту
     * @return осуществляет поиск пользователя по паспорта
     * применение stream находится ru.job4j.map.College.findByAccount
     */
    public Optional<User> findByPassport(String passport) {
        Optional<User> rsl = Optional.empty();
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                rsl = Optional.of(user);
                break;
            }
        }
        return rsl;
    }

    /**
     *
     * @return осуществляет поиск счета по реквизитам,
     * для запрашиваемого пользователя(поиск по паспорту)
     * применение stream находится ru.job4j.map.College.findBySubjectName
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<Account> rsl = Optional.empty();
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> accounts = users.get(user.get());
            for (Account a : accounts) {
                if (a.getRequisite().equals(requisite)){
                    rsl = Optional.of(a);
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
            Optional<Account> srcAccount = findByRequisite(srcPassport, srcRequisite);
            Optional<Account> destAccount = findByRequisite(destPassport, destRequisite);
            if (srcAccount.isPresent() && destAccount.isPresent()
                    && srcAccount.get().getBalance() >= amount) {
                srcAccount.get().setBalance(srcAccount.get().getBalance() - amount);
                destAccount.get().setBalance(destAccount.get().getBalance() + amount);
                rsl = true;
            }
            return rsl;
        }
}
