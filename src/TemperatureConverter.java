import java.util.Scanner;

public class TemperatureConverter {

    public static double convertTemperature(double temperature, String unit) {
        if (unit.equalsIgnoreCase("C")) {
            return (temperature * 9.0 / 5.0) + 32;
        } else if (unit.equalsIgnoreCase("F")) {
            return (temperature - 32) * 5.0 / 9.0;
        }
        return 0.0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";

        System.out.print("Enter temperature (or 'stop' to quit): ");
        input = scanner.nextLine();

        while (!input.equalsIgnoreCase("stop")) {
            boolean validNumber = true;
            double temperature = 0.0;

            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if (!Character.isDigit(c) && c != '.' && c != '-') {
                    validNumber = false;
                    break;
                }
            }

            if (!validNumber) {
                System.out.println("Invalid input. Please enter a number.");
                System.out.print("Enter temperature (or 'stop' to quit): ");
                input = scanner.nextLine();
                continue;
            }

            temperature = Double.parseDouble(input);

            System.out.print("Enter unit (C or F): ");
            String unit = scanner.nextLine();

            while (!unit.equalsIgnoreCase("C") && !unit.equalsIgnoreCase("F")) {
                System.out.println("Invalid unit. Please enter C or F.");
                System.out.print("Enter unit (C or F): ");
                unit = scanner.nextLine();
            }

            double result = convertTemperature(temperature, unit);

            if (unit.equalsIgnoreCase("C")) {
                System.out.println(temperature + "is equal to" + result);
            } else {
                System.out.println(temperature + "is equal to" + result);
            }

            System.out.print("Enter temperature (or 'stop' to quit): ");
            input = scanner.nextLine();
        }

        scanner.close();

    }
}