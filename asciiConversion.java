package week1Day3;

public class asciiConversion 
{
	//A1B2C3
	//B2C3D4
	//typecast String to integer
	//string to Char
	//Char to int
	//Char to String
	//int to String
	//Concat

	public static void main(String[] args) {

		String given = "A1B2C3";
		
		//First String conversion
		//Extract the 1st char from the string
		char s1 =given.charAt(0);
		// convert the given char to int ascii code
		int n1 = s1;
		int t1 =s1+1;
		//convert the int ascii code to char
		char o1 =(char) t1;
		String str1 = String.valueOf(o1);  
	
		//second String conversion
		char s2 =given.charAt(1);
		int t2=Character.getNumericValue(s2);
		int o2=t2+1;	
		String str2=String.valueOf(o2);

		//Third String conversion
		char s3 =given.charAt(2);
		int n3 = s3;
		int t3 =s3+1;
		char o3 =(char) t3;	
		String str3 = String.valueOf(o3); 

		//Fourth String conversion
		char s4 =given.charAt(3);
		int t4=Character.getNumericValue(s4);
		int o4=t4+1;
		String str4=String.valueOf(o4);  

		//Fifth String conversion
		char s5 =given.charAt(4);
		int n5 = s5;	
		int t5 =s5+1;
		char o5 =(char) t5;
		String str5 = String.valueOf(o5); 
	
		//sixth String conversion
		char s6 =given.charAt(5);
		int t6=Character.getNumericValue(s6);
		int o6=t6+1;
		String str6=String.valueOf(o6);
		
		String converted  =str1.concat(str2).concat(str3).concat(str4).concat(str5).concat(str6);
		
		System.out.println(given);
		System.out.println(converted);
		
	}
}
