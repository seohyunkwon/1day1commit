import java.util.Arrays;
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		 Scanner sc = new Scanner(System.in);
		 int T = sc.nextInt();
		 sc.nextLine();
		 for(int test_case=1; test_case<=T; test_case++) {
			 sc.nextLine();
			 int[] arr1 = Arrays.stream(sc.nextLine().split(" "))
					 .mapToInt(Integer::parseInt)
					 .toArray();
			 int[] arr2 = Arrays.stream(sc.nextLine().split(" "))
					 .mapToInt(Integer::parseInt)
					 .toArray();
			 long result = 0;
			 if(arr1.length>arr2.length) result = sumArr(arr2, arr1);
			 else result = sumArr(arr1, arr2);
			 System.out.printf("#%d %d\n", test_case, result);
		 }
	}
	
	public static long sumArr(int[] smaller, int[] bigger) {
		long max = Integer.MIN_VALUE;
		int idx = 0;
		while(idx<=bigger.length-smaller.length) {
			long sum = 0;
			for(int i=0; i<smaller.length; i++) {
				sum += bigger[idx+i]*smaller[i];
			}
			max = Math.max(sum, max);
			idx++;
		}	
		return max;
	}
}
