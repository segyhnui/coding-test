package programmers.ing;

/**
 * 코딩테스트 연습
 * 2021 KAKAO BLIND RECRUITMENT
 * 신규 아이디 추천
 */
public class Prgrms_72410 {

    public static String solution(String new_id) {
        // step1
        new_id = new_id.toLowerCase();

        // step2
        String modify_id = "";
        for (int i = 0; i < new_id.length(); i++) {
            char ch = new_id.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                modify_id += ch;
            } else if (ch >= '0' && ch <= '9') {
                modify_id += ch;
            } else if (ch == '-' || ch == '_' || ch == '.') {
                modify_id += ch;
            }
        }
        new_id = modify_id;

        // step3
        // 이건좀 야매
//        while (true) {
//            String change_Id = new_id.replace("..", ".");
//            if (!change_Id.equals(new_id)) {
//                new_id = change_Id;
//            } else {
//                break;
//            }
//        }
        while (new_id.contains("..")) {
            new_id = new_id.replace("..", ".");
        }

        // step4
        if (new_id.startsWith(".")) {
            new_id = new_id.substring(1);
        } else if (new_id.endsWith(".")) {
            new_id = new_id.substring(0, new_id.length() - 1);
        }

        // step5
        if (new_id.length() == 0) {
            new_id += "a";
        }

        // step7
        if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
        }

        // step7
        if (new_id.endsWith(".")) {
            new_id = new_id.substring(0, new_id.length() - 1);
        }

        // step7
        while (new_id.length() <= 2) {
            char c = new_id.charAt(new_id.length() - 1);
            new_id += c;
        }

        return new_id;
    }

    public static void main(String[] args) {
//        String id = "=.=";
        String id = "...!@BaT#*..y.abcdefghijklm";

        System.out.println(solution(id));

        String a = null;
        System.out.print(a.equalsIgnoreCase(null));

    }

}
