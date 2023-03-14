
class Solution {
	public String solution(String s) {
		char[] arr =s.toLowerCase().toCharArray();
		if(96<arr[0] && arr[0]<123) arr[0]-=32;
		for(int i=1; i<arr.length; i++) {
			if(arr[i-1]==' ' && 96<arr[i] && arr[i]<123) {
				arr[i]-=32;
			}
		}
		
		return String.copyValueOf(arr);
		
	}
}
