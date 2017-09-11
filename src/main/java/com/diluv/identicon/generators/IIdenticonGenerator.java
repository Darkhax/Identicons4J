package com.diluv.identicon.generators;

import java.awt.image.BufferedImage;

import com.diluv.identicon.hashgen.IHashGenerator;

public interface IIdenticonGenerator {

    BufferedImage generate (String input, IHashGenerator hashGen);
}