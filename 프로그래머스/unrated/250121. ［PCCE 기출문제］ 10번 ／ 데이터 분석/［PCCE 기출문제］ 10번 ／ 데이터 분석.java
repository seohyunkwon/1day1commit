import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int[][] answer = {};
        List<Data> list = new ArrayList<>();
        for(int i=0; i<data.length; i++){
            if(ext.equals("code")){
                if(data[i][0]>= val_ext) continue;
            }
            if(ext.equals("date")){
                if(data[i][1]>= val_ext) continue;
            }
            if(ext.equals("maximum")){
                if(data[i][2]>= val_ext) continue;
            }
            if(ext.equals("remain")){
                if(data[i][3]>= val_ext) continue;
            }
            list.add(new Data(data[i][0], data[i][1], data[i][2], data[i][3]));
        }
        return list.stream().sorted(new Comparator<Data>() {
            @Override
            public int compare(Data d1, Data d2) {
                if(sort_by.equals("code")){
                    return d1.code-d2.code;
                }
                if(sort_by.equals("date")){
                    return d1.date-d2.date;
                }
                if(sort_by.equals("maximum")){
                    return d1.maximum-d2.maximum;
                }
                return d1.remain-d2.remain;
            }
        }).map(d -> d.toArray())
                .toArray(int[][]::new);
    }
}

class Data {
    int code;
    int date;
    int maximum;
    int remain;
    Data(int code, int date, int maximum, int remain){
        this.code = code;
        this.date = date;
        this.maximum = maximum;
        this.remain = remain;
    }

    public int[] toArray(){
        return new int[]{code, date, maximum, remain};
    }
}