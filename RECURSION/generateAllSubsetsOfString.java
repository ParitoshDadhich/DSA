public class Main
{
	public static void main(String[] args) {
		printSubsets("abc", "");
	}
	
	private static void printSubsets(String str, String op){
	    if(str.length() == 0){
	        System.out.println(op);
	        return;
	    }
	    
	    String op1 = op;
	    String op2 = op + str.charAt(0);
	    str = str.substring(1);
	    
	    printSubsets(str, op1);
	    printSubsets(str, op2);
	    
	    return;
	}
	
}
