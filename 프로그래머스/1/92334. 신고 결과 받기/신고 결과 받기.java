import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        // id -> 결과 배열 인덱스
        Map<String, Integer>idx = new HashMap<>();
        for(int i=0; i<id_list.length; i++) { 
            idx.put(id_list[i], i);
        }
        
        // 신고당한 유저 -> 신고한 유저 집합 (Set으로 중복 신고 자동 제거)
        Map<String, Set<String>> reporters = new HashMap<>();
        for(String r : new HashSet<>(Arrays.asList(report))) {
            // report 문자열 자체도 중복 제거
            String[] p = r.split(" ");
            // p[0]=신고자, p[1]=신고당한자
            reporters.computeIfAbsent(p[1], x -> new HashSet<>()).add(p[0]); 
        } 
        
        int[] answer = new int[id_list.length];
        for (Set <String> who : reporters.values()) {
            if (who.size() >= k){
                for (String reporter : who){
                    answer [idx.get(reporter)]++;
                }
            }
        }
        return answer;
    }
}


/*
1. 신고당한 유저와 신고 한 유저를 HashMap에 담기
2. k번 이상 신고당한 사람에 대해서 그 사람을 신고한 사람에게 메일 1통씩 보내기
*/






