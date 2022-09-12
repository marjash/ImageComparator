import lombok.Getter;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;
import java.util.List;

@Getter
class GetDiffPoints {

    public List<Group> addPointIntoGroup(BufferedImage imgA, BufferedImage imgB) {
        List<Group> groups = new ArrayList<>();
        for (int y = 0; y < imgB.getHeight(); y++) {
            for (int x = 0; x < imgA.getWidth(); x++) {
                int pixelA = imgA.getRGB(x, y);
                int pixelB = imgB.getRGB(x, y);
                if (pixelA != pixelB) {
                    Point point = new Point(x, y);
                    Group group = findGroupForPoint(groups, point).orElse(new Group());
                    group.add(point);
                    if (!groups.contains(group))
                        groups.add(group);
                }
            }
        }
        return groups;
    }

    public BufferedImage getDiffImage(BufferedImage imgA, BufferedImage imgB) {
        List<Group> groups = addPointIntoGroup(imgA, imgB);
        findPointsForRectangle(groups, imgB);
        return imgB;
    }

    private Optional<Group> findGroupForPoint(List<Group> groups, Point point) {
        for (Group group : groups) {
            for (Point p : group) {
                if (distance(p, point) < 100)
                    return Optional.of(group);
            }
        }
        return Optional.empty();
    }

    private void drawRectangle(BufferedImage image, int top, int left, int bottom, int right) {
        int width = right - left;
        int height = bottom - top;
        Graphics2D graphics2D = image.createGraphics();
        graphics2D.setColor(Color.RED);
        graphics2D.drawRect(left - 10, top - 5, width + 20, height + 15);
    }

    private void findPointsForRectangle(List<Group> groups, BufferedImage image) {
        for (Group group : groups) {
            int top = Integer.MAX_VALUE;
            int left = Integer.MAX_VALUE;
            int bottom = 0;
            int right = 0;
            for (Point point : group) {
                top = Math.min(point.getY(), top);
                left = Math.min(point.getX(), left);
                bottom = Math.max(point.getY(), bottom);
                right = Math.max(point.getX(), right);
            }
            drawRectangle(image, top, left, bottom, right);
        }
    }

    static class Group extends ArrayList<Point> {

    }

    public int distance(Point point, Point point2) {
        double pow = Math.pow(point2.getX() - point.getX(), 2);
        double pow2 = Math.pow(point2.getY() - point.getY(), 2);
        return (int) Math.sqrt(pow + pow2);
    }
}