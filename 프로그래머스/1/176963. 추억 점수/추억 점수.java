import java.util.HashMap;


class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        
        /*
        1. 이름과 연도가 쌍으로 나오니까 HashMap을 떠올리기 쉽다.
        2. 이중배열의 최대 길이가 각각 100이니까, 풀스캔 해도 시간복잡도에 안 걸릴 것 같다.
        3. 이름과 그리움 점수로 해시맵 만들고, 사진 for 문 돌리면서 해당 이름에 해당되는 그리움 점수를 answer에 합치자
        */
        
        HashMap <String, Integer> scoreMap = new HashMap<>();
        
        for(int i=0; i< name.length; i++){
            scoreMap.put(name[i], yearning[i]);
        }
        
        
        for (int i =0; i < photo.length; i++){
            int currentPhotoScore = 0;
            
            for (String person : photo[i]){
                
                currentPhotoScore += scoreMap.getOrDefault(person, 0);
            }
            
            answer[i] = currentPhotoScore;
        }
        
        return answer;
    }
}