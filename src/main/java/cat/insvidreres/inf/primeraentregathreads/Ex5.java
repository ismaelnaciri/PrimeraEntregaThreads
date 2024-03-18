package cat.insvidreres.inf.primeraentregathreads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {
        for(int i = 0; i < 3; i++) {
            System.out.println("Write the desired command:");
            Scanner keyboard = new Scanner(System.in);

            String command = keyboard.next();
            try {
                executeGivenCommand(command);
            } catch (IOException e) {
                System.out.println("ERROR | " + e.getMessage());
            }
        }

    }

    public static void executeGivenCommand(String command) throws IOException {
        Process process = Runtime.getRuntime().exec("cmd.exe /c " + command);

        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

        String line;
        System.out.println("Output of executing " + command + " is:");
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

        try {
            int exitCode = process.waitFor();
            System.out.println("Exit code: " + exitCode);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        reader.close();
    }
}
