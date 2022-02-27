package programmers.ing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Prgrms_42888 {

    /*
    ["Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"]
    ["Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."]
     */
    public static String[] solution(String[] record) {
        Map<String, String> user = new HashMap<>();

        for (String records : record) {
            if (records.startsWith("Enter") || records.startsWith("Change")) {
                String[] split_msg = records.split(" ");
                if (user.get(split_msg[1]) == null) {
                    user.put(split_msg[1], split_msg[2]);
                } else {
                    if (!user.get(split_msg[1]).equals(split_msg[2])) {
                        user.put(split_msg[1], split_msg[2]);
                    }
                }
            }
        }

        List<String> ans = new ArrayList<>();
        for (String records : record) {
            String[] split_msg = records.split(" ");
            if (split_msg[0].startsWith("Enter")) {
                String msg = user.get(split_msg[1]) + "님이 들어왔습니다.";
                ans.add(msg);
            }
            if (split_msg[0].startsWith("Leave")) {
                String msg = user.get(split_msg[1]) + "님이 나갔습니다.";
                ans.add(msg);
            }
        }

        String[] answer = new String[ans.size()];
        int idx = 0;
        for (String s : ans) {
            answer[idx++] = s;
        }

        return answer;
    }

    // 정답 풀고 나서 스트림으로 리팩토링
    private static final String FORMAT_ENTER_MESSAGE = "%s님이 들어왔습니다.";
    private static final String FORMAT_LEAVE_MESSAGE = "%s님이 나갔습니다.";

    public static String[] solution2(String[] record) {
        Map<String, String> userMap = new HashMap<>();

        // userId가 바뀌는 경우(Enter, Change) 찾아서 넣어줌
        Stream.of(record)
                .filter(o -> o.startsWith("Enter") || o.startsWith("Change"))
                .forEach(o -> createOrUpdateUser(userMap, o));

        return Stream.of(record)
                .map(msg -> getFormattedMsg(userMap, msg))
                .filter(msg -> !"".equals(msg))
                .toArray(String[]::new);
    }

    // userMap에 등록
    static String createOrUpdateUser(Map<String, String> userMap, String msg) {
        String userId = msg.split(" ")[1];
        String name = msg.split(" ")[2];
        userMap.put(userId, name);
        return "A";
    }

    // msg 출력
    static String getFormattedMsg(Map<String, String> userMap, String msg) {
        String userId = msg.split(" ")[1];
        switch (msg.split(" ")[0]) {
            case "Enter":
                return String.format(FORMAT_ENTER_MESSAGE, userMap.get(userId));
            case "Leave":
                return String.format(FORMAT_LEAVE_MESSAGE, userMap.get(userId));
            default:
                return "";
        }
    }


    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};
        String[] solution = solution(record);
        for (String s : solution) {
            System.out.println("s = " + s);
        }
    }

}
