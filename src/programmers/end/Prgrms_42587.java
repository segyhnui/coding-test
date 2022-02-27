package programmers.end;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Prgrms_42587 {

    static class Task {
        int location;
        int priority;

        public Task(int location, int priority) {
            this.location = location;
            this.priority = priority;
        }
    }

    public static int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Task> queue = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            queue.add(new Task(i, priorities[i]));
        }

        int count = 1;
        while (!queue.isEmpty()) {
            Task poll = queue.poll();
            boolean moving = false;

            for (Task task : queue) {
                if (task.priority > poll.priority) {
                    moving = true;
                }
            }

            if (moving) {
                queue.add(poll);
            }
            // 정렬 완성
            else {
                if (location == poll.location) {
                    answer = count;
                    break;
                }
                ++count;
            }
        }

        return answer;
    }

    // 정답맞추고 리팩토링
    // 기존소스는 while 안에 for문이 있어 복잡도가 높다
    // 반복문을 하나로 줄여보자
    public static int solution2(int[] priorities, int location) {
        // 움직인 횟수
        int answer = 0;
        // 정렬을 하면서 location idx의 값이 어디로 갈지 생각한다

        Queue<Integer> queue = new LinkedList<>();

        // 이동이 있는 Queue 생성
        for (int priority : priorities) {
            queue.add(priority);
        }
        // 우선순위 소팅을 시킨다
        Arrays.sort(priorities);

        // pritorities 배열에 큰 값부터 접근하기 위해 초기화를 해준다
        int size = priorities.length - 1;

        // 우선순위 큰 것과 비교하면서 location, answer 변화를 준다
        while (!queue.isEmpty()) {
            int poll = queue.poll();

            // 최대값을 비교해가면서 location의 idx에 있는 값의 위치를 알아본다
            if (poll == priorities[size - answer]) {
                ++answer;
                // poll했으니까 location--
                --location;

                if (location < 0) {
                    break;
                }

            }
            // 내가 찾는 숫자가 아직 우선순위에 해당안될때
            else {
                queue.add(poll);

                // poll했으니까 location--
                --location;

                // 내가 찾는 숫자가 다시 큐의 맨 끝에 들어가니까 위치 재설정
                if (location < 0) {
                    location = queue.size() - 1;
                }
            }

        }

        return answer;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 2};
        int[] arr2 = {1, 1, 9, 1, 1, 1};
        int[] arr3 = {1, 3, 8, 5, 7, 4, 9};
        System.out.println("solution3(arr3, 2) = " + solution2(arr3, 2));
    }


}
