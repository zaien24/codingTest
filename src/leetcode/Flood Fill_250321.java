public class FloodFill {
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int startColor = image[sr][sc];
        if (startColor == newColor) return image;
        
        dfs(image, sr, sc, startColor, newColor);
        return image;
    }

    public static void main(String[] args) {
        int[][] image = {
            {1,1,1},
            {1,1,0},
            {1,0,1}
        };
        int sr = 1, sc = 1, newColor = 2;
    

        int[][] result = floodFill(image, sr, sc, newColor);

        for (int[] row : result) {
            for (int pixel : row) {
                System.out.print(pixel + " ");
            }
            System.out.println();
        }
    }
}