import lombok.Getter;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;
import java.util.List;

/**
 * Draw the red rectangle around the distinct pixels
 * @author Oksana
 */
@Getter
class GetRectangle {
    /**
     * Get distinct image with rectangle
     * @param imgA The first image to be compared
     * @param imgB The second image to be compared
     * @return Image with rectangle around the distinct pixels
     */
    public BufferedImage getDifferentImage(BufferedImage imgA, BufferedImage imgB) {
        GetGroup group = new GetGroup();
        List<Group> groups = group.addPointIntoGroup(imgA, imgB);
        findPointsForRectangle(groups, imgB);
        return imgB;
    }

    /**
     * Draw red rectangle in image
     * @param image Hhe image on which it should be drawn rectangle
     * @param top The top of the rectangle to the y coordinate
     * @param left The left of the rectangle to the x coordinate
     * @param bottom The bottom of the rectangle to the y coordinate
     * @param right The right of the rectangle to the x coordinate
     */
    private void drawRectangle(BufferedImage image, int top, int left, int bottom, int right) {
        int width = right - left;
        int height = bottom - top;
        Graphics2D graphics2D = image.createGraphics();
        graphics2D.setColor(Color.RED);
        graphics2D.drawRect(left - 10, top - 5, width + 20, height + 15);
    }

    /**
     * Find points from rectangle from groups
     * @param groups Groups of points
     * @param image Hhe image on which it should be drawn rectangle
     */
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

    /**
     * Reduced use ArrayList<Point>>
     */
    static class Group extends ArrayList<Point> {
    }
}