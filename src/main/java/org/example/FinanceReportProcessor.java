package org.example;

public class FinanceReportProcessor {
    public static FinanceReport getPaymentsBySurnameStart(FinanceReport report, char startsWith) {
        int count = 0;
        // Считаем количество подходящих платежей
        for (Payment payment : report.getPayments()) {
            if (payment.getFullName().startsWith(String.valueOf(startsWith))) {
                count++;
            }
        }
        // Заполняем массив подходящих платежей
        Payment[] filteredPayments = new Payment[count];
        int index = 0;
        for (Payment payment : report.getPayments()) {
            if (payment.getFullName().startsWith(String.valueOf(startsWith))) {
                filteredPayments[index++] = payment;
            }
        }

        return new FinanceReport(report.getAuthorFullName(), report.getDay(), report.getMonth(), report.getYear(), filteredPayments);
    }

    public static FinanceReport getPaymentsBelowAmount(FinanceReport report, int maxAmount) {
            int count = 0;

            // Считаем количество подходящих платежей
            for (Payment payment : report.getPayments()) {
                if (payment.getAmountInKopecks() < maxAmount) {
                    count++;
                }
            }
            // Заполняем массив подходящих платежей
            Payment[] filteredPayments = new Payment[count];
            int index = 0;
            for (Payment payment : report.getPayments()) {
                if (payment.getAmountInKopecks() < maxAmount) {
                    filteredPayments[index++] = payment;
                }
            }

            return new FinanceReport(report.getAuthorFullName(), report.getDay(), report.getMonth(), report.getYear(), filteredPayments);
    }
}
