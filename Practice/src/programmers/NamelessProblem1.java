package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NamelessProblem1 {
	public static void main(String[] args) {
		
		Solution4 sol = new Solution4();
		
		int[] A1 = {1, 4, 2};
		int[] B1 = {5, 4, 4};
		
		int[] A2 = {1,2};
		int[] B2 = {3,4};
		
		System.out.println(sol.solution(A1, B1));
		System.out.println(sol.solution(A2, B2));
		
	}
}
class Solution4
{
    public int solution(int []A, int []B)
    {
        int answer = 0;

        List<Integer> alist = new ArrayList<Integer>();
        List<Integer> blist = new ArrayList<Integer>();
        
        for(int i=0;i<A.length;i++) {
        	alist.add(A[i]);
        	blist.add(B[i]);
        } // 배열 리스트화
        Collections.sort(alist,Collections.reverseOrder()); // 역순정렬
        Collections.sort(blist); // 순차정렬
        for(int i=0;i<A.length;i++) {
        	answer += alist.get(i)*blist.get(i);
        } 
        
        return answer;
    }
}
