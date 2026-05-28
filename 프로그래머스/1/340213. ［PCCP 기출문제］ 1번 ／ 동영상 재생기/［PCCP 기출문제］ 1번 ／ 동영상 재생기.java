class Solution {
    // "MM:SS" 문자열을 초(second) 단위 정수로 변환하는 헬퍼 메서드
    private int toSeconds(String timeStr) {
        String[] parts = timeStr.split(":");
        int mm = Integer.parseInt(parts[0]);
        int ss = Integer.parseInt(parts[1]);
        return mm * 60 + ss;
    }

    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        // 모든 시간 데이터를 초 단위로 변환
        int videoLimit = toSeconds(video_len);
        int currentPos = toSeconds(pos);
        int openingStart = toSeconds(op_start);
        int openingEnd = toSeconds(op_end);

        // 명령어 배열을 순회하며 위치 업데이트
        for (String cmd : commands) {
            // [주의] 명령을 수행하기 전에 현재 위치가 오프닝 구간인지 체크
            if (currentPos >= openingStart && currentPos <= openingEnd) {
                currentPos = openingEnd;
            }

            // 명령어 수행
            if (cmd.equals("next")) {
                currentPos += 10;
                if (currentPos > videoLimit) {
                    currentPos = videoLimit;
                }
            } else if (cmd.equals("prev")) {
                currentPos -= 10;
                if (currentPos < 0) {
                    currentPos = 0;
                }
            }
        }

        // [주의] 모든 명령을 마친 후 최종 위치가 오프닝 구간인지 다시 한번 체크
        if (currentPos >= openingStart && currentPos <= openingEnd) {
            currentPos = openingEnd;
        }

        // 초 단위 정수를 다시 "MM:SS" 문자열 포맷으로 변환
        int finalMm = currentPos / 60;
        int finalSs = currentPos % 60;

        return String.format("%02d:%02d", finalMm, finalSs);
    }
}