import java.util.ArrayList;
import java.util.Scanner;


public class GeneticsTester 
{
	public static void main(String[] args)
	{
		Genetics genetics = new Genetics();

		userLoop();
	}

	//user loop
	public static void userLoop()
	{
		System.out.println("Infinite Genetics: Infinitely large Punnett squares");
		System.out.println();

		//loop
		while(true)
		{
			//get user input, and check if it is correct
			boolean correctInput = false;
			String parentOneString = "";
			String parentTwoString = "";
			Scanner in = new Scanner(System.in);
			while(!correctInput)
			{
				parentOneString = "";
				parentTwoString = "  ";
				System.out.print("Enter the genotype of parent 1 (e.g. BbLL): ");
				parentOneString = in.next();

				System.out.print("Enter the genotype of parent 2: ");
				parentTwoString = in.next();

				if(parentOneString.length() == parentTwoString.length())
				{
					correctInput = true;
				}
				else
				{
					System.out.println("==============================================");
					System.out.println("The two genotypes need to be of the same length");
					System.out.println("==============================================");

				}
			}

			//the input was correct
			Genetics genetics = new Genetics();
			
			genetics.setParent1(parentOneString);
			genetics.setParent2(parentTwoString);

			

			//perform methods, conversion, and other stuff
			genetics.convertParent1StringToArray();
			genetics.convertParent2StringToArray();
			genetics.newCombosOne();
			genetics.newCombosTwo();
			genetics.results();

			//print out
			genetics.printResults();
			System.out.println();
			
			//percentages
			genetics.uniqueChildren();

			//check if the user wants to go again
			System.out.print("Do you want to go again? (y/n): ");
			String goAgain = in.next().toLowerCase();

			if(!goAgain.equals("y"))
			{
				System.out.println("Bye!!!");
				break;
			}
			System.out.println();

		}
	}
}
