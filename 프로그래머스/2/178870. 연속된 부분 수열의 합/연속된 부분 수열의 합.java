class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int[] partSum = new int[sequence.length];
        for(int i=0; i<sequence.length; i++) {
            if(k==sequence[i]) {
                answer[0] = i;
                answer[1] = i;
                return answer;
            }
            
            if(i==0) partSum[i] = sequence[i];
            else partSum[i] = partSum[i-1]+sequence[i];
        }
        
        
        for(int i=0; i<sequence.length; i++) {
            if(partSum[i]==k) {
                answer[0] = 0;
                answer[1] = i;
                // return answer;
            }
        }   
        
        int start = 0;
        int end = 1;
        
        answer[0] = 0;
        answer[1] = (answer[1]==0) ? sequence.length-1 : answer[1];
        
        while(end<=sequence.length-1) {
            int sum = partSum[end]-partSum[start];
            
            // System.out.println("["+answer[0]+", "+answer[1]+"]");
            
            if(sum>=k) {
                if(sum==k&&(end-start-1)<(answer[1]-answer[0])) {
                    answer[0] = start+1;
                    answer[1] = end;
                }
                start++;
            } else {
                end++;
            }
        }
        
        return answer;
    }
    
}