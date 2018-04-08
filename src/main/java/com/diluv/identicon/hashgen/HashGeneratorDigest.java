package com.diluv.identicon.hashgen;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * This hash generator uses Java's MessageDigest system. Each implementation of the JRE has
 * different generators available. The JRE specifications require every implementation to
 * support MD5, SHA-1, and SHA-256.
 *
 * @author Tyler Hancock (Darkhax)
 */
public class HashGeneratorDigest implements IHashGenerator {

    /**
     * The method digest algorithm that is used by the generator.
     */
    private MessageDigest messageDigest;

    /**
     * Constructs a hash generator that uses Java's MessageDigest system. This can be used to
     * generate things like MD5 hashes. If you use an invalid digest algorithm, the generator
     * will not work.
     *
     * @param algorithim The algorithm to use. Each JRE can have different generators
     *        available. The JRE specifications require every implementation to support MD5,
     *        SHA-1, and SHA-256.
     * @throws NoSuchAlgorithmException If no algorithm is found, an exception will be thrown.
     */
    public HashGeneratorDigest (String algorithim) throws NoSuchAlgorithmException {

        this.messageDigest = MessageDigest.getInstance(algorithim);
    }

    @Override
    public byte[] getHash (String input) {

        return this.messageDigest.digest(input.getBytes());
    }

    public String getAlgorithmName () {

        return this.messageDigest.getAlgorithm();
    }
}
