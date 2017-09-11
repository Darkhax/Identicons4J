package com.diluv.identicon.generators;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;

import com.diluv.identicon.hashgen.IHashGenerator;

/**
 * This identicon generator is used to generate classic identicons. A classic identicon is 5x5
 * pixels. Shaded pixels are determined by whether or not related values in the hash are on/1,
 * and the color is derived from the first three bytes in the hash.
 *
 * @author Tyler Hancock (Darkhax)
 */
public class ClassicGenerator implements IIdenticonGenerator {

    /**
     * The size of the identicon. The classic identicon is 5x5, and this can not be changed. If
     * you need a scaled up version it can be rescaled. A general purpose method for scaling up
     * identicons is provided in the Identicons class.
     */
    private static final int size = 5;

    /**
     * The color to use for the background of the image. This array is expected to have four
     * elements, RGBA.
     */
    private final int[] background;

    /**
     * Constructs a new classic identicon generator. This constructor uses a 100% transparent
     * white for the background color.
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
    public BufferedImage generate (String input, IHashGenerator hashGen) {

        final BufferedImage identicon = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);
        final WritableRaster raster = identicon.getRaster();
        final byte[] hash = hashGen.getHash(input);

        // RGB is determined by first three bytes.
        final int[] color = new int[] { hash[0] & 255, hash[1] & 255, hash[2] & 255, 255 };

        for (int x = 0; x < size; x++) {

            final int hashIndex = x < 3 ? x : 4 - x;

            for (int y = 0; y < size; y++) {

                // If the byte at the hashIndex is on/1 the color is used.
                raster.setPixel(x, y, (hash[hashIndex] >> y & 1) == 1 ? color : this.background);
            }
        }

        return identicon;
    }
}
