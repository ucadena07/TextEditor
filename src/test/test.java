package test;

public class test {

	public static void main(String[] args) {
		String text = "2314511167";
		String[] words = text.split(" ,+");
		
		for (String word : words)
		{
			System.out.println(word);
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
