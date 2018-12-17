package HackerCup.ProgressBar;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Abayomi on 21/08/2016.
 */
public class ProgressPie {
    public static void main(String[] args) {
        solve();
    }

    static void solve(){
        Path fileOutput = Paths.get("/Users/Admin/Documents/Code/Algorithms/src/HackerCup/ProgressBar/output.txt");
        List<String> lines = null;
        List<String> outputLines = new ArrayList<>();
        try {
            lines = Files.readAllLines(FileSystems.getDefault().getPath("/Users/Admin/Documents/Code/Algorithms/src/HackerCup/ProgressBar/progress_pie.txt"), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 1; i <= Integer.parseInt(lines.get(0)); i++) {
            String[] line = lines.get(i).split(" ");
            double p = Integer.parseInt(line[0]), pointX = Integer.parseInt(line[1]), pointY = Integer.parseInt(line[2]);
            double theta = p*360/100;
            double endX = 50 + (50*(Math.sin(Math.toRadians(theta))));
            double endY = 50 + (50*(Math.cos(Math.toRadians(theta))));
            Point point = new Point(pointX, pointY), center = new Point(50, 50), sectorStart = new Point(endX, endY), sectorEnd = new Point(50, 100);

            String ans = isInsideSector(point, center, sectorStart, sectorEnd, 2500) ? "black" : "white";
            System.out.println("Case #"+i+": " + ans);
            outputLines.add("Case #"+i+": " + ans);
        }

        try {
            Files.write(fileOutput, outputLines, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static boolean isWithinRadius(Point relPoint, int radiusSquared){
        return relPoint.getX()*relPoint.getX() + relPoint.getY()*relPoint.getY() <= radiusSquared;
    }

    static boolean areClockwise(Point point, Point relPoint){
        return -point.getX()*relPoint.getY() + point.getY()*relPoint.getX() > 0;
    }

    static boolean isInsideSector(Point point, Point center, Point sectorStart, Point sectorEnd, int radiusSquared){
        double relX = point.getX() - center.getX();
        double relY = point.getY() - center.getY();
        Point relPoint = new Point(relX, relY);

        return !areClockwise(sectorStart, relPoint) && isWithinRadius(relPoint, radiusSquared);
    }

}

 class Point {
    private double x;
    private double y;

    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
