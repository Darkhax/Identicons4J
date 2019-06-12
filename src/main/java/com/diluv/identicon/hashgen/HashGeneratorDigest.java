package com.diluv.identicon.hashgen;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * This hash generator wraps Java's MessageDigest API. The algorithms available are dependent
 * on your Java environment. The only algorithms required by the JRE specifications are MD5,
 * SHA-1, and SHA-256.
 *
 * @author Tyler Hancock (Darkhax)
 *
 */
public class HashGeneratorDigest implements IHashGenerator {

    /**
     * The digest used to produce hashes for {@link #getHash(byte[])}.
     */
    private final MessageDigest messageDigest;

    /**
     * Constructs a new hash generator which uses Java's MessageDigest API.
     *
     * @param algorithim The name of the algorithm to use. The only algorithms guaranteed by
     *        JRE specifications are MD5, SHA-1, and SHA-256.
     * @throws NoSuchAlgorithmException If the specified algorithm is not available this
     *         exception will be thrown.
     */
    public HashGeneratorDigest (String algorithim) throws NoSuchAlgorithmException {

        this.messageDigest = MessageDigest.getInstance(algorithim);
    }

    @Override
    public byte[] getHash (byte[] input) {

        // Defer the hash request to Java's MessageDigest API.
        return this.messageDigest.digest(input);
    }

    /**
     * Gets the name of the algorithm being used by the generator.
     *
     * @return The name of the algorithm being used.
     */
    public String getAlgorithmName () {

        return this.messageDigest.getAlgorithm();
    }
}