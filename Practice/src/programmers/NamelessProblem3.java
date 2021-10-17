package programmers;

import java.util.ArrayList;
import java.util.List;

public class NamelessProblem3 {
	public static void main(String[] args) {
		Solution6 sol = new Solution6();
		String skill1 = "CBD";
		String[] skill_trees1 = { "BACDE", "CBADF", "AECB", "BDA" };
		System.out.println(sol.solution(skill1, skill_trees1));
	}
}

class Solution6 {
	public int solution(String skill, String[] skill_trees) {
		int answer = 0; // 가능한 개수
		List<Integer> list = new ArrayList<Integer>(); // 해당 스킬의 인덱스 추가
		boolean flag;
		boolean skilllearn = true; //스킬을 배웠는지 여부
		for (String skill_tree : skill_trees) {
			flag = true;
			for (int i = 0; i < skill.length(); i++) {
				skilllearn = false;
				for (int j = 0; j < skill_tree.length(); j++) {
					if (skill.charAt(i) == skill_tree.charAt(j)) {
						skilllearn = true;
						list.add(j);
						System.out.println(list.toString());
						if (list.size() > 1) {
							for (int idx = 0; idx < list.size() - 1; idx++) {
								if (list.get(idx) > list.get(idx + 1)) {
									flag = false;
									break;
								}
							}
						}
					}
					if (!flag)
						break;
				}
				if (!flag)
					break;
			}
			System.out.println(flag);
			if (flag && skilllearn) {
				answer++;
			}
			list.clear();

		}
		return answer;
	}
}