package cat.insvidreres.inf.primeraentregathreads;

import java.io.IOException;

public class Ex6 {

    public static void main(String[] args) {
        try {
            ProcessBuilder pingPB = new ProcessBuilder("ping", "127.0.0.1");
            ProcessBuilder notepadPB = new ProcessBuilder("notepad");

            Process pingProcess = pingPB.start();
            Process notepadProcess = notepadPB.start();

            pingProcess.waitFor();
            notepadProcess.waitFor();

            System.out.println("Els processos han finalitzat.");

        } catch (IOException | InterruptedException e) {
            System.out.println("Error | " + e.getMessage());
            e.printStackTrace();

        }
    }
}
