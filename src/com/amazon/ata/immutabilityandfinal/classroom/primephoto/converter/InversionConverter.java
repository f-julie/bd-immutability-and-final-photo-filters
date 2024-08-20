package com.amazon.ata.immutabilityandfinal.classroom.primephoto.converter;

import com.amazon.ata.immutabilityandfinal.classroom.primephoto.model.ConversionType;
import com.amazon.ata.immutabilityandfinal.classroom.primephoto.model.Pixel;
import com.amazon.ata.immutabilityandfinal.classroom.primephoto.model.PrimePhoto;
import com.amazon.ata.immutabilityandfinal.classroom.primephoto.model.RGB;
import com.amazon.ata.immutabilityandfinal.classroom.primephoto.util.PrimePhotoUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Converts an image to a inverted version.
 */
public class InversionConverter implements PrimePhotoConverter {

    public String convert(final PrimePhoto image, final String imageName) {
        List<Pixel> pixels = new ArrayList<>();

        for (Pixel pixel : image.getPixels()) {
            RGB rgb = pixel.getRGB();
            //rgb.invert();
            rgb = rgb.invert(); // Replace our RGB object with the new RGB object that toGreyScale returns
            pixels.add(new Pixel(pixel.getX(), pixel.getY(), rgb));
        }

        PrimePhoto convertedImage = new PrimePhoto(pixels, image.getHeight(), image.getWidth(), image.getType());

        return PrimePhotoUtil.savePrimePhoto(convertedImage, imageName, ConversionType.INVERSION);
    }
}
