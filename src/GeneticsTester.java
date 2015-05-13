import java.util.ArrayList;


public class GeneticsTester 
{
	public static void main(String[] args)
	{
		//create variables
		Genetics genetics = new Genetics("FfGgXxRr", "FFggXXrr");
		genetics.convertParent1StringToArray();
		genetics.convertParent2StringToArray();
		genetics.newCombosOne();
		genetics.newCombosTwo();
		

		//ArrayList<String> array = genetics.newCombosOne();
		
		genetics.results();
		genetics.printResults();
		
		
		//get user input
		
		//perform calculations
		
		//print results
	}
}
