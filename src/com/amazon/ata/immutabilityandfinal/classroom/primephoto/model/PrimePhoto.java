package com.amazon.ata.immutabilityandfinal.classroom.primephoto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A class representing a PrimePhoto - contains dimensions, and a list of Pixels that make up the image.
 */
// 1. Make this class immutable
// 2. Make instance variables final
// 3. Check constructors for reference parameters and replace assignments with defensive copy
// 4. Make sure any references returned are defensive returns (return copy of the data)
// 5. Ensure there are no setters in the class (this one doesn't have any)
// 6. Modify existing code so no instance variables are changed (fix compile errors due to making them final)
public final class PrimePhoto {
    private final List<Pixel> pixels;
    private final int height;
    private final int width;
    // used when saving to a buffered image
    private final int type;

    // Constructor contains a reference parameter - List is an object which is a reference - defensive copy it
    public PrimePhoto(List<Pixel> pixelList, int height, int width, int type) {
        if (pixelList.size() != (height * width)) {
            throw new IllegalArgumentException("Not enough pixels for the dimensions of the image.");
        }
        //this.pixels = pixelList; // Replaced by defensive copy
        this.pixels = new ArrayList<>(pixelList); // Copy the parameter into our instance variable

        this.height = height;
        this.width = width;
        this.type = type;
    }

    // This returns a reference - List is an object which is a reference - defensive return
    public List<Pixel> getPixels() {
        //return pixels; // Replaced with defensive return
        return new ArrayList<>(pixels); // Return a copy of our instance data (protecting our data)
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getType() {
        return type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pixels, height, width, type);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        PrimePhoto photo = (PrimePhoto) obj;

        return photo.height == this.height && photo.width == this.width &&
            photo.type == photo.type && Objects.equals(photo.pixels, this.pixels);
    }

}
