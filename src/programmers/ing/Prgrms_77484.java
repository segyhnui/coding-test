package programmers.ing;

import java.util.Arrays;

public class Prgrms_77484 {

//    [44, 1, 0, 0, 31, 25]	[31, 10, 45, 1, 6, 19]	[3, 5]
//    [0, 0, 0, 0, 0, 0]	[38, 19, 20, 40, 15, 25]	[1, 6]
//    [45, 4, 35, 20, 3, 9]	[20, 9, 3, 45, 4, 35]	[1, 1]

//    1. 내림차순으로 정렬부터 해본다. 44 31 25 1 0 0 / 45 31 19 10 6 1
//    2. 정답부터 하나하나 비교해간다.
//    3. 서로 숫자가 맞은 개수를 센다.
//    ---- 쓸데없는 정렬이 있다

//    1. 정답과 비교해간다.
//    2. 맞은 개수 + 0의 개수 만큼이 answer[1]이 된다.


    public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer;

        int zero = 0;
        int correct = 0;
        for (int lotto : lottos) {
            // 0 개수 찾기
            if (lotto == 0) {
                ++zero;
            }

            // 정답 비교
            for (int win_num : win_nums) {
                if (lotto == win_num) {
                    ++correct;
                }
            }
        }

        // 해당코드 바꿔보기
//        int max = lottos.length + 1 - correct - zero == 7 ? 6 : lottos.length + 1 - correct - zero;
//        int min = lottos.length + 1 - correct == 7 ? 6 : lottos.length + 1 - correct;

//        answer = new int[]{max, min};

        // 1 - 6, 2 - 5, 3 - 4,,, 6 - 1
        int maxCount = correct + zero;   // 최고득점: 맞은 개수 + 0 개수
        int minCount = correct;  // 최저득점: 맞은 개수

        answer = new int[]{Math.min(7 - maxCount, 6), Math.min(7 - minCount, 6)};

        return answer;
    }

    public static void main(String[] args) {
//        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] lottos = {0, 0, 0, 0, 0, 0};
        int[] win_nums = {31, 10, 45, 1, 6, 19};    //	[3, 5]
//    [0, 0, 0, 0, 0, 0]	[38, 19, 20, 40, 15, 25]	[1, 6]
//    [45, 4, 35, 20, 3, 9]	[20, 9, 3, 45, 4, 35]	[1, 1]

        System.out.println("solution(lottos, win_nums) = " + Arrays.toString(solution(lottos, win_nums)));
    }
}
