class Solution {
    public String solution(String s) {
        char[] arr =s.toCharArray();
        int j=0;
        for(int i=0; i<arr.length; i++){ 
            if(arr[i]==' ') {j=0; continue;}
            else if(j%2==0 && 'a'<=arr[i] && arr[i]<='z') arr[i]-=32;
            else if(j%2!=0 && 'A'<=arr[i] && arr[i]<='Z') arr[i]+=32;
            j++;
            
        }
        return String.valueOf(arr);
    }
}