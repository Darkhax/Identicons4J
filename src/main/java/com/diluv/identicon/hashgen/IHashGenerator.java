package com.diluv.identicon.hashgen;

/**
 * This interface provides a wrapper for various types of hash generators. Hash generators are
 * used by the library to seed various types of identicon generation.
 *
 * @Author Tyler Hancock (Darkhax)
 */
public interface IHashGenerator {

    /**
     * Generates a hash for a given input.
     *
     * @param input An array of bytes which represent the input data.
     * @return An array of bytes which represent the hash of the input.
     */
    byte[] getHash (byte[] input);
}
