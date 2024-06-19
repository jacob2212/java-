import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CurrencyConverter converter = new CurrencyConverter();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n=== Currency Converter Menu ===");
            System.out.println("1. Update Exchange Rates");
            System.out.println("2. Display Available Currencies");
            System.out.println("3. Perform Currency Conversion");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter your access key: ");
                    String accessKey = scanner.nextLine();
                    converter.updateExchangeRates();
                }
                case 2 -> converter.displayAvailableCurrencies();
                case 3 -> converter.performCurrencyConversion(scanner);
                case 4 -> running = false;
                default -> System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }

        System.out.println("Exiting the Currency Converter. Goodbye!");
        scanner.close();
    }
}
