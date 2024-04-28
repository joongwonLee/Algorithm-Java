class Solution {
    
    static int answer;
    
    public int solution(int[] numbers, int target) {
        answer = 0;
        powerSet(numbers, target, 0, 0);
        
        return answer;
    }
    
    public static void powerSet(int[] numbers, int target, int idx, int value) {
        
        if(idx == numbers.length) {
            if(value == target) answer++;
            
            return;
        }
        
        powerSet(numbers, target, idx+1, value+numbers[idx]);
        powerSet(numbers, target, idx+1, value-numbers[idx]);
    }
}