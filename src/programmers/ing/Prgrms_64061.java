package programmers.ing;

import java.util.ArrayList;
import java.util.Stack;

public class Prgrms_64061 {
/*
    [0,0,0,0,0],
    [0,0,1,0,3],
    [0,2,5,0,1],
    [4,2,4,4,2],
    [3,5,1,3,1]

    [1,5,3,5,1,2,1,4]

    4 3 1 1
    4 3 3
    4 2 4

 */

    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        ArrayList bowl = new ArrayList();

        for (int i = 0; i < moves.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[j][moves[i] - 1] != 0) {
                    bowl.add(board[j][moves[i] - 1]);
                    board[j][moves[i] - 1] = 0;
                    break;
                }

                if (bowl.size() > 1) {
                    for (int k = 0; k < bowl.size() - 1; k++) {
                        if (bowl.get(k) == bowl.get(k + 1)) {
                            answer += 2;
                            bowl.remove(k + 1);
                            bowl.remove(k);
                        }
                    }
                }
            }
        }

        return answer;
    }

    // 정답 맞추고 다른 풀이 비교해보기
    // list가 아닌 stack
    public static int solution2(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> bowl = new Stack<>();

        for (int move : moves) {
            for (int j = 0; j < board.length; j++) {
                if (board[j][move - 1] != 0) {
                    if (bowl.isEmpty()) {
                        bowl.add(board[j][move - 1]);
                    } else {
                        if (bowl.peek() == board[j][move - 1]) {
                            bowl.pop();
                            answer += 2;
                        } else {
                            bowl.add(board[j][move - 1]);
                        }
                    }
                    board[j][move - 1] = 0;
                    break;
                }
            }
        }

        return answer;
    }



    public static void main(String[] args) {
        int[][] board = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 3},
                {0, 2, 5, 0, 1},
                {4, 2, 4, 4, 2},
                {3, 5, 1, 3, 1}
        };

        int[] moves = {1,5,3,5,1,2,1,4};

        System.out.println("solution(board, moves) = " + solution2(board, moves));

    }
}
