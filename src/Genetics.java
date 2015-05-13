
public class Genetics 
{
	//instance variables
	private String parent1;
	private String parent2;
	public String[][] parentOne;
	public String[][] parentTwo;
	public String[] combinationsOne;
	public String[] combinationsTwo;
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
	
	
	
	
}
