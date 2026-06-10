import java.util.HashMap;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        
        HashMap<String, Integer> playerMap = new HashMap <>();
        
        for(int i =0; i<players.length; i++) {
            playerMap.put(players[i], i);
        }
        
        for(String calling : callings){
            
            int currentIdx = playerMap.get(calling);
            int frontIdx = currentIdx - 1;
            
            String frontPlayer = players[frontIdx];
            
            players[frontIdx] = calling;
            players[currentIdx] = frontPlayer;
            
            playerMap.put(calling, frontIdx);
            playerMap.put(frontPlayer, currentIdx);
            
        }
        
        return players;
        
    }
}