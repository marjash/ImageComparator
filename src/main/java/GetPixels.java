import java.io.File;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;

public class GetPixels {
    public static void main(String args[]) throws Exception {
        File fileA = new File("src/main/resources/test1.jpg");
        File fileB = new File("src/main/resources/test2.jpg");

        BufferedImage imgA = ImageIO.read(fileA);
        BufferedImage imgB = ImageIO.read(fileB);

        GetDiffPoints group = new GetDiffPoints();
        BufferedImage imgC = group.getDiffImage(imgA, imgB);

        ImageIO.write(imgC, "jpg", new File("src/main/img.jpg"));
    }
}