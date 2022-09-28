import java.io.File;

public class Main {
    /**
     * Run the program
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        File fileA = new File("src/main/resources/test1.jpg");
        File fileB = new File("src/main/resources/test2.jpg");
        GetImageWithHighlight image = new GetImageWithHighlight();
        image.getImage(fileA, fileB);
    }
}
