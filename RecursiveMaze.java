import java.util.concurrent.TimeUnit;

public class RecursiveMaze 
{
	public static String direction = "Right";
	/**
	public static String[][] maze = {
			{"#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#"},
			{"#", ".", ".", ".", "#", ".", ".", ".", ".", ".", ".", "#"},
			{"X", ".", "#", ".", "#", ".", "#", "#", "#", "#", ".", "#"},
			{"#", "#", "#", ".", ".", ".", ".", ".", ".", "#", ".", "#"},
			{"#", ".", ".", ".", ".", "#", "#", "#", ".", "#", ".", "#"},
			{"#", "#", "#", "#", "#", "#", ".", "#", ".", "#", ".", "#"},
			{"#", ".", ".", "#", ".", "#", ".", "#", ".", "#", ".", "#"},
			{"#", "#", ".", "#", ".", "#", ".", "#", ".", "#", ".", "#"},
			{"#", ".", ".", ".", ".", ".", ".", ".", ".", "#", ".", "#"},
			{"#", "#", "#", "#", "#", ".", "#", "#", "#", "#", ".", "."},
			{"#", ".", ".", ".", ".", ".", ".", "#", ".", ".", ".", "#"},
			{"#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#"}
			};
	**/
	//down is positive y, right is positive x
	
	public static String[][]maze = {
			{"#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#"},
			{"#", ".", ".", ".", "#", ".", ".", ".", ".", "#", ".", "#"},
			{"X", ".", "#", ".", "#", "#", "#", "#", "#", "#", ".", "#"},
			{"#", "#", "#", ".", "#", ".", ".", ".", ".", "#", ".", "#"},
			{"#", ".", ".", ".", ".", ".", "#", "#", ".", "#", ".", "."},
			{"#", "#", "#", "#", "#", "#", ".", "#", ".", "#", ".", "#"},
			{"#", "#", ".", ".", ".", "#", ".", "#", ".", "#", ".", "#"},
			{"#", "#", ".", "#", ".", "#", ".", "#", ".", "#", ".", "#"},
			{"#", ".", ".", "#", ".", ".", ".", ".", ".", "#", ".", "#"},
			{"#", ".", "#", "#", "#", "#", "#", "#", "#", "#", ".", "#"},
			{"#", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "#"},
			{"#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#"},
			};
	
	public static void main(String[] args) 
	{
		int[] position = new int[2];
		for(int i = 0; i < 12; i++)
		{
			for(int j = 0; j < 12; j++)
			{
				//System.out.print(maze[i][j] + " ");
				if(maze[i][j] == "X")
				{
					position[1] = i; //y coord
					position[0] = j; //x coord
				}
					
			}
			System.out.println();
		}
				
		int[] ans = traverseTheMaze(position);
	}


	public static int[] traverseTheMaze(int[] pos)
	//maze[i][j] is [y coord][x coord]
	{
		int x = pos[0]; 
		int y = pos[1];
		for(int i = 0; i < 12; i++)
		{
			for(int j = 0; j < 12; j++)
			{
				System.out.print(maze[i][j] + " ");					
			}
			System.out.println();
		}
		System.out.println("========================");
		if(x == 11)
			return pos;
		else
		{
			if(direction.equals("Right"))
			{
				if(maze[y - 1][x].equals("."))//left
				{
					maze[y - 1][x] = "X";
					maze[y][x] = ".";
					direction = "Up";
					return traverseTheMaze(new int[] {x, y - 1});
				}
				else if(maze[y][x + 1].equals("."))//forward
				{
					maze[y][x + 1] = "X";
					maze[y][x] = ".";
					direction = "Right";
					return traverseTheMaze(new int[] {x + 1, y});
				}
				else if(maze[y + 1][x].equals("."))//right
				{
					maze[y + 1][x] = "X";
					maze[y][x] = ".";
					direction = "Down";
					return traverseTheMaze(new int[] {x, y + 1});
				}
				else if(maze[y][x - 1].equals("."))//backward
				{
					maze[y][x - 1] = "X";
					maze[y][x] = ".";
					direction = "Left";
					return traverseTheMaze(new int[] {x - 1, y});
				}
				else
				{
					maze[y][x] = "FAILED";
					System.out.println("Error");
					return traverseTheMaze(new int[] {11, y});
				}
			}
			else if(direction.equals("Up"))
			{
				if(maze[y][x - 1].equals("."))//left
				{
					maze[y][x - 1] = "X";
					maze[y][x] = ".";
					direction = "Left";
					return traverseTheMaze(new int[] {x - 1, y});
				}
				else if(maze[y - 1][x].equals("."))//forward
				{
					maze[y - 1][x] = "X";
					maze[y][x] = ".";
					direction = "Up";
					return traverseTheMaze(new int[] {x, y - 1});
				}
				else if(maze[y][x + 1].equals("."))//right
				{
					maze[y][x + 1] = "X";
					maze[y][x] = ".";
					direction = "Right";
					return traverseTheMaze(new int[] {x + 1, y});
				}
				else if(maze[y + 1][x].equals("."))//backward
				{
					maze[y + 1][x] = "X";
					maze[y][x] = ".";
					direction = "Down";
					return traverseTheMaze(new int[] {x, y + 1});
				}
				else
				{
					maze[y][x] = "FAILED";
					System.out.println("Error");
					return traverseTheMaze(new int[] {11, y});
				}
			}
			else if(direction.equals("Down"))
			{
				if(maze[y][x + 1].equals("."))//left
				{
					maze[y][x + 1] = "X";
					maze[y][x] = ".";
					direction = "Right";
					return traverseTheMaze(new int[] {x + 1, y});
				}
				else if(maze[y + 1][x].equals("."))//forward
				{
					maze[y + 1][x] = "X";
					maze[y][x] = ".";
					direction = "Down";
					return traverseTheMaze(new int[] {x, y + 1});
				}
				else if(maze[y][x - 1].equals("."))//right
				{
					maze[y][x - 1] = "X";
					maze[y][x] = ".";
					direction = "Left";
					return traverseTheMaze(new int[] {x - 1, y});
				}
				else if(maze[y - 1][x].equals("."))//backward
				{
					maze[y - 1][x] = "X";
					maze[y][x] = ".";
					direction = "Up";
					return traverseTheMaze(new int[] {x, y - 1});
				}
				else
				{
					maze[y][x] = "?";
					System.out.println("Error");
					return traverseTheMaze(new int[] {11, y});
				}
			}
			else if(direction.equals("Left"))
			{
				if(maze[y + 1][x].equals("."))//left
				{
					maze[y + 1][x] = "X";
					maze[y][x] = ".";
					direction = "Down";
					return traverseTheMaze(new int[] {x, y + 1});
				}
				else if(maze[y][x - 1].equals("."))//forward
				{
					maze[y][x - 1] = "X";
					maze[y][x] = ".";
					direction = "Left";
					return traverseTheMaze(new int[] {x - 1, y});
				}
				else if(maze[y - 1][x].equals("."))//right
				{
					maze[y - 1][x] = "X";
					maze[y][x] = ".";
					direction = "Up";
					return traverseTheMaze(new int[] {x, y - 1});
				}
				else if(maze[y][x + 1].equals("."))//backward
				{
					maze[y][x + 1] = "X";
					maze[y][x] = ".";
					direction = "Right";
					return traverseTheMaze(new int[] {x + 1, y});
				}
				else
				{
					maze[y][x] = "?";
					System.out.println("Error");
					return traverseTheMaze(new int[] {11, y});
				}
			}
		}
		maze[y][x] = "$";
		return traverseTheMaze(new int[] {11, y});
	}
}