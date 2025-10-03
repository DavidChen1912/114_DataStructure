import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Please type URL and Keyword: ");
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) break;
            String[] parts = line.split("\\s+", 2);
            if (parts.length < 2) {
                System.out.println("Input format error! Please enter: <URL> <Keyword>");
                continue;
            }
            String urlStr = parts[0];
            String keyword = parts[1];

            WordCounter counter = new WordCounter(urlStr);
            System.out.println(keyword + " appears " + counter.countKeyword(keyword) + " times.");
        }
        sc.close();
    }
}