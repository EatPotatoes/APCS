import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Quiz implements Complexity
{
	ArrayList<Question> questions;
	int answers;
	int complexity;
	
	public Quiz()
	{
		complexity = 0;
		questions = new ArrayList<Question>();
		answers = 0;
	}
	
	/**
	 * Adds a question to the quiz
	 * @param q the question to be added
	 */
	public void add(Question q)
	{
		questions.add(q);
	}
	
	/**
	 * Gives a quiz based on the questions given
	 */
	public void giveQuiz()
	{
		answers = 0;
		
		if (questions.size() < 10)
		{
			System.out.println("You must have at least 10 questions. Please add more questions");
			System.out.println("Currently there are: " + questions.size() + " questions");
		}
		
		else
		{
			for(int i = 0; i < questions.size(); i++)
			{
				Scanner scan = new Scanner(System.in);
				System.out.println(questions.get(i).getQuestion());
				System.out.print("Answer: ");
				if(questions.get(i).answerCorrect(scan.nextLine()))
				{
					answers++;
				}
			}
		}
			writeFile("Quiz.txt", toString());
	}
	
	public static void writeFile(String oFileName, String data) 
	{
	    try
	    {
	        BufferedWriter out = new BufferedWriter(new FileWriter(oFileName));
	        out.write(data + "\n");
	        out.close();
	    } catch (IOException e) {}
	}
	
	/**
	 * Sets the complexity
	 */
	public void setComplexity (int c)
	{
		complexity = c;
	}
	
	/**
	 * Returns the complexity
	 */
	public int getComplexity()
	{	
		return complexity;
	}
	
	public String toString()
	{
		String result = new String("List of Questions:\n");
		for(int i = 0; i < questions.size(); i++)
		{
			result = result + questions.get(i).getQuestion() + "\n";
		}
		
		return result;
	}
}
