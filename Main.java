import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ChatBot chatBot = new ChatBot("answer.txt");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome! Type your question or type 'exit' to quit.");
        while (true) {
            System.out.print("You: ");
            String question = scanner.nextLine();
            
            if (question.equalsIgnoreCase("exit")) {
                System.out.println("Goodbye!");
                break;
            }

            String answer = chatBot.getAnswer(question);
            System.out.println("Bot: " + answer);
        }

        scanner.close();
    }
}
