import java.util.ArrayList;


public class GeneticsTester 
{
	public static void main(String[] args)
	{
		//create variables
		Genetics genetics = new Genetics("FfGgXxCCZz", "FFgg");
		genetics.convertParent1StringToArray();
		
		ArrayList<String> array = genetics.newCombosOne();
		
		for(String string : array)
		{
			System.out.println(string);
		}
		
		//get user input
		
		//perform calculations
		
		//print results
	}
}
