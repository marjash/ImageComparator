import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Get a group of points whose pixels are different and which are close to each other
 * @author Oksana
 */
public class GetGroup {
    /**
     *Adds points that are close to the same group
     * @param imgA The first image to be compared
     * @param imgB The second image to be compared
     * @return Return groups of points
     */
    public List<GetRectangle.Group> addPointIntoGroup(BufferedImage imgA, BufferedImage imgB) {
        List<GetRectangle.Group> groups = new ArrayList<>();
        for (int y = 0; y < imgB.getHeight(); y++) {
            for (int x = 0; x < imgA.getWidth(); x++) {
                int pixelA = imgA.getRGB(x, y);
                int pixelB = imgB.getRGB(x, y);
                if (pixelA != pixelB) {
                    Point point = new Point(x, y);
                    GetRectangle.Group group = findGroupForPoint(groups, point).orElse(new GetRectangle.Group());
                    group.add(point);
                    if (!groups.contains(group))
                        groups.add(group);
                }
            }
        }
        return groups;
    }

    /**
     * Check the distance between point, and if the distance is less than 100
     * then points will be in one group
     * @param groups The groups of points
     * @param point The point to be compared
     * @return The group of points if the distance of them is less than 100.
     * Otherwise, return an empty value
     */
    private Optional<GetRectangle.Group> findGroupForPoint(List<GetRectangle.Group> groups, Point point) {
        for (GetRectangle.Group group : groups) {
            for (Point p : group) {
                if (distance(p, point) < 100)
                    return Optional.of(group);
            }
        }
        return Optional.empty();
    }

    /**
     * Calculate the distance between 2 points
     * @param point1 The first point
     * @param point2 The second point
     * @return The distance from first point to second. The value will always will be non-negative
     */
    private int distance(Point point1, Point point2) {
        double pow1 = Math.pow(point2.getX() - point1.getX(), 2);
        double pow2 = Math.pow(point2.getY() - point1.getY(), 2);
        return (int) Math.sqrt(pow1 + pow2);
    }

}
