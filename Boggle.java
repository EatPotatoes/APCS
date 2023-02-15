import java.util.ArrayList;
import java.util.Scanner;

public class Boggle 
{
	public static String[][] board = 
			{
			{"0", "0", "0", "0"},
			{"0", "0", "0", "0"},
			{"0", "0", "0", "0"},
			{"0", "0", "0", "0"},
			};
	
	public static boolean[][] visited = new boolean[4][4];
	
	public static int xPos = 0, yPos = 0;
	
	public static String[] dice = 
		{"COTAIA", "OSEWDN", "LERASC", "VGTZEI",
		"EYUGKL", "DUNOKT", "HYFEIE", "DVNZAE",
		"OQAMJB", "LEPUTS", "NEPIHS", "LUWIGR",
		"XIBOFR", "ALIBTY", "OMARSH", "DCEAPM"
		};
	
	public static ArrayList<String> letters = new ArrayList<String>();
	
	public static String word;
	
	public static void main(String[] args) 
	{
		for(int i = 0; i< dice.length; i++)
		{
			letters.add(dice[i]);
		}
		
		//generate a random number between 0 and letters.size()
		for(int y = 0; y < 4; y++)
		{
			for(int x = 0; x < 4; x++)
			{
				int cube = (int) (Math.random() * letters.size());
				int letter = (int) (Math.random() * 6);
				board[x][y] = letters.remove(cube).charAt(letter) + "";
				visited[x][y] = false;
			}
			
		}
		System.out.println("----------------");
		for(int y = 0; y < 4; y++)
		{
			System.out.print("|  ");
			for(int x = 0; x < 4; x++)
			{
				if(board[x][y].equals("Q"))
					System.out.print("Qu ");
				else
					System.out.print(board[x][y] + "  ");
			}
			System.out.println("|");
		}
		
		Scanner scan = new Scanner(System.in);
		System.out.println("----------------");
		System.out.println("Please enter a word to be found: ");
		word = scan.next();
		
		ArrayList<int[]> starts = new ArrayList<int[]>();
		
		for(int y = 0; y < 4; y++)
		{
			for(int x = 0; x < 4; x++)
			{
				if(board[x][y].equalsIgnoreCase(word.charAt(0) + ""))
				{
					starts.add(new int[] {x, y});
				}					
			}
		}
		
		if(starts.size() == 0)
			System.out.println(word + " is not in the boggle");
		else
		{
			boolean ans;
			while(starts.size() > 0)
			{
				visited[starts.get(0)[0]][starts.get(0)[1]] = true;
				ans = search(starts.get(0), word);
				if(ans == true)
				{
					System.out.println(word + " is in the boggle: " + ans);
					starts.clear();
				}
				else
				{
					starts.remove(0);
					System.out.println(word + " not found yet");
				}
			}	
			System.out.println("end of program");
		}
	}
	
	public static boolean search(int[] pos, String s)
	{
		int x = pos[0];
		int y = pos[1];
		
		String ch = s.charAt(0) + "";
		if(s.length() < 2)
		{
			if(ch.equalsIgnoreCase(board[x][y]))
				return true;
			else
				return false;
		}
		else
		{
			if(ch.equalsIgnoreCase(board[x][y]))
			{
				for(int i = y - 1; i <= y + 1; i++)
				{
					for(int j = x - 1; j <= x + 1; j++)
					{
						if(i >= 0 && j >= 0 && i < 4 && j < 4 && !visited[j][i])
							if(board[j][i].equalsIgnoreCase(s.charAt(1) + ""))
							{
								visited[j][i] = true;
								return search(new int[] {j, i}, s.substring(1));
							}
					}
				}
			}
			return false;
		}
	}
}
