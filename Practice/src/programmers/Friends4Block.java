package programmers;

import java.util.ArrayList;
import java.util.List;

public class Friends4Block {
	public static void main(String[] args) {
		Solution3 sol = new Solution3();
		int m1 = 4;
		int n1 = 5;
		String[] board1 = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
		
		int m2 = 6;
		int n2 = 6;
		String[] board2 = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
		
		int m3 = 7;
		int n3 = 2;
		String[] board3 = {"AA", "BB", "AA", "BB", "ZZ", "ZZ", "CC"};
		
		int m4 = 6;
		int n4 = 5;
		String[] board4 = {
		"CCZXZ",
		"CCZXZ",
		"XXZXZ",
		"AAZAA",
		"AAAAA",
		"ZAAXX"};
		System.out.println("#######테스트 1######");
		System.out.println(sol.solution(m1,n1,board1));
		System.out.println("#######테스트 2######");
		System.out.println(sol.solution(m2,n2,board2));
		System.out.println("#######테스트 3######");
		System.out.println(sol.solution(m3,n3,board3));
		System.out.println("#######테스트 4######");
		System.out.println(sol.solution(m4,n4,board4));
	}
	
}
class Solution3 {
    public int solution(int m, int n, String[] board) {
        int answer = 0;  // 지운 블록 수
        
        List<Coord> list = delCoord(board);
        StringBuilder builder;
        StringBuilder checkbuilder;
        boolean flag;
        showBoard(board);
        while(true) {
        	list = delCoord(board);
        	if(list.size() == 0) break;
        	for(Coord coord : list) {
        		if(board[coord.getX()].charAt(coord.getY()) == '0') continue;
        		builder = new StringBuilder(board[coord.getX()]);
        		builder.setCharAt(coord.getY(), '0');
        		board[coord.getX()] = builder.toString();
        		answer++;
        	} // 삭제 좌표 삭제 완료
        	
        	for(int i=0;i<m-1; i++) {
        		flag = true;
        		for(int j=0;j<n;j++) {
        			if(board[i].charAt(j) != '0') {
        				if(board[i+1].charAt(j) == '0') {
        					builder = new StringBuilder(board[i]);
        					checkbuilder = new StringBuilder(board[i+1]);
        					builder.setCharAt(j, '0');
        					checkbuilder.setCharAt(j, board[i].charAt(j));
        					board[i] = builder.toString();
        					board[i+1] = checkbuilder.toString();
        					flag = false;
        				}
        			}
        			
        		}
        		if(!flag) {
        			if(i>0) i-=2;
        		}
        	} // 삭제 후 아래로 내리기
        	
        	showBoard(board);
        }
        
        
        return answer;
    }
    public List<Coord> delCoord(String[] board){
    	List<Coord> list = new ArrayList<>();
    	for(int i=0;i<board.length-1;i++) {
    		for(int j=0;j<board[i].length()-1;j++) {
    			if(board[i].charAt(j) == '0') continue;
    			if(board[i].charAt(j) == board[i].charAt(j+1)) {
    				if(board[i].charAt(j) == board[i+1].charAt(j) && board[i].charAt(j) == board[i+1].charAt(j+1)) {
    					// 2x2 되어있는 부분 찾음
    					list.add(new Coord(i,j));
    					list.add(new Coord(i,j+1));
    					list.add(new Coord(i+1,j));
    					list.add(new Coord(i+1,j+1)); // 삭제할 좌표 추가
    				}
    			}
    		}
    	}
    	return list;
    }
    public void showBoard(String[] board) {
    	System.out.println("-----------------");
    	for(String str: board) {
    		System.out.println(str);
    	}
    	System.out.println("-----------------");
    }
}
class Coord{
	private int x;
	private int y;
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	@Override
	public String toString() {
		return "[" + x + ", " + y + "]";
	}
	public Coord(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	
}