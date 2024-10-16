
public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int colour = image[sr][sc];
        if (colour != color) {
            filling(image, sr, sc, colour, color);
        }
        return image;
    }

    public void filling(int[][] image, int sr, int sc, int colour, int color) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || colour != image[sr][sc]) {
            return;
        }

        image[sr][sc] = color;

        filling(image, sr+1, sc, colour, color);
        filling(image, sr-1, sc, colour, color);
        filling(image, sr, sc+1, colour, color);
        filling(image, sr, sc-1, colour, color);
    }
}
