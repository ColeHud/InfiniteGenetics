import java.util.ArrayList;
import java.util.Scanner;


public class Genetics 
{
	//instance variables
	private String parent1;
	private String parent2;
	public String[][] parentOne;
	public String[][] parentTwo;
	public ArrayList<String> combinationsOne;
	public ArrayList<String> combinationsTwo;
	private String[][] results;

	//getters
	public String getParent1()
	{
		return parent1;
	}

	public String getParent2()
	{
		return parent2;
	}

	//setters
	public void setParent1(String parent1)
	{
		this.parent1 = parent1;
	}

	public void setParent2(String parent2)
	{
		this.parent2 = parent2;
	}

	//constructor
	public Genetics(String parent1, String parent2)
	{
		this.parent1 = parent1;
		this.parent2 = parent2;
	}

	public Genetics()
	{

	}

	//methods

	//convert parent string into string array
	public void convertParent1StringToArray()
	{
		parentOne = new String[parent1.length()/2][];

		for(int i = 0; i < parentOne.length; i++)
		{
			parentOne[i] = new String[2];
		}

		int stringLoop = 0;
		for(int i = 0; i < parentOne.length; i++)
		{
			parentOne[i][0] = parent1.charAt(stringLoop) + "";

			stringLoop++;

			parentOne[i][1] = parent1.charAt(stringLoop) + "";

			stringLoop++;
		}

	}

	public void convertParent2StringToArray()
	{
		parentTwo = new String[parent2.length()/2][];

		for(int i = 0; i < parentTwo.length; i++)
		{
			parentTwo[i] = new String[2];
		}

		int stringLoop = 0;
		for(int i = 0; i < parentTwo.length; i++)
		{
			parentTwo[i][0] = parent2.charAt(stringLoop) + "";

			stringLoop++;

			parentTwo[i][1] = parent2.charAt(stringLoop) + "";

			stringLoop++;
		}

	}

	//get all possible combinations of a parent
	public String[] combinationsOne()
	{
		//create an array of possible combinations equal to 2^#ofGenes
		int possibleCombos = (int)Math.pow(2, parentOne.length);
		String[] returnArray = new String[possibleCombos];

		//initialize returnArray
		for(int i = 0; i < returnArray.length; i++)
		{
			returnArray[i] = "";
		}

		//what is about to happen is extremely inefficient
		double random = 0.0;
		int count = 0;
		while(count < possibleCombos)
		{
			System.out.println(count + " out of " + possibleCombos);
			String currentString = "";
			//loop over each trait
			for(int i = 0; i < parentOne.length; i++)
			{
				random = Math.random();
				int choice = 0;
				if(random > .5)
				{
					choice = 0;
				}
				else
				{
					choice = 1;
				}

				currentString += parentOne[i][choice];
			}

			//check if this combo has already been found, if it has, then don't do anything, if it hasn't add it and add one to count
			if(doesContain(returnArray, currentString))
			{

			}
			else
			{
				returnArray[count] = currentString;
				count++;
			} 
		}

		return returnArray;
	}

	//does contain
	public static boolean doesContain(String[] array, String search)
	{
		if(array.length > 0)
		{
			for(String string : array)
			{
				if(string.equals(search))
				{
					return true;
				}
			}
		}


		return false;
	}

	//new combos
	public ArrayList<String> newCombosOne()
	{
		//create an array of possible combinations equal to 2^#ofGenes
		int possibleCombos = (int)Math.pow(2, parentOne.length);
		ArrayList<String> returnArray = new ArrayList<String>(possibleCombos);


		//find the combos of the first 2 terms
		for(String s : parentOne[0])
		{
			for(String r : parentOne[1])
			{
				returnArray.add((s+r));
			}
		}

		//doubleList(returnArray, parentOne[2]);

		for(int i = 2; i < parentOne.length; i++)
		{
			doubleList(returnArray, parentOne[i]);
		}

		combinationsOne = returnArray;
		return returnArray;
	}

	//new combos
	public ArrayList<String> newCombosTwo()
	{
		//create an array of possible combinations equal to 2^#ofGenes
		int possibleCombos = (int)Math.pow(2, parentTwo.length);
		ArrayList<String> returnArray = new ArrayList<String>(possibleCombos);


		//find the combos of the first 2 terms
		for(String s : parentTwo[0])
		{
			for(String r : parentTwo[1])
			{
				returnArray.add((s+r));
			}
		}

		//doubleList(returnArray, parentOne[2]);

		for(int i = 2; i < parentTwo.length; i++)
		{
			doubleList(returnArray, parentTwo[i]);
		}

		combinationsTwo = returnArray;
		return returnArray;
	}

	//double
	public static void doubleList(ArrayList<String> list, String[] twoAlleles)
	{
		//set half to be of one allele
		int startListSize = list.size();
		for(int i = 0; i < startListSize; i++)
		{
			String s = list.get(i);
			list.add(s + twoAlleles[1]);
		}

		//and half to be of the other allele
		for(int i = 0; i < list.size() / 2; i++)
		{
			list.set(i, list.get(i) + twoAlleles[0]);
		}
	}

	//combine the two parents to find all possible outcomes
	public void results()
	{
		//give the results array dimension
		results = new String[combinationsTwo.size()][combinationsOne.size()];
		
		//loop over parent 2
		for(int y = 0; y < combinationsTwo.size(); y++)
		{
			for(int x = 0; x < combinationsOne.size(); x++)
			{
				String parent1 = combinationsOne.get(x);
				String parent2 = combinationsTwo.get(y);
				results[y][x] = combineSingles(parent1, parent2);
			}
		}
	}
	
	//combine two strings of single alleles
	public static String combineSingles(String p1, String p2)
	{
		String returnString = "";
		for(int i = 0; i < p1.length() && i < p2.length(); i++)
		{
			String one = p1.charAt(i) + "";
			String two = p2.charAt(i) + "";
			
			if(one.compareTo(two) < 0)
			{
				returnString += (p1.charAt(i) + "");
				returnString += (p2.charAt(i) + "");
			}
			else
			{
				returnString += (p2.charAt(i) + "");
				returnString += (p1.charAt(i) + "");
			}
			
		}
		
		return returnString;
	}

	//print the results
	public void printResults()
	{
		for(String[] array : results)
		{
			for(String s : array)
			{
				System.out.print(s + " ");
			}
			System.out.println();
			
		}
	}

	//user loop
	public void userLoop()
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
			this.parent1 = parentOneString;
			this.parent2 = parentTwoString;
			
			Genetics genetics = new Genetics(parent1, parent2);
			
			//perform methods, conversion, and other stuff
			genetics.convertParent1StringToArray();
			genetics.convertParent2StringToArray();
			genetics.newCombosOne();
			genetics.newCombosTwo();
			
			//print out
			System.out.println();
			genetics.printResults();
			System.out.println();
			
			//check if the user wants to go again
			System.out.print("Do you want to go again? (y/n): ");
			String goAgain = in.next().toLowerCase();
			
			if(!goAgain.equals("y"))
			{
				break;
			}
			
		}
	}
	

}
