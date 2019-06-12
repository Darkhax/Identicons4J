package com.diluv.identicon.tests;

import java.security.NoSuchAlgorithmException;

import org.junit.Assert;
import org.junit.Test;

import com.diluv.identicon.hashgen.HashGeneratorDigest;

public class ClassicTest {

    /**
     * The goal of this test is to verify that the HashGeneratorDigest wrapper is providing the
     * same hashes as an independent implementation of the same algorithm. This is to ensure
     * consistent results of the hash generator. The test will fail if the results of the hash
     * do not match the known result from an independent source.
     */
    @Test
    public void testDigestGenerators () throws NoSuchAlgorithmException {

        // The following byte[] are hashes generated independently of the Java environment
        // using the string "test".
        this.testDigest("MD5", new byte[] { 9, -113, 107, -51, 70, 33, -45, 115, -54, -34, 78, -125, 38, 39, -76, -10 });
        this.testDigest("SHA-1", new byte[] { -87, 74, -113, -27, -52, -79, -101, -90, 28, 76, 8, 115, -45, -111, -23, -121, -104, 47, -69, -45 });
        this.testDigest("SHA-256", new byte[] { -97, -122, -48, -127, -120, 76, 125, 101, -102, 47, -22, -96, -59, 90, -48, 21, -93, -65, 79, 27, 43, 11, -126, 44, -47, 93, 108, 21, -80, -16, 10, 8 });
    }

    /**
     * Tests a HashGeneratorDigest against the hash of an independent source which is known to
     * be good.
     *
     * @param algorithm The algorithm to test.
     * @param knownGood A hash which is known to be good.
     */
    private void testDigest (String algorithm, byte[] knownGood) throws NoSuchAlgorithmException {

        final HashGeneratorDigest gen = new HashGeneratorDigest(algorithm);
        Assert.assertArrayEquals(gen.getHash("test".getBytes()), knownGood);
    }
}