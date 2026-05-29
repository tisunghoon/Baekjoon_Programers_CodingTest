import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int solution(int[] mats, String[][] park) {
        // Integer 배열로 변환 후 내림차순 정렬
        Integer[] matsArr = Arrays.stream(mats).boxed().toArray(Integer[]::new);
        Arrays.sort(matsArr, Collections.reverseOrder());
        
        int rows = park.length;
        int cols = park[0].length;
        
        // 가장 큰 돗자리 크기부터 탐색
        for (int size : matsArr) {
            for (int i = 0; i <= rows - size; i++) {
                for (int j = 0; j <= cols - size; j++) {
                    
                    boolean canPlace = true;
                    // size x size 구역 검사
                    for (int r = i; r < i + size; r++) {
                        for (int c = j; c < j + size; c++) {
                            if (!park[r][c].equals("-1")) {
                                canPlace = false;
                                break;
                            }
                        }
                        if (!canPlace) break;
                    }
                    
                    // 배치 가능함을 확인하면 즉시 해당 크기 반환
                    if (canPlace) {
                        return size;
                    }
                }
            }
        }
        
        return -1;
    }
}