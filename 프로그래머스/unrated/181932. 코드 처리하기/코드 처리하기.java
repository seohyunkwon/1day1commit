class Solution {
    public String solution(String code) {
    	int mode = 0;
    	String ret ="";
    	for(int i=0; i<code.length(); i++) {
    		char tmp = code.charAt(i);
    		if(mode == 0) {
    			if(tmp=='1') {
    				mode = 1;
    			} else if(i%2==0){
    				ret += tmp;
    			}
    		} else {
    			if(tmp=='1') {
    				mode = 0;
    			} else if(i%2==1) {
    				 ret += tmp;
    			}
    		}
    	}
        return ret.length()==0?"EMPTY":ret;
    }
}