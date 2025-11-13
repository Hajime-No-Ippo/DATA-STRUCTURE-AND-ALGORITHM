package DA_ssessment;
import java.io.*;
import java.net.*;
import java.net.http.*;
import java.util.*;

    public class DA{
        static class Point {
            int x;
            int y;
            char ch;
            Point(int x, int y, char ch) {
                this.x = x;
                this.y = y;
                this.ch = ch;
            }
        }

        public static void printGridFromUrl(String url) throws Exception {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest req = HttpRequest.newBuilder()
                    .uri(new URI(url))
                    .GET()
                    .build();
            HttpResponse<String> resp = client.send(req, HttpResponse.BodyHandlers.ofString());
            String body = resp.body();

            String[] lines = body.split("\\r?\\n");
            List<Point> points = new ArrayList<>();
            int maxX = 0, maxY = 0;

            for (String line : lines) {
                line = line.trim();
                if (line.isEmpty()) continue;
                String[] parts = line.split("\\s+");
                if (parts.length >= 3) {
                    int x = Integer.parseInt(parts[0]);
                    int y = Integer.parseInt(parts[1]);
                    // assume the character is parts[2] and is a single uppercase letter
                    char ch = parts[2].charAt(0);
                    points.add(new Point(x, y, ch));
                    if (x > maxX) maxX = x;
                    if (y > maxY) maxY = y;
                }
            }

            // create grid filled with space
            char[][] grid = new char[maxY+1][maxX+1];
            for (int i = 0; i <= maxY; i++) {
                for (int j = 0; j <= maxX; j++) {
                    grid[i][j] = ' ';
                }
            }

            // place characters
            for (Point p : points) {
                grid[p.y][p.x] = p.ch;
            }

            // print grid
            for (int i = 0; i <= maxY; i++) {
                System.out.println(new String(grid[i]));
            }
        }

        public static void main(String[] args) {
            try {
                printGridFromUrl("https://docs.google.com/document/d/e/2PACX-1vRPzbNQcx5UriHSbZ-9vmsTow_R6RRe7eyAU60xIF9Dlz-vaHiHNO2TKgDi7jy4ZpTpNqM7EvEcfr_p/pub");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


