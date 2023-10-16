class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[][] arr = new int[park.length][park[0].length()];
        boolean[][] visited = new boolean[park.length][park[0].length()];
        int[] idx = new int[2];
        for(int i=0; i<park.length; i++){
            for(int j=0; j<park[i].length(); j++){
                char c = park[i].charAt(j);
                if(c=='X') {
                    arr[i][j] = -1;
                } else if(c=='S') {
                    idx[0] = i; idx[1] = j;
                }
            }
        }
        
        for(int i=0; i<routes.length; i++){
            String[] tmp = routes[i].split(" ");
            int[] prev = {idx[0], idx[1]};
            boolean flag = false;
            switch(tmp[0]){
                case "W" :
                    if(idx[1]-Integer.parseInt(tmp[1])<0) break;
                    if(arr[idx[0]][idx[1]-Integer.parseInt(tmp[1])]==-1) break;
                    while(Integer.parseInt(tmp[1])>0){
                        if(arr[idx[0]][idx[1]--] == -1 || idx[1]<0) {
                            flag = true;
                            break;
                        }
                        tmp[1] = Integer.parseInt(tmp[1])-1+"";
                    }
                    if(flag) idx[1] = prev[1];
                    break;
                case "E" :
                    if(idx[1]+Integer.parseInt(tmp[1])>=arr[0].length) 
                        break;
                    if(arr[idx[0]][idx[1]+Integer.parseInt(tmp[1])]==-1) break;
                    while(Integer.parseInt(tmp[1])>0){
                        if(arr[idx[0]][idx[1]++] == -1 || idx[1]>arr[0].length-1) {
                            flag = true;
                            break;
                        }
                        tmp[1] = Integer.parseInt(tmp[1])-1+"";
                    }
                    if(flag) idx[1] = prev[1];
                    break;
                case "S" :
                    if(idx[0]+Integer.parseInt(tmp[1])>=arr.length) break;
                    if(arr[idx[0]+Integer.parseInt(tmp[1])][idx[1]]==-1) break;
                    while(Integer.parseInt(tmp[1])>0){
                        if(arr[idx[0]++][idx[1]] == -1 || idx[0]>arr.length-1) {
                            flag = true;
                            break;
                        }
                        tmp[1] = Integer.parseInt(tmp[1])-1+"";
                    }
                    if(flag) idx[0] = prev[0];
                    break;
                case "N" :
                    if(idx[0]-Integer.parseInt(tmp[1])<0) break;
                    if(arr[idx[0]-Integer.parseInt(tmp[1])][idx[1]]==-1) break;
                    while(Integer.parseInt(tmp[1])>0){
                        if(arr[idx[0]--][idx[1]] == -1 || 0>idx[0]) {
                            flag = true;
                            break;
                        }
                        tmp[1] = Integer.parseInt(tmp[1])-1+"";
                    }
                    if(flag) idx[0] = prev[0];
                    break;
            }
        }
        
        return idx;
    }
}