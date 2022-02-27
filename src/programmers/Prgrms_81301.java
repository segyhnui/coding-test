package programmers;

public class Prgrms_81301 {
//"one4seveneight"	1478
//"23four5six7"	234567
//"2three45sixseven"	234567
//"123"	123

//    1. 글자 하나하나 자를까 생각해봤다
//    2. 문자열 관련 함수 중 쓸만한거 생각해보다가 replace 생각남

    public int solution(String s) {
        s = s.replace("zero", "0");
        s = s.replace("one", "1");
        s = s.replace("two", "2");
        s = s.replace("three", "3");
        s = s.replace("four", "4");
        s = s.replace("five", "5");
        s = s.replace("six", "6");
        s = s.replace("seven", "7");
        s = s.replace("eight", "8");
        s = s.replace("nine", "9");

        return Integer.parseInt(s);
    }

    // 정답 후 바꿔보기
    public int solution2(String s) {
        String[] numArr = {
                "zero",
                "one",
                "two",
                "three",
                "four",
                "five",
                "six",
                "seven",
                "eight",
                "nine",
        };

        for (int i = 0; i < numArr.length; i++) {
            s = s.replace(numArr[i], Integer.toString(i));
        }

        return Integer.parseInt(s);
    }

    // 두개 다 뭐.. 차이없는거 같아 보인다
}
