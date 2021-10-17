package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoRank {
	public static void main(String[] args) {
		Solution2 sol = new Solution2();
		int[] lottos = { 44, 1, 0, 0, 31, 25 };
		int[] win_nums = { 31, 10, 45, 1, 6, 19 };
		System.out.println(Arrays.toString(sol.solution(lottos, win_nums)));

	}
}

class Solution2 {
	public int[] solution(int[] lottos, int[] win_nums) {

		int[] answer = { 0, 0 };
		int rCount = 0;
		int tCount = 0;
		List<Integer> win_list = new ArrayList<Integer>();
		for(int i=0;i<win_nums.length;i++) {
			win_list.add(win_nums[i]);
		}
		for (int i = 0; i < lottos.length; i++) {
			if (win_list.contains(lottos[i])) {
				rCount++;
			} else if (lottos[i] == 0) {
				tCount++;
			}
		}
		answer[0] = rank(rCount+tCount);
		answer[1] = rank(rCount);
		

		return answer;
	}

	public int rank(int count) {
		int rank = 6;
		switch (count) {
		case 6:
			rank = 1;
			break;
		case 5:
			rank = 2;
			break;
		case 4:
			rank = 3;
			break;
		case 3:
			rank = 4;
			break;
		case 2:
			rank = 5;
			break;
		
		}
		return rank;
	}
}