import java.util.Scanner;

public class DepositCalculator {
    public static final double YEAR_RATE = 0.06;
    
    double calculateComplexPercent(double amount, double yearRate, int depositPeriod) {
        double pay = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return calculateRound(pay, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        return calculateRound(amount + amount * yearRate * depositPeriod, 2);
    }

    double calculateRound(double value, int power) {
        double scale = Math.pow(10, power);
        return Math.round(value * scale) / scale;
    }

    void calculateDepositForPeriod() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        int period = scanner.nextInt( );
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        int action = scanner.nextInt();

        double result = 0;

        if (action == 1) {
            result = calculateSimplePercent(amount, YEAR_RATE, period);
        } else if (action == 2) {
            result = calculateComplexPercent(amount, YEAR_RATE, period);
        }

        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + result);
    }

    public static void main(String[] args)
    {
        new DepositCalculator().calculateDepositForPeriod();
    }
}
