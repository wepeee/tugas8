import java.util.Scanner;

public class Parser {
    private Scanner reader;

    public Parser() {
        reader = new Scanner(System.in);
    }

    public Command getCommand() {
        System.out.print("> ");
        String inputLine = reader.nextLine();
        String[] words = inputLine.split(" ");
        String commandWord = (words.length > 0) ? words[0] : null;
        String secondWord = (words.length > 1) ? words[1] : null;
        return new Command(commandWord, secondWord);
    }
}
