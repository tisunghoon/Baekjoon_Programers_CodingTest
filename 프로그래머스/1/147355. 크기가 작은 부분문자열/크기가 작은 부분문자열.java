class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int len = p.length();
        long pNum = Long.parseLong(p);            // 최대 18자리 → long 필수

        for (int i = 0; i + len <= t.length(); i++) {
            long sub = Long.parseLong(t.substring(i, i + len));
            if (sub <= pNum) answer++;
        }
        return answer;
    }
}