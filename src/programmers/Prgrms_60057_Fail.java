package programmers;

public class Prgrms_60057_Fail {
    /*
    "aabbaccc"	7
    "ababcdcdababcdcd"	9
    "abcabcdede" 10 	8
    "abcabcabcabcdededededede"	14
    "xababcdcdababcdcd"	17
     */

    public static int solution(String s) {
        int answer = s.length();

        // abcd abcd
        // abcd abcde
        // 1. 문자열 반 길이만큼만 생각. 어차피 반 넘으면 압축 못함
        // 2. 잘려가는 개수를 늘려가면서 반복숫자 + 문자 써줌
        for (int i = 1; i <= s.length() / 2; i++) {  // 1= <5
            String zip_str = s.substring(0, i); // 자를 문자열
            System.out.println("zip_str = " + zip_str);
            String result = "";
            int num = 1;
            for (int j = i; j <= s.length(); j += i) {
                String next = s.substring(j, Math.min(i + j, s.length()));
                if (zip_str.equals(next)) {
                    ++num;
                    System.out.println("num = " + num);
                } else {
                    String str = num > 1 ? Integer.toString(num) : "";
                    System.out.println("str = " + str);
                    result += str + zip_str;
                    System.out.println("result = " + result);
                    zip_str = next;
                    num = 1;
                }
            }
            result += zip_str;
            System.out.println("result = " + result);
            answer = Math.min(result.length(), answer);
            System.out.println("answer = " + answer);
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("ababcdcdababcdcd"));


    }
}
