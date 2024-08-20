package com.amazon.ata.immutabilityandfinal.classroom.primephoto;

import com.amazon.ata.immutabilityandfinal.classroom.primephoto.activity.ConvertPrimePhotoActivity;
import com.amazon.ata.immutabilityandfinal.classroom.primephoto.dependency.DaggerServiceComponent;
import com.amazon.ata.immutabilityandfinal.classroom.primephoto.dependency.ServiceComponent;
import com.amazon.ata.immutabilityandfinal.classroom.primephoto.model.ConversionType;

import com.google.common.collect.ImmutableList;

/**
 * A class provided for interacting with the PrimePhotoConverterService
 */
public class PrimePhotoConverterManualTester {

    private static final ServiceComponent DAGGER = DaggerServiceComponent.create();

    /**
     * If you're having issues running the main method, check the "Before starting" steps in the README.
     */
    public static void main(String[] args) {
        // run the test with the source picture and a list conversions we want performed
        runTest("src/resources/dalmatian.jpg", ImmutableList.of(ConversionType.INVERSION,
            ConversionType.GREYSCALE, ConversionType.SEPIA));

        // PARTICIPANTS: uncomment the below line to run a test that converts an image to a single filter type.
        // runTest("src/resources/dalmatian.jpg", ImmutableList.of(ConversionType.SEPIA));
    }
    // This will start each conversion on a new Thread so they run concurrently

    private static void runTest(String filePath, ImmutableList<ConversionType> conversions) {
        ConvertPrimePhotoActivity activity = DAGGER.provideConvertPhotoActivity();
        activity.handleRequest(filePath, conversions);
    }
}
