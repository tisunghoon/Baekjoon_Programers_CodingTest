import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        // 1. 기준 문자열을 인덱스로 변환
        int extIdx = getIndex(ext);
        int sortIdx = getIndex(sort_by);
        
        // 2. 조건에 맞는 데이터 필터링
        List<int[]> filteredData = new ArrayList<>();
        for (int[] row : data) {
            if (row[extIdx] < val_ext) {
                filteredData.add(row);
            }
        }
        
        // 3. 정렬 기준에 따라 오름차순 정렬 (람다식 활용)
        filteredData.sort((a, b) -> Integer.compare(a[sortIdx], b[sortIdx]));
        
        // 4. List를 2차원 배열로 변환하여 반환
        return filteredData.toArray(new int[0][]);
    }
    
    // 컬럼 이름을 배열 인덱스로 매핑해주는 헬퍼 메서드
    private int getIndex(String column) {
        switch(column) {
            case "code": return 0;
            case "date": return 1;
            case "maximum": return 2;
            case "remain": return 3;
            default: return -1;
        }
    }
}