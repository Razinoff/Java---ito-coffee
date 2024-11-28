import org.example.StringProcessor;
import org.example.Payment;
import org.example.FinanceReport;
import org.example.FinanceReportProcessor;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StringProcessorTest {
    @Test
    void testStringProcessor1_1() {
        assertEquals("sss",StringProcessor.repeatString("s",3));
    }
    @Test
    void testStringProcessor1_2() {
        assertEquals("",StringProcessor.repeatString("s",0));
    }
    @Test
    void testStringProcessor1_3() {
        assertThrows(IllegalArgumentException.class, () -> {
            StringProcessor.repeatString(null, -4);
        });
    }
    @Test
    void testStringProcessor2_1() {
        assertEquals(4,StringProcessor.countOccurrences("s5s5s5s","s"));
    }
    @Test
    void testStringProcessor2_2() {
        assertEquals(0,StringProcessor.countOccurrences("s5s5s5s","s"));
    }@Test
    void testStringProcessor2_3() {
        assertEquals(0,StringProcessor.countOccurrences("s5s5s5s","s"));
    }@Test
    void testStringProcessor2_4() {
        assertThrows(IllegalArgumentException.class, () -> {
            StringProcessor.countOccurrences(null, null);
        });
    }@Test
    void testStringProcessor3_1() {
        assertEquals("одинfдваfтриf",StringProcessor.replaceDigits("1f2f3f"));
    }@Test
    void testStringProcessor3_2() {
        assertThrows(IllegalArgumentException.class, () -> {
            StringProcessor.replaceDigits(null);
        });
    }@Test
    void testStringProcessor4_1() {
        assertThrows(IllegalArgumentException.class, () -> {
            StringProcessor.removeEverySecondChar(null);
        });
    }@Test
        void testStringProcessor4_2() {
        StringBuilder r = new StringBuilder("ab");
        assertEquals("a", StringProcessor.removeEverySecondChar(r));
    }
    }

    class PaymentTest {
        @Test
        void testConstructorAndGetters() {
            Payment payment = new Payment("Egor Cringe", 1, 1, 2022, 1000);

            assertEquals("Egor Cringe", payment.getFullName());
            assertEquals(1, payment.getDay());
            assertEquals(1, payment.getMonth());
            assertEquals(2022, payment.getYear());
            assertEquals(1000, payment.getAmountInKopecks());
        }

        @Test
        void testSetters() {
            Payment payment = new Payment();
            payment.setFullName("Friren Ruzvelt");
            payment.setDay(15);
            payment.setMonth(7);
            payment.setYear(2023);
            payment.setAmountInKopecks(500);

            assertEquals("Friren Ruzvelt", payment.getFullName());
            assertEquals(15, payment.getDay());
            assertEquals(7, payment.getMonth());
            assertEquals(2023, payment.getYear());
            assertEquals(500, payment.getAmountInKopecks());
        }

        @Test
        void testCopyConstructor() {
            Payment original = new Payment("Maks Smith", 12, 8, 2021, 1500);
            Payment copy = new Payment(original);

            assertEquals(original, copy);
            assertNotSame(original, copy); // Убедимся, что это разные объекты
        }

        @Test
        void testEqualsAndHashCode() {
            Payment payment1 = new Payment("Alices", 1, 1, 2022, 1000);
            Payment payment2 = new Payment("Alices", 1, 1, 2022, 1000);
            Payment payment3 = new Payment("Krot", 2, 2, 2023, 2000);

            assertEquals(payment1, payment2);
            assertEquals(payment1.hashCode(), payment2.hashCode());

            assertNotEquals(payment1, payment3);
            assertNotEquals(payment1.hashCode(), payment3.hashCode());
        }

        @Test
        void testToString() {
            Payment payment = new Payment("Egor Cringe", 25, 12, 2020, 2500);
            String expected = "Payment(fullName= Egor Cringe, date=25.12.2020, amount=2500 kopecks)";
            assertEquals(expected, payment.toString());
        }

        @Test
        void testNullFullNameInEquals() {
            Payment payment1 = new Payment(null, 1, 1, 2022, 1000);
            Payment payment2 = new Payment(null, 1, 1, 2022, 1000);

            assertEquals(payment1, payment2);
        }

        @Test
        void testNegativeAmountInKopecks() {
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
                Payment payment = new Payment("Egor Cringe", 1, 1, 2022, -100);
            });

            assertEquals("Сумма платежа не может быть отрицательной", exception.getMessage());
        }
    }

    class FinanceReportTest {
        @Test
        void testConstructorAndGetters() {
            Payment[] payments = {
                    new Payment("Иванов Иван Иванович", 12, 10, 2024, 5000),
                    new Payment("Петров Петр Петрович", 15, 11, 2024, 10000)
            };

            FinanceReport report = new FinanceReport("Сидоров Сидор Сидорович", 1, 12, 2024, payments);

            assertEquals("Сидоров Сидор Сидорович", report.getAuthorFullName());
            assertEquals(1, report.getDay());
            assertEquals(12, report.getMonth());
            assertEquals(2024, report.getYear());
            assertEquals(2, report.getCountOfPayments());
            assertEquals(payments[0], report.getPayment(0));
            assertEquals(payments[1], report.getPayment(1));
        }

        @Test
        void testSetPayment() {
            Payment[] payments = {
                    new Payment("Иванов Иван Иванович", 12, 10, 2024, 5000),
                    new Payment("Петров Петр Петрович", 15, 11, 2024, 10000)
            };

            FinanceReport report = new FinanceReport("Сидоров Сидор Сидорович", 1, 12, 2024, payments);

            Payment newPayment = new Payment("Смирнов Алексей Алексеевич", 20, 11, 2024, 15000);
            report.setPayment(1, newPayment);

            assertEquals(newPayment, report.getPayment(1));
        }

        @Test
        void testGetPaymentInvalidIndex() {
            Payment[] payments = {
                    new Payment("Иванов Иван Иванович", 12, 10, 2024, 5000)
            };

            FinanceReport report = new FinanceReport("Сидоров Сидор Сидорович", 1, 12, 2024, payments);

            assertThrows(IndexOutOfBoundsException.class, () -> report.getPayment(-1));
            assertThrows(IndexOutOfBoundsException.class, () -> report.getPayment(2));
        }

        @Test
        void testToString() {
            Payment[] payments = {
                    new Payment("Иванов Иван Иванович", 12, 10, 2024, 5000),
                    new Payment("Петров Петр Петрович", 15, 11, 2024, 10000)
            };

            FinanceReport report = new FinanceReport("Сидоров Сидор Сидорович", 1, 12, 2024, payments);

            String expected = "Автор: Сидоров Сидор Сидорович, дата: 01.12.2024 | Платежи: \n" +
                    " Плательщик: Иванов Иван Иванович, дата: 12.10.2024, сумма: 50 руб. 00 коп.\n" +
                    " Плательщик: Петров Петр Петрович, дата: 15.11.2024, сумма: 100 руб. 00 коп.";
            assertEquals(expected, report.toString());
        }

        @Test
        void testCloneConstructor() {
            Payment[] payments = {
                    new Payment("Иванов Иван Иванович", 12, 10, 2024, 5000),
                    new Payment("Петров Петр Петрович", 15, 11, 2024, 10000)
            };

            FinanceReport original = new FinanceReport("Сидоров Сидор Сидорович", 1, 12, 2024, payments);
            FinanceReport clone = new FinanceReport(original);

            assertEquals(original.getAuthorFullName(), clone.getAuthorFullName());
            assertEquals(original.getDay(), clone.getDay());
            assertEquals(original.getMonth(), clone.getMonth());
            assertEquals(original.getYear(), clone.getYear());
            assertEquals(original.getCountOfPayments(), clone.getCountOfPayments());
            assertNotSame(original.getPayments(), clone.getPayments()); // Копия массива
        }
    }
    class FinanceReportProcessorTest {
        @Test
        void testGetPaymentsBySurnameStart() {
            Payment[] payments = {
                    new Payment("Иванов Иван Иванович", 10, 10, 2024, 5000),
                    new Payment("Смирнов Алексей Алексеевич", 12, 10, 2024, 8000),
                    new Payment("Иванова Мария Сергеевна", 15, 10, 2024, 7000),
                    new Payment("Петров Петр Петрович", 20, 10, 2024, 6000)
            };

            FinanceReport report = new FinanceReport("Сидоров Сидор Сидорович", 1, 11, 2024, payments);

            // Фильтр по фамилиям, начинающимся на "И"
            FinanceReport filteredReport = FinanceReportProcessor.getPaymentsBySurnameStart(report, 'И');

            assertEquals(2, filteredReport.getCountOfPayments());
            assertEquals("Иванов Иван Иванович", filteredReport.getPayment(0).getFullName());
            assertEquals("Иванова Мария Сергеевна", filteredReport.getPayment(1).getFullName());
        }

        @Test
        void testGetPaymentsBySurnameStartNoMatch() {
            Payment[] payments = {
                    new Payment("Иванов Иван Иванович", 10, 10, 2024, 5000),
                    new Payment("Смирнов Алексей Алексеевич", 12, 10, 2024, 8000)
            };

            FinanceReport report = new FinanceReport("Сидоров Сидор Сидорович", 1, 11, 2024, payments);

            // Фильтр по фамилиям, начинающимся на "П"
            FinanceReport filteredReport = FinanceReportProcessor.getPaymentsBySurnameStart(report, 'П');

            assertEquals(0, filteredReport.getCountOfPayments());
        }

        @Test
        void testGetPaymentsBelowAmount() {
            Payment[] payments = {
                    new Payment("Иванов Иван Иванович", 10, 10, 2024, 5000),
                    new Payment("Смирнов Алексей Алексеевич", 12, 10, 2024, 8000),
                    new Payment("Петров Петр Петрович", 15, 10, 2024, 3000)
            };

            FinanceReport report = new FinanceReport("Сидоров Сидор Сидорович", 1, 11, 2024, payments);

            // Фильтр платежей, меньше 6000 копеек
            FinanceReport filteredReport = FinanceReportProcessor.getPaymentsBelowAmount(report, 6000);

            assertEquals(2, filteredReport.getCountOfPayments());
            assertEquals("Иванов Иван Иванович", filteredReport.getPayment(0).getFullName());
            assertEquals("Петров Петр Петрович", filteredReport.getPayment(1).getFullName());
        }

        @Test
        void testGetPaymentsBelowAmountNoMatch() {
            Payment[] payments = {
                    new Payment("Иванов Иван Иванович", 10, 10, 2024, 10000),
                    new Payment("Смирнов Алексей Алексеевич", 12, 10, 2024, 12000)
            };

            FinanceReport report = new FinanceReport("Сидоров Сидор Сидорович", 1, 11, 2024, payments);

            // Фильтр платежей, меньше 5000 копеек
            FinanceReport filteredReport = FinanceReportProcessor.getPaymentsBelowAmount(report, 5000);

            assertEquals(0, filteredReport.getCountOfPayments());
        }
    }


