class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        int[] left = {3, 0};
        int[] right = {3, 2};
        int[][] idx = {{3,1}, {0,0}, {0,1}, {0,2}, {1,0},
                       {1,1}, {1,2}, {2,0}, {2,1}, {2,2}};
        for(int i=0; i<numbers.length; i++){
            switch(numbers[i]){
                case 1 : case 4 : case 7 :
                    sb.append("L");
                    left = idx[numbers[i]];
                    break;
                case 3 : case 6 : case 9 :
                    sb.append("R");
                    right = idx[numbers[i]];
                    break;
                case 2 : case 5 : case 8 : case 0 :
                    int[] tmp = idx[numbers[i]];
                    int lenL = Math.abs(tmp[0]-left[0])+Math.abs(tmp[1]-left[1]);
                    int lenR = Math.abs(tmp[0]-right[0])+Math.abs(tmp[1]-right[1]);
                    if(lenL<lenR || (lenL==lenR&&hand.equals("left"))){
                        sb.append("L");
                        left = tmp;
                    } else if(lenL>lenR || (lenL==lenR&&hand.equals("right"))){
                        sb.append("R");
                        right = tmp;
                    }
                    break;
            }
        }
        return sb.toString();
    }
}