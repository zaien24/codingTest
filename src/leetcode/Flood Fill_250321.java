class Solution {
    // 방향 배열 (하, 상, 우, 좌)
static int[][] directions = {
    {1, 0}, {-1, 0}, {0, 1}, {0, -1}
};

public int[][] floodFill(int[][] image, int sr, int sc, int color) {
    // 무한 루프 
    int startColor = image[sr][sc];
    if (startColor == color) return image;

    dfs(image, sr, sc, startColor, color);

    return image;
}

public static void dfs (int[][] image, int r, int c, int startColor, int newColor) {
    if (r < 0 || c < 0 || r >= image.length || c >= image[0].length) {
        return;
    }
    if (image[r][c] != startColor) return;

    image[r][c] = newColor;

    for (int[] dir : directions) {
        int newR = r + dir[0];
        int newC = c + dir[1];
        dfs(image, newR, newC, startColor, newColor);
    }
}
}