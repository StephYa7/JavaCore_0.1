package st.example;

import static st.example.Writer.writeNote;
import java.time.LocalDateTime;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter node: ");
        Note note = new Note(scanner.next(), LocalDateTime.now());
        writeNote(note);

    }
}