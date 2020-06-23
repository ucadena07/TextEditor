package test;

public class test {

	public static void main(String[] args) {
	
		
		String s = "one (1), two (2), three (3)";
		String[] s2 = s.split("[");
		
		for (int i = 0; i < s2.length; i ++)
		{
			System.out.println(s2[i]);
		}
		
		
		
		
	}
	

	
	
	
	
	
	
	
	
//	public static String replace(String word, char gone, char here)
//	{
//		char [] cArray = word.toCharArray();
//		char[] cArrayMod = new char[cArray.length];
//		int i = 0;
//		
//		for (char c : cArray)
//		{
//			if (c == gone)
//				cArrayMod[i] = here;
//			else
//				cArrayMod[i] = c;
//				i++;
//			
//			
//		}
//		return new String(cArrayMod);
//		
//	}
	
	
	
//	public static int hasLetter(String word, char letter)
//	{
//		for (int i = 0; i < word.length(); i++) {
//			if (word.charAt(i) == letter)
//			{
//				return i;
//			}
//		}
//		return -1;
//	}
	
//	public static int hasLetter(String word, char letter)
//	{
//		for (char c : word.toCharArray())
//		{
//			if (c == letter) 
//			{
//				return word.indexOf(letter);
//			}
//		}
//		return 0;
//	}

}
