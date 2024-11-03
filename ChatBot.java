import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ChatBot {
    private Map<String, String> qaMap;

    public ChatBot(String filePath) {
        qaMap = new HashMap<>();
        loadQuestionsAndAnswers(filePath);
    }

    private void loadQuestionsAndAnswers(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("Q: ")) {
                    String question = line.substring(3).trim();
                    String answer = br.readLine().substring(3).trim();
                    qaMap.put(question.toLowerCase(), answer);
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading Q&A file: " + e.getMessage());
        }
    }

    public String getAnswer(String question) {
        String answer = qaMap.get(question.toLowerCase());
        return (answer != null) ? answer : "Sorry, that question is out of my scope.";
    }
}
