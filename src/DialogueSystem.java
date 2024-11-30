import java.util.concurrent.TimeUnit;


public class DialogueSystem {
    public static void typeSentence(String sentence) {
        for (char letter : sentence.toCharArray()) {
            System.out.print(letter);

            try {
                TimeUnit.MILLISECONDS.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
}}
