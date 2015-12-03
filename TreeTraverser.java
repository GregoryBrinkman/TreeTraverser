import java.util.Scanner;

public class TreeTraverser {
	public void prettyPrint(int[] a)
	{
		printAtNode(a[0], a);
	}//end prettyPrint

	public void printAtNode(int start, int[] a)
	{
		int height = getTreeHeight(a)-getHeight(start);
		int numSpaces = 3;

		for(int j = 0; j < height; j++)
			numSpaces = (numSpaces * 2)+2;//Find the number of spaces the first node needs to print correctly. 
		
		for(int i = 0; i <= height; i++)
		{
			int numNodes = (int) Math.pow(2, i);
			int startLine = start;

			for (int u = numNodes; u != 0; u--)
			{
				if(u == numNodes)
				{
					for(int q = 0; q < (numSpaces-2)/2; q++)
						System.out.print(" ");
				}else{
					for (int q = 0; q < numSpaces; q++)
						System.out.print(" ");
				}		
				if(u == 1)
				{
					System.out.println(start);
				}else{
					System.out.print(start++);
				}
			}
			numSpaces = (numSpaces-2)/2;//This is the pattern found by counting the spaces between the numbers in a binary tree. This only works for up to 3 digit numbers.
			if (numSpaces == 3)
				numSpaces = 2;//at this point, the numbers are 3 digit, which take up another character. Decrement a space to commpensate.
			start = getLeft(startLine);
		}
	}//end printAtNode

	public void traverse(int[] a)
	{
		Scanner scan = new Scanner(System.in);
		int i = a[0];
		while(true)
		{
			System.out.println("commands are: 'l', 'r', 'p', 's', 't', 'q'");
			String command = scan.nextLine();
			if (command.equals("l"))
			{
				if (getLeft(i) < a.length) 
					i = getLeft(i);
				printNode(i);
			}			
			if (command.equals("r"))
			{
				if(getRight(i) < a.length)
					i = getRight(i);
				printNode(i);
			}
			if (command.equals("p"))
			{
				i = getParent(i);
				printNode(i); 
			}
			if (command.equals("s"))
			{
				System.out.println("Would you like to display the left sibling or right sibling?\nType l for left; r for right.");//doesn't do anything besides that println statement. just goes back to the while loop. #Sneaky
			}
			if (command.equals("t"))
			{
				printAtNode(i, a);
			}
			if (command.equals("q"))
			{
				break;
			}
		}
	}//end traverseTree

	public void printNode(int element)
	{
		System.out.println(element);//easier print method
	}//end printNode

	public int getTreeHeight(int [] a)
	{
		return getHeight(a[a.length-1]);//returns height of last node in the binary tree
	}//end getTreeHeight

	public int getHeight(int h)
	{
		for(int i = 0; true; i++)
			if (Math.pow(2, i) > h)
				return i;
	}//end getHeight

	public int getParent(int kid)
	{
		if(getHeight(kid) == 1)
			return 1;
		if(kid % 2 != 0)
			return (kid-1)/2;
		return kid/2;
	}//end getParent

	public int getLeft(int parent)
	{
		return parent*2;
	}//end getLeft

	public int getRight(int parent)
	{
		return parent*2+1;
	}//end getRight
}//end TreeTraverser
