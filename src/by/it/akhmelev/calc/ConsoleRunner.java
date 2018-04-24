package by.it.akhmelev.calc;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

class ConsoleRunner {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Parser parser = new Parser();

        try (BufferedReader reader = new BufferedReader(
                new FileReader(Util.getPathVarsTxt()))
        ) {
            String line;
            while ((line = reader.readLine()) != null)
                parser.calc(line);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CalcException e) {
            System.out.println(e);
        }


        Scanner scanner = new Scanner(System.in);
        String line;

        while (!(line = scanner.nextLine()).equals("end")) {
            try {
                Var result = parser.calc(line);
                printer.print(result);
            } catch (CalcException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
