package com.diluv.identicon.tests;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.diluv.identicon.Identicons;
import com.diluv.identicon.generators.ClassicGenerator;
import com.diluv.identicon.generators.IIdenticonGenerator;
import com.diluv.identicon.hashgen.HashGeneratorDigest;

/**
 * This test generates some identicons for md5, sha1 and sha256 digests.
 * 
 * @author Tyler Hancock (Darkhax)
 */
public class ClassicTest {
    
    public static void main (String[] args) {
        
        final IIdenticonGenerator identiconGenerator = new ClassicGenerator();
        final HashGeneratorDigest[] hashGenerators = { new HashGeneratorDigest("MD5"), new HashGeneratorDigest("SHA-1"), new HashGeneratorDigest("SHA-256") };
        
        for (final HashGeneratorDigest hashGen : hashGenerators) {
            
            final BufferedImage image = Identicons.scaleUpImage(identiconGenerator.generate("Classic-Test", hashGen), 256, 256);
            
            try {
                
                final File file = new File("test/classic/" + hashGen.getAlgorithmName() + ".png");
                
                if (!file.getParentFile().exists()) {
                    
                    file.mkdirs();
                }
                
                ImageIO.write(image, "PNG", file);
            }
            
            catch (final IOException e) {
                
                e.printStackTrace();
            }
        }
    }
}