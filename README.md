# Identicons4J
A simple, yet modular library for creating Identicons. An Identicon is a way of visually representing the hash value of arbitrary data. These have a wide range of applications, however the most common use is for unique default avatars. There are many different ways to visualize an identicon. You can find examples of the supported identicon types further in this document. 

## Source Code
The latest source coude can be found on [GitHub](https://github.com/Diluv/Identicons4J) under the LGPL 2.1 license. If you use Git, you can clone the project using the following command. `git clone git@github.com:Diluv/Identicons4J.git`

## Identicon Types

### Classic 
![ClassicExample](https://i.imgur.com/G77niAn.png)     
The classic identicon is a 5x5 pixel image. The RGB of the image is based on the first three bytes of the hash. The way which pixels are shaded is determined by whether or not the pixel's index relates to a byte that is on/equals one. These are similar to the ones used by [GitHub](https://github.com/blog/1586-identicons). 

## Quick Start
Identicons4J is pretty simple to use. There are two components, the first is `IHashGenerator`, which is used to generate a hash fingerprint from an input. The second component is `IIdenticonGenerator` which is used to actually generate the identicon image. The following example generates an identicon using an md5 hash. 

```java
        final IIdenticonGenerator identiconGen = new ClassicGenerator();
        final IHashGenerator hashGen = new HashGeneratorDigest("MD5");
        
        BufferedImage identicon = identiconGen.generate("The input text", hashGen);
```

## Gradle
This library is available on our maven and can be used in Gradle projects. 
```groovy
repositories {

    maven { 
    
        url 'http://maven.mcmoddev.com' 
    }
}

dependencies {

    compile 'com.diluv.identicon:Identicon4J:VERSION'
}
```
