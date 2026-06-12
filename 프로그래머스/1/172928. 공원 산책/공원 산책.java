class Solution {
    public int[] solution(String[] park, String[] routes) {
        int H = park.length;
        int W = park[0].length();
        int r = 0, c = 0;
        
        // 1. 시작 지점 'S' 찾기
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (park[i].charAt(j) == 'S') {
                    r = i;
                    c = j;
                    break; // 찾았으면 반복문 탈출
                }
            }
        }
        
        // 2. 명령어 처리하기
        for (String route : routes) {
            String[] parts = route.split(" ");
            String direction = parts[0];
            int distance = Integer.parseInt(parts[1]);
            
            int nr = r; // 임시 이동 좌표
            int nc = c;
            boolean canMove = true;
            
            // 주어진 거리만큼 한 칸씩 이동하며 검사
            for (int step = 0; step < distance; step++) {
                if (direction.equals("N")) nr--;
                else if (direction.equals("S")) nr++;
                else if (direction.equals("W")) nc--;
                else if (direction.equals("E")) nc++;
                
                // 공원 경계를 벗어나는지 확인
                if (nr < 0 || nr >= H || nc < 0 || nc >= W) {
                    canMove = false;
                    break;
                }
                
                // 장애물 'X'를 만나는지 확인
                if (park[nr].charAt(nc) == 'X') {
                    canMove = false;
                    break;
                }
            }
            
            // 이동 중 조건을 모두 통과했다면 실제 위치 업데이트
            if (canMove) {
                r = nr;
                c = nc;
            }
        }
        
        // 최종 좌표 반환 (세로, 가로)
        return new int[]{r, c};
    }
}






/*

기본 흐름
0. 공원 구조 이해 후 시작지점 확인 하기
1. 명령 수행 전에 체크하는 로직 실행
2. 명령 체크 통과 후에 명령 수행하여서 위치한 자리 업데이트 시키기
3. 이를 모든 명령을 전부 수행할 때 까지 반복
4. 완료 후 결과값 반환하기

제약 조건
1. 3<=공원 길이<=50
2. 3<=움직이는 거리<=50
3. 우측하단의 좌표값(H-1, W-1) 이니까 H와 W 이용하기
4. result는 1차원 배열로 반환
5. 시간복잡도 확인하기 필수

지금 떠오르는 컨셉
1. "방향 거리"를 띄어쓰기로 슬라이싱하고 방향값과 거리 값 파악하기
2. "방향 거리"를 좌표로 변환해주는 함수 만들어서 사용하기
3. 공원 구조를 2차원 배열로 그리드 만들기

중요한 것
1. 공원 구조와 이동하는 좌표 값의 구조가 다른데, 어떻게 통일 시켜서 연산할 것인가
    - 결과 값을 배열로 반환해야 되니까, 기본 배열로 하자
    - 코드 수를 줄일려면 routes에서 park 값을 바로 매칭 시킬 수 도 있겠으나 제3자가 코드를 직관적으로 읽고 쉽게 이해하기 위해서는 park와 routes값을 둘다 int 배열 값으로 변경하고 연산을 해나가는게 좋겠다.
    - 
2. 시작 지점에서 이동할 때 어떻게 값을 누적해 나갈 것인가
3. 시작점이 기준이다. 이 기준점으로부터 4방향으로 움직여야 함, 동&남 -> + / 서&북 -> -
4. 

결정해야 될 것 
1. 어떤 자료구조를 쓸 것인가 
    - 기본 배열 쓸꺼임 
2. 어떤 메소드가 필요한가 
    - toCharArray, 
3. 어떤 메소드를 만들어야 하는가 
    - park -> 2차원 배열 변환 메소드, routes -> 좌표 변환 메소드, 이동 값 계산후 결과 반환 메서드


어떻게 객체지향 설계할 것인가?
1. 이동 가능한지 불가능한지 판단하는 메소드 만들기
2. 이동 못할 경우 에러를 케이스 별로 반환하기(default -1)
3. 메소드 네이밍 행위중심적으로 직관적이고 인간적이게 하기 
4. SOLID

어떻게 클린 코드로 작성할 것인가?
1. 
2. 



*/