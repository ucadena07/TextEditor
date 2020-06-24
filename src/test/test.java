package test;

public class test {

	public static void main(String[] args) {
	
		
		
		System.out.println("hello");
		
		
		
	}
	
	public static void selectionSort(int[] vals)
	{
		int indexMin;
		
		for ( int i = 0; i < vals.length - 1; i++)
		{
			indexMin = i;
			
			for ( int j = i + 1; j < vals.length; j++)
			{
				if ( vals[j] < vals[indexMin])
				{
					indexMin = j;
				}
			}
			
			swap (vals, indexMin, i);
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
	
	
	
//	public static boolean hasLetter(String word, char letter)
//		{
//			for (int i = 0; i < word.length(); i++) {
//			if (word.charAt(i) == letter)
//			{
//				return true;
//			}
//		}
//			return false;
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
