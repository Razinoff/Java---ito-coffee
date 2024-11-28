package org.example;
import java.util.Arrays;

public class FinanceReport {
    //Поля
    private Payment[] payments;
    private String authorFullName;
    private int day;
    private int month;
    private int year;
    //Копирование
    public FinanceReport(FinanceReport that) {
        this.authorFullName = that.authorFullName;
        this.day = that.day;
        this.month = that.month;
        this.year = that.year;

        this.payments = new Payment[that.payments.length];
        for (int i = 0; i < that.payments.length; i++) {
            this.payments[i] = new Payment(that.payments[i]);
        }
    }
    //Конструктор
    public FinanceReport(String authorFullName, int day, int month, int year, Payment[] payments) {
        this.authorFullName = authorFullName;
        this.day = day;
        this.month = month;
        this.year = year;

        this.payments = new Payment[payments.length];
        for (int i = 0; i < payments.length; i++) {
            this.payments[i] = new Payment(payments[i]); // Создаем копии платежей
        }
    }
    //Гетеры
    public String getAuthorFullName() {
        return authorFullName;
    }
    public int getDay() {
        return day;
    }
    public int getMonth() {
        return month;
    }
    public int getYear() {
        return year;
    }
    //Количество платежников
    public int getCountOfPayments() {
        return payments.length;
    }
    //Конкретный платеж платежника
    public Payment getPayment(int index) {
        if (index >= 0 && index < payments.length) {
            return payments[index];
        } else {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
    }

    //Копию массива всех платежей
    public Payment[] getPayments() {
        return Arrays.copyOf(payments, payments.length);
    }
    //Устанавливает новый платеж в массив
    public void setPayment(int index, Payment payment) {
        if (index >= 0 && index < payments.length) {
            payments[index] = payment;
        } else {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
    }
    //Преобразует в строку
    @Override
    public String toString() {
        StringBuilder report = new StringBuilder();

        report.append(String.format("[Автор: %s, дата: %02d.%02d.%d [ Платежи: \n", authorFullName, day, month, year));

        for (int i = 0; i <  payments.length; i++) {
            int rub = payments[i].getAmountInKopecks() / 100;
            int kopecks = payments[i].getAmountInKopecks() % 100;
            if (i == payments.length - 1){
                report.append(String.format(" Плательщик: %s, дата: %02d.%02d.%d, сумма: %d руб. %02d коп.",
                        payments[i].getFullName(), payments[i].getDay(), payments[i].getMonth(), payments[i].getYear(), rub, kopecks));
                break;
            }
            report.append(String.format(" Плательщик: %s, дата: %02d.%02d.%d, сумма: %d руб. %02d коп.\n",
                    payments[i].getFullName(), payments[i].getDay(), payments[i].getMonth(), payments[i].getYear(), rub, kopecks));
        }
        report.append("]]");


        return report.toString();
    }
}
