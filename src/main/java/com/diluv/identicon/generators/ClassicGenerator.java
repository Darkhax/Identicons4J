package com.diluv.identicon.generators;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;

import com.diluv.identicon.hashgen.IHashGenerator;

/**
 * This implementation of identicon generator is used to generate the classic 5x5 identicon.
 * These are the types of identicons commonly used by services such as GitHub. The color is
 * determined using the first three bytes in the hash. The shape of the image is determined by
 * the bit value based on the pixel coordinates of the image.
 *
 * @author Tyler Hancock (Darkhax)
 *
 */
public class ClassicGenerator implements IIdenticonGenerator {

    /**
     * The size of the image to generate. A classic identicon has 5x5 pixels.
     */
    private static final int SIZE = 5;

    /**
     * The color to use for the background of the image. This array is expected to have four
     * elements, RGBA.
     */
    private final int[] background;

    /**
     * The default constructor for a classic identicon generator. This generator will use a
     * solid white background with 100% transparency. If a different background color is
     * desired {@link #ClassicGenerator(int[])} should be used instead.
     */
    public ClassicGenerator () {

        this(new int[] { 255, 255, 255, 0 });
    }

    /**
     * Constructs a new classic identicon generator.
     *
     * @param background The color to use for the background of generated images. This array is
     *        expected to have four elements, RGBA.
     */
    public ClassicGenerator (int[] background) {

        this.background = background;
    }

    @Override
    public BufferedImage generate (byte[] input, IHashGenerator hashGen) {

        // Generate a new image buffer of the specified size.
        final BufferedImage identicon = new BufferedImage(SIZE, SIZE, BufferedImage.TYPE_INT_ARGB);
        final WritableRaster raster = identicon.getRaster();

        // Generate a hash of the input data using the provided hash generator.
        final byte[] hash = hashGen.getHash(input);

        // RGB is determined by first three bytes.
        final int[] color = new int[] { hash[0] & 255, hash[1] & 255, hash[2] & 255, 255 };

        for (int x = 0; x < SIZE; x++) {

            // Offset the position in the hash based on x coordinate.
            final int hashIndex = x < 3 ? x : 4 - x;

            for (int y = 0; y < SIZE; y++) {

                // If the bit at the hashIndex is on/1 the color is used.
                raster.setPixel(x, y, (hash[hashIndex] >> y & 1) == 1 ? color : this.background);
            }
        }

        return identicon;
    }
}