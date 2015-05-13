
public class GeneticsTester 
{
	public static void main(String[] args)
	{
		//create variables
		Genetics genetics = new Genetics("FfGgXxCC", "FFgg");
		genetics.convertParent1StringToArray();
		
		String[] array = genetics.combinationsOne();
		
		for(String string : array)
		{
			System.out.println(string);
		}
		
		//get user input
		
		//perform calculations
		
		//print results
	}
}
