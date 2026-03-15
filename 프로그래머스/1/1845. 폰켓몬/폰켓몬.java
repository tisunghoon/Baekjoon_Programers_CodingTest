import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {
        // 1. 내가 가져갈 수 있는 최대 마릿수를 계산합니다.
        int maxSelect = nums.length / 2;
        
        // 2. HashSet을 사용하여 폰켓몬의 종류를 중복 없이 저장합니다.
        HashSet<Integer> pokemonTypes = new HashSet<>();
        for (int num : nums) {
            pokemonTypes.add(num);
        }
        
        // 3. 실제 종류의 수와 가져갈 수 있는 최대치를 비교합니다.
        int totalTypes = pokemonTypes.size();
        
        // 종류가 가져갈 수 있는 수보다 많으면 maxSelect 반환, 
        // 적으면 실제 종류 수(totalTypes) 반환.
        return Math.min(totalTypes, maxSelect);
    }
}