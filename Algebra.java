// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));

		System.out.println("Let's chek negative");
		System.out.println(plus(2,-3));   // -1
	    System.out.println(minus(-7,-2));  // -5
   		System.out.println(minus(2,-7));  // 9
 		System.out.println(times(3,-4)); //-12

		System.out.println("Let's chek sqrt");
		System.out.println(sqrt(1)); //1
		System.out.println(sqrt(0)); //0
		System.out.println(sqrt(10000)); //100
		System.out.println(sqrt(76123)); //275
		
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		
		
		if (x2>=0)
		{
			for (int i=0;i<x2; i++)
			{
				x1++;
			}
		} else
		{
			for (int j=x2; j<0; j++)
			{
				x1--;
			}
		}
		return x1;
		
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		
		if (x2>=0)
		{
			for (int i=0; i<x2; i++)
			{
				x1--;
			}
		} else
		{
			for (int j=x2; j<0; j++)
			{
				x1++;
			}
		}
		return x1;

	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		
		int Ans = 0;
		int natural = x2;
		if (x2<0)
		{
			natural = minus(0, x2);
		}
		
		for (int i=0; i<natural; i++)
		{
			Ans=plus(Ans, x1);
		}

		if ((x2<0 && x1>0))
		{
			Ans = minus(0, Ans);
		}
		
		return Ans;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {

		int Ans = 1;
		if (n<0 || x==0) 
		{
		Ans = 0;
		} else
		{
		for (int i=0; i<n; i++)
		{
			Ans =times(Ans, x);
		}
		}
		return Ans;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		
		int count = 0;
		int Ans = 0;
		int Nat1 = x1;
		int Nat2 = x2;
		if (x1<0)
		{
			Nat1 = minus(0, x1) ;
		}
		if (x2<0)
		{
			Nat2 = minus(0, x2) ;
		}
		while (minus(Nat1, Ans)>=Nat2)
		{
			Ans=plus(Ans, Nat2);
			count++;

		}

		if ((x1<0 && x2>0) || (x1>0 && x2<0))
		{
			count = minus(0, count);
		}
		return count;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		
		int Ans = minus(x1, (times(div(x1, x2), x2))) ;
		return Ans;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {

		int num = 0;
		while (pow(num, 2)<=x)
		{
			num++;
		}

		
		return num-1;
	}	  	  
}