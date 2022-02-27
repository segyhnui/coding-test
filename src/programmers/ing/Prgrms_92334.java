package programmers.ing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 코딩테스트 연습
 * 2022 KAKAO BLIND RECRUITMENT
 * 신고 결과 받기
 */
public class Prgrms_92334 {

// ["muzi", "frodo", "apeach", "neo"]
// ["muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"]
    // muzi frodo, muzi neo
    // apeach frodo, apeach muzi
    // frodo neo
    // neo
// k 2
// [2,1,1,0]

    public int[] solution2(String[] id_list, String[] report, int k) {
        int[] ans = new int[id_list.length];
        Map<String, Integer> ansMap = new HashMap<>(); // 내가 신고당한 횟수
        Map<String, Set<String>> reportedMap = new HashMap<>(); // 신고이력 담긴. 신고자, 신고한사람

        for (String s : id_list) {
            ansMap.put(s, 0);
            reportedMap.put(s, new HashSet<>());
        }

        for (String s : report) {
            String[] report_content = s.split(" ");
            String reporter = report_content[0];
            String reported = report_content[1];

            if (reportedMap.get(reporter).add(reported)) {
                int count = ansMap.get(reported);
                ansMap.put(reported, ++count);
            }
        }

        for (String s : report) {
            String[] report_content = s.split(" ");
            String reporter = report_content[0];
            String reported = report_content[1];

            if (ansMap.get(reported) < k) {
                reportedMap.get(reporter).remove(reported);    // 어차피 없으면 안지워진다
            }
        }

        for (int i = 0; i < id_list.length; i++) {
            ans[i] = reportedMap.get(id_list[i]).size();
        }

        return ans;
    }


}
