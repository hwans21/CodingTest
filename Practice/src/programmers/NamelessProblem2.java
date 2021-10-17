package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NamelessProblem2 {
	public static void main(String[] args) {
		Solution5 sol = new Solution5();
		String[][] places = { { "POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP" },
				{ "POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP" }, { "PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX" },
				{ "OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO" }, { "PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP" } };
		System.out.println(Arrays.toString(sol.solution(places)));
	}
}

class Solution5 {
	public int[] solution(String[][] places) {
		int[] answer = new int[5];
		List<Integer> list = new ArrayList<Integer>();
		boolean flag;
		for (int i = 0; i < 5; i++) {
			flag = true;
			System.out.println("------" + (i + 1) + "번째 방-------");
			for (int x = 0; x < 5; x++) {
				for (int y = 0; y < 5; y++) {
					System.out.printf("검사 좌표 : [%d, %d]\n", x, y);
					if (places[i][x].charAt(y) == 'P') { // 해당자리에 사람이 앉았을 경우 자리두기 검사
						// 바로 앉는 경우
						if (!(x + 1 > 4)) {
							if (places[i][x + 1].charAt(y) == 'P') {
								flag = false;
							}
						}
						if (!(y + 1 > 4)) {

							if (places[i][x].charAt(y + 1) == 'P') {
								flag = false;
							}
						}
						// 2x2 (우하단)
						if (!(x + 1 > 4) && !(y + 1 > 4)) {
							if (places[i][x + 1].charAt(y + 1) == 'P') {
								if (!(x + 1 > 4)) {
									if (places[i][x + 1].charAt(y) == 'O') {
										flag = false;
									}
								}
								if (!(y + 1 > 4)) {
									if (places[i][x].charAt(y + 1) == 'O') {
										flag = false;
									}
								}
							}
						}
						// 2x2 (좌하단)
						if (!(x + 1 > 4) && !(y - 1 < 0)) {
							if (places[i][x + 1].charAt(y - 1) == 'P') {
								if (!(x + 1 > 4)) {
									if (places[i][x + 1].charAt(y) == 'O') {
										flag = false;
									}
								}
								if (!(y - 1 < 0)) {
									if (places[i][x].charAt(y - 1) == 'O') {
										flag = false;
									}
								}
							}
						}
						// 3x1
						if (!(x + 2 > 4)) { // 인덱스 넘어가는 경우 제외
							if (places[i][x + 2].charAt(y) == 'P') {
								if (places[i][x + 1].charAt(y) == 'O') {
									flag = false;
								}
							}
						}
						// 1x3
						if (!(y + 2 > 4)) { // 인덱스 넘어가는 경우 제외
							if (places[i][x].charAt(y + 2) == 'P') {
								if (places[i][x].charAt(y + 1) == 'O') {
									flag = false;
								}

							}
						}

						// 한번이라도 걸렸으면 반복문 종료
						if (!flag)
							break;

					}

				}
				// 한번이라도 걸렸으면 반복문 종료
				if (!flag)
					break;
			}
			if (flag)
				list.add(1);
			else
				list.add(0);
		}
		for (int i = 0; i < 5; i++) {
			answer[i] = list.get(i);
		}
		return answer;
	}
}