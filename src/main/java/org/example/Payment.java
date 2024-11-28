package org.example;

import java.util.Objects;

public class Payment {
    //Поля
    private String fullName;
    private int day;
    private int month;
    private int year;
    private int amountInKopecks;
    //Конструктор
    public  Payment() {}
    //Конструктор с пар
    public Payment(String fullName, int day, int month, int year, int amountInKopecks) {
        this.fullName = fullName;
        this.day = day;
        this.month = month;
        this.year = year;
        this.amountInKopecks = amountInKopecks;
    }
    //Копируем
    public Payment(Payment that) {
        this.fullName = that.fullName;
        this.day = that.day;
        this.month = that.month;
        this.year = that.year;
        this.amountInKopecks = that.amountInKopecks;
    }
    //Гетеры
    public String getFullName() {
        return fullName;
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
    public int getAmountInKopecks() {
        return amountInKopecks;
    }

    //Сетер
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public void setDay(int day) {
        this.day = day;
    }
    public void setMonth(int month) {
        this.month = month;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public void setAmountInKopecks(int amountInKopecks) {
        this.amountInKopecks = amountInKopecks;
    }
    //Сравнение
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Payment payment = (Payment) obj;
        return day == payment.day &&
                month == payment.month &&
                year == payment.year &&
                amountInKopecks == payment.amountInKopecks &&
                Objects.equals(fullName, payment.fullName);
    }
    //Наш любимый хешкод
    @Override
    public int hashCode() {
        return Objects.hash(fullName, day, month, year, amountInKopecks);
    }
    //Преобразует в строку
    @Override
    public String toString() {
        return "Payment(" +
                "fullName= " + fullName  +
                ", date=" + day + "." + month + "." + year +
                ", amount=" + amountInKopecks + " kopecks" +
                ")";
    }
}
