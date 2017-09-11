package com.diluv.identicon.hashgen;

/**
 * This interface is used to define a hash generator. The purpose of the hash generator is to
 * provide the hash of an input, as a byte array.
 *
 * @author Tyler Hancock (Darkhax)
 */
public interface IHashGenerator {

    /**
     * Used to get the hash of a string input.
     *
     * @param input The input to get the hash of.
     * @return An array of bytes which represent the hash.
     */
    byte[] getHash (String input);
}
