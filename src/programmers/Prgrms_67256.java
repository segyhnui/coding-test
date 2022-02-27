package programmers;

public class Prgrms_67256 {

//    [1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5]	"right"	"LRLLLRLLRRL"
//    [7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2]	"left"	"LRLLRRLLLRR"
//    [1, 2, 3, 4, 5, 6, 7, 8, 9, 0]	"right"	"LLRLLRLLRL"

    public static String solution(int[] numbers, String hand) {
        String answer = "";

        int xL = 3;
        int yL = 0;
        int xR = 3;
        int yR = 2;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 1) {
                answer += "L";
                xL = 0;
                yL = 0;
            } else if (numbers[i] == 4) {
                answer += "L";
                xL = 1;
                yL = 0;
            } else if (numbers[i] == 7) {
                answer += "L";
                xL = 2;
                yL = 0;
            } else if (numbers[i] == 3) {
                answer += "R";
                xR = 0;
                yR = 2;
            } else if (numbers[i] == 6) {
                answer += "R";
                xR = 1;
                yR = 2;
            } else if (numbers[i] == 9) {
                answer += "R";
                xR = 2;
                yR = 2;
            } else {
                if (numbers[i] == 2) {
                    int leftDistance = Math.abs(0 - xL) + Math.abs(1 - yL);
                    int rightDistance = Math.abs(0 - xR) + Math.abs(1 - yR);

                    if (leftDistance < rightDistance) {
                        xL = 0;
                        yL = 1;
                        answer += "L";
                    } else if (leftDistance > rightDistance) {
                        xR = 0;
                        yR = 1;
                        answer += "R";
                    } else {
                        if (hand.equals("left")) {
                            xL = 0;
                            yL = 1;
                            answer += "L";
                        } else {
                            xR = 0;
                            yR = 1;
                            answer += "R";
                        }
                    }
                } else if (numbers[i] == 5) {
                    int leftDistance = Math.abs(1 - xL) + Math.abs(1 - yL);
                    int rightDistance = Math.abs(1 - xR) + Math.abs(1 - yR);

                    if (leftDistance < rightDistance) {
                        xL = 1;
                        yL = 1;
                        answer += "L";
                    } else if (leftDistance > rightDistance) {
                        xR = 1;
                        yR = 1;
                        answer += "R";
                    } else {
                        if (hand.equals("left")) {
                            xL = 1;
                            yL = 1;
                            answer += "L";
                        } else {
                            xR = 1;
                            yR = 1;
                            answer += "R";
                        }
                    }
                } else if (numbers[i] == 8) {
                    int leftDistance = Math.abs(2 - xL) + Math.abs(1 - yL);
                    int rightDistance = Math.abs(2 - xR) + Math.abs(1 - yR);

                    if (leftDistance < rightDistance) {
                        xL = 2;
                        yL = 1;
                        answer += "L";
                    } else if (leftDistance > rightDistance) {
                        xR = 2;
                        yR = 1;
                        answer += "R";
                    } else {
                        if (hand.equals("left")) {
                            xL = 2;
                            yL = 1;
                            answer += "L";
                        } else {
                            xR = 2;
                            yR = 1;
                            answer += "R";
                        }
                    }
                } else if (numbers[i] == 0) {
                    int leftDistance = Math.abs(3 - xL) + Math.abs(1 - yL);
                    int rightDistance = Math.abs(3 - xR) + Math.abs(1 - yR);

                    if (leftDistance < rightDistance) {
                        xL = 3;
                        yL = 1;
                        answer += "L";
                    } else if (leftDistance > rightDistance) {
                        xR = 3;
                        yR = 1;
                        answer += "R";
                    } else {
                        if (hand.equals("left")) {
                            xL = 3;
                            yL = 1;
                            answer += "L";
                        } else {
                            xR = 3;
                            yR = 1;
                            answer += "R";
                        }
                    }
                }

            }
        }

        return answer;
    }

    // 정답 맞춘 후
    // 내가 했던 노가다를 식으로 풀어보자
    static int[][] number_pad = {
            {3, 1}, // 0
            {0, 0}, // 1
            {0, 1}, // 2
            {0, 2}, // 3
            {1, 0}, // 4
            {1, 1}, // 5
            {1, 2}, // 6
            {2, 0}, // 7
            {2, 1}, // 8
            {2, 2} // 9
    };

    public static String solution2(int[] numbers, String hand) {
        String answer = "";

        int[] left = {3, 0};    // *
        int[] right = {3, 2};   // #

        for (int number : numbers) {

            if (number == 1 || number == 4 || number == 7) {
                answer += "L";
                left = number_pad[number];
            } else if (number == 3 || number == 6 || number == 9) {
                answer += "R";
                right = number_pad[number];
            } else {
                String d = direction(number, left, right, hand);
                if ("L".equals(d)) {
                    answer += "L";
                    left = number_pad[number];
                } else {
                    answer += "R";
                    right = number_pad[number];
                }
            }

        }

        return answer;
    }

    // 거리 및 방향찾기
    public static String direction(int num, int[] left, int[] right, String hand) {
        int leftDistance = Math.abs(number_pad[num][0] - left[0]) + Math.abs(number_pad[num][1] - left[1]);
        int rightDistance = Math.abs(number_pad[num][0] - right[0]) + Math.abs(number_pad[num][1] - right[1]);

        if (leftDistance < rightDistance) {
            return "L";
        } else if (leftDistance > rightDistance) {
            return "R";
        } else {
            if (hand.equals("left")) {
                return "L";
            } else {
                return "R";
            }
        }
    }



    public static void main(String[] args) {
        int[] arr = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        String hand = "left";

        System.out.println("solution(arr) = " + solution(arr, hand));
    }

}
