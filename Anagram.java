/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		
		String New1 = preProcess(str1);
		String New2 = preProcess(str2);
		boolean Ans = true;
		int count1 = 0;
		int count2 = 0;
		int num1 = 0;
		if (New1.length() != New2.length())
		{
			return false;
		} else
		{
			for (int i=0; i<New1.length(); i++)
			{
				for (int j=i; j<New1.length(); j++)
				{
					 if (New1.indexOf(i,j) != -1)
					 {
						count1++;
						j = New1.indexOf(i,j);
					 } else break;
				}
				for (int k=i; k<New2.length(); k++)
				{
					 if (New2.indexOf(i,k) != -1)
					 {
						count2++;
						k = New2.indexOf(i,k);
					 } else break;
				}

				if (count1 != count2)
				{
					Ans = false;
					break;
				} else
				{
					count1 = 0;
					count2 = 0;
				}

			}
		} 


		return Ans;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String Up = str;
		String Newstring = "";
		
		for (int i=0; i<Up.length(); i++)
		{
			
			if (Up.charAt(i) >= 'a' && Up.charAt(i) <= 'z')
			{
				Newstring = Newstring + Up.charAt(i);
			} else if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z')
			{
				
				Newstring = Newstring + (char)(Up.charAt(i)+32);
			} 
			
			}
			
			return Newstring;
		}
		
	
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		
		String Ans ="";
		String New1 = "";
		int num;

		while (str.length()>0)
		{
			num = (int) (Math.random()* (str.length()));
			Ans = Ans +str.charAt(num);
			for (int i=0; i<str.length();i++)
			{
				if (i != num)
				{
					New1 = New1 + str.charAt(i);
				}
				
			}
			str = New1;
			New1 = "";
		}

		return Ans;
	}
}
