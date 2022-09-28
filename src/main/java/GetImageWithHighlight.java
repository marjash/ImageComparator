import java.io.File;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Get image with highlight
 * @author Oksana
 */
public class GetImageWithHighlight {
    /**
     * Read images and create image with rectangle
     * @param fileA First image that should be read
     * @param fileB Second image that should be read
     * @throws IOException if file isn't image or can't be read
     */
    public void getImage(File fileA, File fileB) throws IOException {
        BufferedImage imgA = ImageIO.read(fileA);
        BufferedImage imgB = ImageIO.read(fileB);

        GetRectangle group = new GetRectangle();
        BufferedImage imgC = group.getDifferentImage(imgA, imgB);

        ImageIO.write(imgC, "jpg", new File("src/main/img.jpg"));
    }
}