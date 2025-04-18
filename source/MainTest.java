import generator.SimpleConstructor;
import interpritator.Runner;
import interpritator.api.VarPNG;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Objects;

public class MainTest {
    public static void main(String[] args) {

        SimpleConstructor.addInt(123456789);
        SimpleConstructor.addVoid();
        SimpleConstructor.addString("get");
        SimpleConstructor.addVoid();
        SimpleConstructor.addDouble(1000.7);
        SimpleConstructor.addVoid();
        SimpleConstructor.addByte((byte)12);
        SimpleConstructor.generate("23");

        System.out.println("");

        try {
            Runner.compileAndRun((BufferedImage) ImageIO.read(new File("C:\\Users\\COMP\\Documents\\javaProjects\\PNGSkript\\src\\test.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void runDialog(){
        JFrame j = new JFrame("tt");
        j.setIconImage(new ImageIcon(Objects.requireNonNull(MainTest.class.getResource("/b.png"))).getImage());
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setLocationRelativeTo(null);
        j.setVisible(true);

        JFileChooser d = new JFileChooser();
        d.setAcceptAllFileFilterUsed(false);
        d.setMinimumSize(new Dimension(500,500));
        d.addChoosableFileFilter(new FileNameExtensionFilter("PNG++ Scripts  (*.png, *.pngpp)","png","pngpp"));
        d.showOpenDialog(j);
        File f = d.getSelectedFile();
        System.out.println(34);
        try {
            BufferedImage image = ImageIO.read(f);
            Runner.compileAndRun(image);
            System.out.println(new Color(image.getRGB(1,1),true).getBlue());
        } catch (IOException e) {
            System.out.println(e);
            j.dispose();
        }

        j.dispose();
    }
}
