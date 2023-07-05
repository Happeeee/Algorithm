// 프로그래머스 코딩테스트 문제풀이 전략 : 자바편
// p.96 풀이 참조

class Solution {
    private static final int dx[] = {0, -1, 1, 0}; // 상 하 좌 우 -> 상 좌 우 하
    private static final int dy[] = {-1, 0, 0, 1}; // 반대 방향을 쉽게 계산하기 위함
        
    private boolean isDistanced(char[][] room) {
        for(int y = 0; y < room.length; y++) {
            for(int x = 0; x < room[y].length; x++) {
                if(room[y][x] != 'P') continue;
                if(!isDistanced(room, y, x)) return false;
            }
        }        
        return true;
    }
    
    private boolean isDistanced(char[][] room, int y, int x) {
        for(int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
        
            if(ny < 0 || ny >= room.length || nx < 0 || nx >= room[ny].length) continue;
            
            switch(room[ny][nx]) {
                case 'P': return false; // P 상하좌우에 바로 P인 경우
                case 'O': 
                    if(isNextToVolunteer(room, ny, nx, 3 - d)) return false; // 인접한 곳에 다른 응시자가 있다면 false
                    break;
            }
        }  
        return true;
    }
    
    private boolean isNextToVolunteer(char[][] room, int y, int x, int exclude) {
        for(int d = 0; d < 4; d++) {
            if(d == exclude) continue; 
            
            int nx = x + dx[d];
            int ny = y + dy[d];
        
            if(ny < 0 || ny >= room.length || nx < 0 || nx >= room[ny].length) continue;
            
            if(room[ny][nx] == 'P') return true; // 인접한 곳(상하좌우 중 한 곳이라도) 다른 응시자가 있다면 false
        }
        return false;
    }
                        
    public int[] solution(String[][] places) {        
        
        int[] answer = new int[places.length];                    
        
        for(int i = 0; i < answer.length; i++) {
            String[] place = places[i];
            char[][] room = new char[answer.length][answer.length];
            
            for(int j = 0; j < 5; j++) {
                room[i] = place[j].toCharArray(); // 대기실 하나를 2차원 배열로
            }
            
            if(isDistanced(room))
                answer[i] = 1;
            else
                answer[i] = 0;
        }
        
        return answer;
    }
                    
}
