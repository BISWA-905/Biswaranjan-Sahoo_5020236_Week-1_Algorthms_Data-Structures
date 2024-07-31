
public class FinancialForecasting {
	// Recursive method to calculate future value
    public double calculateFutureValue(double currentValue, double growthRate, int periods) {
        // Base case: If periods is 0, return the current value
        if (periods == 0) {
            return currentValue;
        }
        // Recursive case: Calculate the future value for one less period
        return calculateFutureValue(currentValue * (1 + growthRate), growthRate, periods - 1);
    }

    public static void main(String[] args) {
        FinancialForecasting forecasting = new FinancialForecasting();

        // Example usage
        double currentValue = 1000.0;
        double annualGrowthRate = 0.05; // 5%
        int periods = 10; // 10 years

        double futureValue = forecasting.calculateFutureValue(currentValue, annualGrowthRate, periods);
        System.out.println("Future Value after " + periods + " periods: " + futureValue);
    }
}
