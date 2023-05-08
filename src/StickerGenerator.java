import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;



public class StickerGenerator {
    public void create(InputStream inputStream, String fileName) throws Exception {

        BufferedImage originalImage = ImageIO.read(inputStream);
        int width = originalImage.getWidth();
        int height = originalImage.getHeight();
        int newHeight = height + 200;

        BufferedImage newImage = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);

        Graphics2D graphics = (Graphics2D) newImage.getGraphics();
        graphics.drawImage(originalImage, 0, 0,null);

        Font font = new Font(Font.SANS_SERIF, Font.BOLD, 64);
        graphics.setColor(Color.ORANGE);
        graphics.setFont(font);

        graphics.drawString("TopZera",0,newHeight - 100);

        ImageIO.write(newImage, "png", new File(fileName));


    }
}
