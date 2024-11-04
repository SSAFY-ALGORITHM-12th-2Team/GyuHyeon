import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        
        long total=0,sum1=0, sum2=0;
        Queue<Integer>q1=new ArrayDeque<>();
        Queue<Integer>q2=new ArrayDeque<>();
        List<Integer>list=new ArrayList<>();
        
        for(int i:queue1){
            list.add(i);
            total+=i;
            q1.offer(i);
            sum1+=i;
        }
        for(int i:queue2){
            list.add(i);
            total+=i;
            q2.offer(i);
            sum2+=i;
        }
        long half=total/2;//맞춰야하는 수
        
        Collections.sort(list);
        long check=0;
        for(int i=0;i<list.size()-1;i++){
            check+=list.get(i);
        }
        System.out.println(check);
        if(check<list.get(list.size()-1)){
            return -1;
        } else{
            for(int i=0;i<=queue1.length+queue2.length*2;i++){
                if(sum1>sum2){
                    int p=q1.poll();
                    q2.offer(p);
                    sum1-=p;
                    sum2+=p;
                    answer++;
                } else if(sum1==sum2){
                    return answer;
                } else if(sum1<sum2){
                    int p=q2.poll();
                    q1.offer(p);
                    sum2-=p;
                    sum1+=p;
                    answer++;
                }
            }
            return -1;
        }
    }
}