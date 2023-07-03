import java.util.*;

// 프로그래머스 코딩테스트 문제풀이 전략 : 자바편
// p.60 풀이 참조
// 기능별로 메소드를 분할하는 방식에 익숙해질 필요

class Solution {
    private static class Point {
        public final long x, y;
        
        private Point(long x, long y){
            this.x = x;
            this.y = y;
        }
    }
    
    private Point intersection(long a1, long b1, long c1, long a2, long b2, long c2) {
        // 교점 구해서 정수 일 때만 Point로 반환
        double x = (double) (b1 * c2 - c1 * b2) / (a1 * b2 - b1 * a2);
        double y = (double) (c1 * a2 - a1 * c2) / (a1 * b2 - b1 * a2);
        
        if(x % 1 != 0 || y % 1 != 0) return null;
        
        return new Point((long)x, (long)y);
    }
    
    private Point getMinumumPoint(List<Point> points) {
        long x = Long.MAX_VALUE;
        long y = Long.MAX_VALUE;
        
        for(Point p : points) {
            if(p.x < x) x = p.x;
            if(p.y < y) y = p.y;
        }
        
        return new Point(x, y);
    }
    
    private Point getMaximumPoint(List<Point> points) {
        long x = Long.MIN_VALUE;
        long y = Long.MIN_VALUE;
        
        for(Point p : points) {
            if(p.x > x) x = p.x;
            if(p.y > y) y = p.y;
        }
        
        return new Point(x, y);
    }
    
    public String[] solution(int[][] line) {           
        List<Point> points = new ArrayList<>();
        
        for(int i = 0; i < line.length; i++) {
            for(int j = i + 1; j < line.length; j++) {
                Point intersection = intersection(line[i][0], line[i][1], line[i][2], 
                                                  line[j][0], line[j][1], line[j][2]);
                
                if(intersection != null)
                    points.add(intersection);
            }
        }
        
        Point min = getMinumumPoint(points);
        Point max = getMaximumPoint(points);
        
        int width = (int)(max.x - min.x + 1); // 최대, 최소 x, y 좌표로 배열의 크기를 결정
        int height = (int)(max.y - min.y + 1);
        
        char[][] map = new char[height][width];
        
        for(char[] row : map)
            Arrays.fill(row, '.');
        
        for(Point p : points) { // x, y 좌표를 2차원 배열의 좌표로 변환
            int x = (int) (p.x - min.x);
            int y = (int) (max.y - p.y);
            map[y][x] = '*';
        }
        
        String[] result = new String[map.length]; // char[][] -> String[]
        for(int i = 0; i < result.length; i++) {
            result[i] = new String(map[i]);
        }
        
        return result;
    }
}
