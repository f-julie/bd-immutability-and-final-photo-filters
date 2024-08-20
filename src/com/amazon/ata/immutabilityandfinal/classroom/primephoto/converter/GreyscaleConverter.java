package com.amazon.ata.immutabilityandfinal.classroom.primephoto.converter;

import com.amazon.ata.immutabilityandfinal.classroom.primephoto.model.ConversionType;
import com.amazon.ata.immutabilityandfinal.classroom.primephoto.model.Pixel;
import com.amazon.ata.immutabilityandfinal.classroom.primephoto.model.PrimePhoto;
import com.amazon.ata.immutabilityandfinal.classroom.primephoto.model.RGB;
import com.amazon.ata.immutabilityandfinal.classroom.primephoto.util.PrimePhotoUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Converts an image to a grey scale version.
 */
public class GreyscaleConverter implements PrimePhotoConverter {

    public String convert(final PrimePhoto image, final String imageName) {
        List<Pixel> pixels = new ArrayList<>();

        for (Pixel pixel : image.getPixels()) {
            RGB rgb = pixel.getRGB();

            // Change the values in RGB object to grey scale
            // This was okay before we made the data immutable
            // toGreyScale() used to just change the values in the RGB object
            // toGreyScale now returns a new RGB object with the changes
            //rgb.toGreyScale(); // Replaced by storing the result from toGreyScale back into RGB object
            rgb = rgb.toGreyScale(); // Replace our RGB object with the new RGB object that toGreyScale returns
            pixels.add(new Pixel(pixel.getX(), pixel.getY(), rgb));
        }

        PrimePhoto convertedImage = new PrimePhoto(pixels, image.getHeight(), image.getWidth(), image.getType());

        return PrimePhotoUtil.savePrimePhoto(convertedImage, imageName, ConversionType.GREYSCALE);
    }
}
