import java.util.ArrayList;

public class QuizTime {

	public static void main(String[] args) 
	{
		Quiz quiz = new Quiz();
		System.out.println("All answers all lowercase no exceptions except numbers.");
		quiz.add(new Question("What color are the chairs in Mr. Steinberg's room?", "blue"));
		quiz.add(new Question("Who wrote the Percy Jackson series?", "rick riordan"));
		quiz.add(new Question("What shape is an analog clock?", "circle"));
		quiz.add(new Question("How many stars on the American flag?", "50"));
		quiz.add(new Question("How many hinges on the average door?", "3"));
		quiz.add(new Question("Who wrote 1984?", "george orwell"));
		quiz.add(new Question("It was the best of __, it was the worst of __", "times"));
		quiz.add(new Question("How many shoes does the average person wear at once?", "2"));
		quiz.add(new Question("Which snake is also the name of a programming language?", "python"));
		quiz.add(new Question("Now I have become __, the destroyer of worlds?", "death"));
		
		quiz.giveQuiz();
		int answers = quiz.answers;
		
		System.out.println("Correct: " + answers);
	}

}
