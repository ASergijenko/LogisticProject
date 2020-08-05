package com.logisticproject.services.excelService;

import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class TwoDArrayToImageConverter {

    public void writeImage(Double[][] array, String path) {
        BufferedImage image = new BufferedImage(array.length, array[0].length, BufferedImage.TYPE_INT_RGB);

        //creating map with cargos and colors
        Map<Double, Color> colorsForCargo = new HashMap<>();
        colorsForCargo.put(0.0, new Color(255,255,255));
        for (Double[] doubles : array) {
            for (int j = 0; j < array[0].length; j++) {
                if (!colorsForCargo.containsKey(doubles[j])) {
                    colorsForCargo.put(doubles[j], new Color((int)(Math.random() * 16777216)));
                }
            }
        }

        //painting image
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] != null) {
                    int rgb = colorsForCargo.get(array[i][j]).getRGB();
                    image.setRGB(i, j, rgb);
                }
            }
        }

        //writing to file
        try (FileOutputStream outputStream = new FileOutputStream(path)){
            ImageIO.write(rotate(flip(image)), "png", outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //flip
    private BufferedImage flip(BufferedImage image){
        AffineTransform at = new AffineTransform();
        at.concatenate(AffineTransform.getScaleInstance(1, -1));
        at.concatenate(AffineTransform.getTranslateInstance(0, -image.getHeight()));
        return createTransformed(image, at);
    }

    //rotate 90 degrees
    public static BufferedImage rotate(BufferedImage src) {
        int width = src.getWidth();
        int height = src.getHeight();

        BufferedImage dest = new BufferedImage(height, width, src.getType());

        Graphics2D graphics2D = dest.createGraphics();
        graphics2D.translate((height - width) / 2, (height - width) / 2);
        graphics2D.rotate(Math.PI / 2, height / 2, width / 2);
        graphics2D.drawRenderedImage(src, null);

        return dest;
    }

    //transform AffineTransform to BufferedImage
    private static BufferedImage createTransformed(BufferedImage image, AffineTransform at) {
        BufferedImage newImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g = newImage.createGraphics();
        g.transform(at);
        g.drawImage(image, 0, 0, null);
        g.dispose();
        return newImage;
    }
}