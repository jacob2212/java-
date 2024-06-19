import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverter {
    private final Map<String, Double> exchangeRates;

    public CurrencyConverter() {
        this.exchangeRates = new HashMap<>();
        // Initialize exchange rates
        exchangeRates.put("USD", 1.0);
        exchangeRates.put("EUR", 0.85);
        exchangeRates.put("GBP", 0.73);
        exchangeRates.put("JPY", 111.38);
        exchangeRates.put("MXN", 20.32);
        exchangeRates.put("CNY", 6.38);
        // Add more rates as needed
    }

    public double convert(double amount, String fromCurrency, String toCurrency) {
        if (!exchangeRates.containsKey(fromCurrency) || !exchangeRates.containsKey(toCurrency)) {
            throw new IllegalArgumentException("Invalid currency code.");
        }
        double fromRate = exchangeRates.get(fromCurrency);
        double toRate = exchangeRates.get(toCurrency);
        return (amount / fromRate) * toRate;
    }

    public void displayAvailableCurrencies() {
        System.out.println("\nAvailable currencies:");
        for (String currency : exchangeRates.keySet()) {
            System.out.print(currency + " ");
        }
        System.out.println();
    }

    public void updateExchangeRates() {
        // Implement the logic to update exchange rates using the provided API
        // This part is currently missing in the code
        // You can use the accessKey and make API requests to update exchange rates
        System.out.println("Exchange rates updated (mock implementation).");
    }

    public void performCurrencyConversion(Scanner scanner) {
        System.out.print("Enter the base currency code (e.g., USD): ");
        String baseCurrency = scanner.nextLine().toUpperCase();
        if (!exchangeRates.containsKey(baseCurrency)) {
            System.out.println("Invalid currency code.");
            return;
        }

        System.out.print("Enter the value in " + baseCurrency + " to convert: ");
        double userValue;
        try {
            userValue = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Exiting...");
            return;
        }

        System.out.println("\nComparing other currencies to " + userValue + " " + baseCurrency + ":");
        for (String currencyCode : exchangeRates.keySet()) {
            if (!currencyCode.equals(baseCurrency)) {
                double convertedAmount = convert(userValue, baseCurrency, currencyCode);
                System.out.println(currencyCode + " " + convertedAmount);
            }
        }
    }
}
