import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int earnings = 0;    // доходы
        int spendings = 0;   // расходы

        while (true) {
            System.out.println();
            System.out.println("Выберите операцию и введите её номер:");
            System.out.println("1. Добавить новый доход");
            System.out.println("2. Добавить новый расход");
            System.out.println("3. Выбрать систему налогообложения");

            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }
            int operation = Integer.parseInt(input);
            switch (operation) {
                case 1:
                    System.out.println("Введите сумму дохода:");
                    String moneyEarnings = scanner.nextLine();
                    int sumMoneyEarnings = Integer.parseInt(moneyEarnings);
                    earnings += sumMoneyEarnings;
                    break;
                case 2:
                    System.out.println("Введите сумму расхода:");
                    String moneySpendings = scanner.nextLine();
                    int sumMoneySpending = Integer.parseInt(moneySpendings);
                    spendings += sumMoneySpending;
                    break;
                case 3:
                    int taxEarningsMinusSpendings = taxEarningsMinusSpendings(earnings, spendings);
                    int taxEarnings = taxEarnings(earnings);
                    if (taxEarningsMinusSpendings == taxEarnings) {
                        System.out.println("Можете выбрать любую систему налогообложения");
                    } else if (taxEarningsMinusSpendings == 0 || taxEarnings < taxEarningsMinusSpendings) {
                        if (taxEarningsMinusSpendings == 0) {
                            System.out.println("Мы советуем вам УСН доходы минус расходы");
                            System.out.println("Ваш налог составит: " + taxEarningsMinusSpendings);
                            System.out.println("Налог на другой системе: " + taxEarnings);
                            System.out.println("Экономия: " + (taxEarnings - taxEarningsMinusSpendings));
                        } else {
                            System.out.println("Мы советуем вам УСН доходы");
                            System.out.println("Ваш налог составит: " + taxEarnings);
                            System.out.println("Налог на другой системе: " + taxEarningsMinusSpendings);
                            System.out.println("Экономия: " + (taxEarningsMinusSpendings - taxEarnings));
                        }
                    } else {
                        System.out.println("Мы советуем вам УСН доходы минус расходы");
                        System.out.println("Ваш налог составит: " + taxEarningsMinusSpendings);
                        System.out.println("Налог на другой системе: " + taxEarnings);
                        System.out.println("Экономия: " + (taxEarnings - taxEarningsMinusSpendings));
                    }
                    break;
            }
        }
        System.out.println("Программа завершена!");
    }

    public static int taxEarningsMinusSpendings(int earnings, int spendings) {
        int tax = (earnings - spendings) * 15 / 100;
        if (tax >= 0) {
            return tax;
        } else {
            // если расходы оказались больше, то налог посчитается отрицательным
            return 0;
        }
    }

    public static int taxEarnings(int earnings) {
        int tax = earnings * 6 / 100;
        return tax;
    }
}