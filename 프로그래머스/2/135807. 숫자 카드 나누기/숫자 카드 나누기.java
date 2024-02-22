class Solution {
    
    static int length;
    
    static int[] arrA, arrB;
    
    static int minOfArrayA, maxOfArrayA;
    static int minOfArrayB, maxOfArrayB;
    
    public int solution(int[] arrayA, int[] arrayB) {
        
        length = arrayA.length;
        
        arrA = arrayA; arrB = arrayB;
        
        minOfArrayA = 100000001; 
        minOfArrayB = 100000001;
        
        for(int i=0; i<length; i++) {
            minOfArrayA = Math.min(minOfArrayA, arrayA[i]);
            minOfArrayB = Math.min(minOfArrayB, arrayB[i]);
        }
        
        return Math.max(cardGame(true), cardGame(false));
        
        // if(cardGame(true)==0) return cardGame(false);
        // else return cardGame(true);
    }
    
    public int cardGame(boolean isArrayA) {
        
        if(isArrayA) {
            
            loopA:
            for(int i=minOfArrayA; i>=2; i--) {
                
                int numOfFlag = 0;
                
                for(int j=0; j<length; j++) {
                    if(arrA[j]%i==0 && arrB[j]%i!=0) continue;
                    else continue loopA;
                }
                
                return i;
            }
        } else {
            
            loopB:
            for(int i=minOfArrayB; i>=2; i--) {
                
                for(int j=0; j<length; j++) {
                    if(arrB[j]%i==0 && arrA[j]%i!=0) continue;  
                    else continue loopB;
                }
                
                return i;
            }
        }
        
        return 0;
    }
}