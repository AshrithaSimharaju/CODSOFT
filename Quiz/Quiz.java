import java.util.*;

class Question {
    String question;
    String[] options;
    int correctOption;

    public Question(String question, String[] options, int correctOption) {
        this.question = question;
        this.options = options;
        this.correctOption = correctOption;
    }
}

public class Quiz{

    private static final Scanner scanner = new Scanner(System.in);
    private static boolean timeUp = false; 

    public static void main(String[] args) {
        List<Question> questions = new ArrayList<>();
    questions.add(new Question(
    "Which keyword is used to create a subclass in Java?",
    new String[]{"1. implements", "2. extends", "3. inherit", "4. subclass"},
    2
    ));

    questions.add(new Question(
    "Which method is used to start a thread in Java?",
    new String[]{"1. run()", "2. execute()", "3. start()", "4. launch()"},
    3
    ));

      questions.add(new Question(
      "What is the default value of a `boolean` variable in Java?",
       new String[]{"1. true", "2. false", "3. 0", "4. null"},
       2
       ));

        questions.add(new Question(
        "Which package contains the `ArrayList` class in Java?",
        new String[]{"1. java.util", "2. java.io", "3. java.lang", "4. java.sql"},
        1
        ));

        questions.add(new Question(
        "What is the output of `System.out.println(10 + 20 + \"Java\");`?",
        new String[]{"1. 30Java", "2. Java30", "3. 10Java20", "4. Compilation Error"},
        1
        ));
        Collections.shuffle(questions);

        int score = 0;

        for (Question q : questions) {
            timeUp = false;
            System.out.println("\n" + q.question);

            for (String option : q.options) {
                System.out.println(option);
            }

            System.out.println("You have 10 seconds to answer.");

            Thread timerThread = new Thread(() -> {
                try {
                    Thread.sleep(10000);
                    timeUp = true;
                    System.out.println("\nTime's up! Moving to the next question.");
                } catch (InterruptedException e) {
                    
                }
            });

            timerThread.start();

            int answer = -1;
            if (!timeUp) {
                try {
                    while (!timeUp && !scanner.hasNextInt()) {
                        Thread.sleep(100); 
                    }
                    if (!timeUp && scanner.hasNextInt()) {
                        answer = scanner.nextInt();
                    }
                } catch (Exception e) {
                    System.out.println("Error reading input.");
                }
            }

            timerThread.interrupt(); 

            
            if (!timeUp) {
                if (answer == q.correctOption) {
                    System.out.println("Correct!");
                    score++;
                } else {
                    System.out.println("Wrong! The correct answer was " + q.correctOption);
                }
            } else {
                System.out.println("The correct answer was " + q.correctOption);
            }
        }

        System.out.println("\nQuiz Completed!");
        System.out.println("Your Score: " + score + "/" + questions.size());
        System.out.println("Thank you for participating!");
    }
}
