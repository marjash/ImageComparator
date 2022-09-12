import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Comparator;

@Getter
@AllArgsConstructor
public class Point {
    private int x;
    private int y;

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
