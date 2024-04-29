import java.io.File;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        Stack<Character> OpenStack = new Stack<>();
        Character[] Openings = {'{','[','('};
        Character[] Closings = {'}',']',')'};

        try {
            //Starts by asking for file to import and reads it
            System.out.println("Please choose a file");
            Scanner scanner = new Scanner(System.in);
            String userResponse = scanner.nextLine();
            File file = new File(userResponse);
            Scanner inputfile = new Scanner(file);

            // Loops through the file line by line. Then reads each line character by character. When it comes across
            // an open bracket, curly, or parentheses it adds that to the stack. When it comes across a closing bracket,
            // curly, or parentheses it compares it to the top item in the stack. if the two types do not match it throws
            // an exception.
            while (inputfile.hasNextLine()) {
                String currentLine = inputfile.nextLine();
                for (int x = 0; x < currentLine.length(); x++) {
                    for (int i = 0; i < Openings.length; i++) {
                        if (currentLine.charAt(x) == Openings[i]) {
                            OpenStack.push(currentLine.charAt(x));
                        }
                    }

                    for (int i = 0; i < Closings.length; i++) {
                        if (currentLine.charAt(x) == Closings[i]) {
                            if (OpenStack.peek() == Openings[i]) {
                                OpenStack.pop();
                            } else {
                                throw new Exception("Parentheses are not correct.");
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
} // End of Class