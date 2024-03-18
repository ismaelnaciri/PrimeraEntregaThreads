package cat.insvidreres.inf.primeraentregathreads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Process.*;

public class Ex4 {

    public static void main(String[] args) {
        showFiles();
    }

    public static void showFiles() {
        try {
            Process process = Runtime.getRuntime().exec("cmd.exe /c dir C:\\Users\\Usuario\\Desktop");
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            process.waitFor();

            if (process.exitValue() != 0) {
                BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
                String errorLine;
                System.out.println("Error al llegir els fitxers i directoris de l'escriptori:");
                while ((errorLine = errorReader.readLine()) != null) {
                    System.out.println(errorLine);
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
