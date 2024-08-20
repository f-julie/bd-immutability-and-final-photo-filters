package com.amazon.ata.immutabilityandfinal.classroom.primephoto.model;

import java.util.Objects;

/**
 * An object that represent colors. Each object represents the color as three integers that stand for primary color
 * values.
 */

// 1. Make this class immutable
// 2. Make instance variables final
// 3. Check constructors for reference parameters and replace assignments with defensive copy
// 4. Make sure any references returned are defensive returns (return copy of the data)
// 5. Ensure there are no setters in the class (this one doesn't have any)
// 6. Modify existing code so no instance variables are changed (fix compile errors due to making them final)
public final class RGB {

    private final int red;
    private final int green;
    private final int blue;
    private final int transparency;

    private void check(int red, int green, int blue, int transparency) {
        if (red < 0 || red > 255 ||
            green < 0 || green > 255 ||
            blue < 0 || blue > 255) {
            throw new IllegalArgumentException(String.format("Invalid values color values. Red, green, " +
                "and blue must be between 0 and 255: {red: %d , green: %d, blue: %d}", red, green, blue));
        }
        if (transparency < 0 || transparency > 255) {
            throw new IllegalArgumentException("Invalid transparency value: " + transparency);
        }
    }

    // Constructor does not receive reference parameters, so no defensive copying necessary
    public RGB(int red, int green, int blue, int transparency) {
        check(red, green, blue, transparency);
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.transparency = transparency;
    }

    // No defensive returns are necessary on getters either
    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }

    public int getTransparency() {
        return transparency;
    }

    /**
     * Averages the red, blue, and green components, producing a grey color.
     */

    //public void toGreyScale( ){ // Replaced to return a new RGB object since we can't change values in this one
        public RGB toGreyScale() {
        int avg = (red + green + blue) / 3;

        // replaced by returning a new RGB with the values we want to change and the existing transparency value
        //red = avg;
        //green = avg;
        //blue = avg;

        return new RGB(avg, avg, avg, this.transparency); // this. is optional
    }

    /**
     * Converts the color to a reddish-brown color.
     */
    //public void toSepia( ) { // Replaced to return a new RGB object since we can't change values in this one
        public RGB toSepia() {
        int newRed = (int)(0.393 * red + 0.769 * green + 0.189 * blue);
        int newGreen = (int)(0.349 * red + 0.686 * green + 0.168 * blue);
        int newBlue = (int)(0.272 * red + 0.534 * green + 0.131 * blue);

        // replaced by returning a new RGB with the values we want to change and the existing transparency value
        //red = Math.min(255, newRed);
        //green = Math.min(255, newGreen);
        //blue = Math.min(255, newBlue);

        return new RGB(Math.min(255, newRed), Math.min(255, newGreen), Math.min(255, newBlue), this.transparency); // this. is optional
    }

    /**
     * "Dark mode" - Assigns red, green, and blue, their current value subtracted from their max value (255).
     * This will turn white to black.
     */
    //public void invert() {// Replaced to return a new RGB object since we can't change values in this one
    public RGB invert() {
        // replaced by returning a new RGB with the values we want to change and the existing transparency value
        //red = 255 - red;
        //green = 255 - green;
        //blue = 255 - blue;
        return new RGB(255 - red, 255 - green, 255 - blue, this.transparency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(red, green, blue, transparency);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        RGB rgb = (RGB) obj;

        return rgb.red == this.red && rgb.green == this.green &&
            rgb.blue == this.blue && rgb.transparency == this.transparency;
    }
}
