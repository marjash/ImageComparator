import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Comparator;

@Getter
@AllArgsConstructor
public class Point implements Comparator<Point> {
    private int x;
    private int y;

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public int compare(Point p1, Point p2) {
        int result = p1.getX() - p2.getX();
        if (result == 0)
            result = p1.getY() - p2.getY();
        return result;
    }
}
