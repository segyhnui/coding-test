package programmers.ing;

public class Prgrms_86051 {

    public static int solution(int[] numbers) {
        int answer = 0;
        boolean flag = true;
        for (int i = 1; i < 10; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (i == numbers[j]) {
                    flag = false;
                    break;
                } else {
                    flag = true;
                }
            }

            if (flag) {
                answer += i;
            }
        }

        return answer;
    }

    public static int solution2(int[] numbers) {
        int answer = 0;
        for (int i = 1; i < 10; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (i == numbers[j]) {
                    break;
                }
                if (j == numbers.length - 1) {
                    answer += i;
                }
            }
        }

        return answer;
    }

    // Tlqkf...
    public static int solution3(int[] numbers) {
        int sum = 45;
        for (int num : numbers) {
            sum -= num;
        }
        return sum;
    }



    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,6,7,8,0};
        System.out.println("sol = " + solution(numbers));
    }
}
