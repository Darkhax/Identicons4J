package com.diluv.identicon.generators;

import java.awt.image.BufferedImage;

import com.diluv.identicon.hashgen.IHashGenerator;

/**
 * This interface is used to define an identicon generator. The job of an identicon generator
 * is to accept a byte array of data and create a relatively unique image based on a hash of
 * the input.
 *
 * @author Tyler Hancock (Darkhax)
 *
 */
public interface IIdenticonGenerator {

    /**
     * Generates an identicon with the provided input.
     *
     * @param input The input data. This will be hashed using the hashGen. The hash result will
     *        be used to create the final image.
     * @param hashGen The hash generator to use when generating a hash for the input.
     * @return An image buffer containing the generated image data.
     */
    BufferedImage generate (byte[] input, IHashGenerator hashGen);
}