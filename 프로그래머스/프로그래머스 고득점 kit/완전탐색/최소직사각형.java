class Solution {
    public int solution(int[][] sizes) {
        int width = -1, height = -1;
        for(int i = 0; i < sizes.length; i++) {
            int w = Math.max(sizes[i][0], sizes[i][1]);
            int h = Math.min(sizes[i][0], sizes[i][1]);
            
            width = Math.max(width, w);
            height = Math.max(height, h);
        }
        return width * height;
    }
}
