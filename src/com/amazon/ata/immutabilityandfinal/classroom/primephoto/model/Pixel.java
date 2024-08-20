package com.amazon.ata.immutabilityandfinal.classroom.primephoto.model;

import java.util.Objects;

/**
 * Represents a single point in an image. Each pixel has a location in the image, and an associated RGB color.
 */
// 1. Make this class immutable
// 2. Make instance variables final
// 3. Check constructors for reference parameters and replace assignments with defensive copy
// 4. Make sure any references returned are defensive returns (return copy of the data)
// 5. Ensure there are no setters in the class (this one doesn't have any)
// 6. Modify existing code so no instance variables are changed (fix compile errors due to making them final)
public final class Pixel {
    private final int x;
    private final int y;
    private final RGB rgb;

    // Constructor is receiving a reference to an RGB object - make a defensive copy
    public Pixel(int x, int y, RGB rgb) {
        this.x = x;
        this.y = y;
        //this.rgb = rgb; // replace with defensive copy
        this.rgb = new RGB(rgb.getRed(), rgb.getGreen(), rgb.getBlue(), rgb.getTransparency());
    }

    // This method returns an RGB object - make a defensive return
    public RGB getRGB() {
        //return rgb; // Replaced with defensive return
        return new RGB(rgb.getRed(), rgb.getGreen(), rgb.getBlue(), rgb.getTransparency());
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, rgb);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Pixel pixel = (Pixel) obj;

        return pixel.x == this.x && pixel.y == this.y &&
           Objects.equals(pixel.rgb, this.rgb);
    }
}
