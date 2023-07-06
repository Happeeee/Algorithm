class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        // 행 : 왼쪽 행렬의 행의 수, 열 : 오른쪽 행렬의 열의 수
        int[][] answer = new int[arr1.length][arr2[0].length];
                
        for(int i = 0; i < arr1.length; i++) {
            for(int j = 0; j < arr2[0].length; j++) { // 오른쪽 행렬의 열의 수 만큼 곱셈이 반복
            
                int element = 0;
                
                for(int k = 0; k < arr1[0].length; k++) {
                    element += arr1[i][k] * arr2[k][j];
                }
                
                answer[i][j] = element;                
            }
        }
        
        return answer;        
    }
}
