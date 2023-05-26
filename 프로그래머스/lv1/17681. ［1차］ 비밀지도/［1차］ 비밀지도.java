class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for(int i=0; i<n; i++){
            String a = String.format("%0"+n+"d",Long.parseLong(Long.toBinaryString(arr1[i])));
            String b = String.format("%0"+n+"d",Long.parseLong(Long.toBinaryString(arr2[i])));
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j<n; j++){
                if(a.charAt(j) == '1' || b.charAt(j)=='1') sb.append("#");
                else sb.append(" ");
            }
            answer[i] = sb.toString();
            }
        return answer;
        
    }
}