import java.util.*;
import java.io.*;

class Solution {
    
    static long firstQueueSum;
    static long secondQueueSum;

    static int length;
    static int result;
    
    static Queue<Integer> firstQueue;
    static Queue<Integer> secondQueue;
    
    public int solution(int[] queue1, int[] queue2) {
        firstQueueSum = 0; // 첫번째 큐 요소의 합
        secondQueueSum = 0; // 두번째 큐 요소의 합 
        
        length = queue1.length; // 배열의 길이

        firstQueue = new LinkedList<>();
        secondQueue = new LinkedList<>();
        
        for(int i=0; i<length; i++) {
            int ele1 = queue1[i];
            int ele2 = queue2[i];
            
            // 합 갱신
            firstQueueSum += ele1;
            secondQueueSum += ele2;
            
            // 배열 -> 큐로 옮기기
            firstQueue.offer(ele1);
            secondQueue.offer(ele2);
        }
        
        // 만약 합이 홀수라면 -> 같은 합 맞출 수 x (바로 -1 리턴)
        if((firstQueueSum + secondQueueSum)%2!=0) return -1;
        
        result = 0;
        
        for(int i=0; i<length*3; i++) {
            
            if(firstQueue.isEmpty()||secondQueue.isEmpty()) return -1;
            
            if(firstQueueSum > secondQueueSum) popAndPush(true);
            else if(firstQueueSum < secondQueueSum) popAndPush(false);
            else return result;
            
            result++;
        }
        
        return -1;
    }
    
    // 한 큐에서 다른 큐로 pop -> insert 하는 함수 
    public void popAndPush(boolean isPopFirstQueue) {
        
        if(isPopFirstQueue) {
            // 1-1. 첫번째 큐에서 pop
            int popEle = firstQueue.poll();
            // 1-2. 첫번째 큐의 합 갱신 (기존 합 - pop한 요소값)
            firstQueueSum -= popEle;
            
            // 2-1. 두번째 큐에 offer 
            secondQueue.offer(popEle);
            // 2-2. 두번째 큐의 합 갱신 (기존 합 + offer한 요소값)
            secondQueueSum += popEle;
        } else {
            int popEle = secondQueue.poll();
            secondQueueSum -= popEle;
            firstQueue.offer(popEle);
            firstQueueSum += popEle;
        }
    }
}