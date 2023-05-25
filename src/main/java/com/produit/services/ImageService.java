package com.produit.services;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.awt.Image;

import org.springframework.beans.factory.annotation.Autowired;

import com.produit.repository.ClientRepository;

public class ImageService {
	@Autowired
	  private ClientRepository imageRepository;

    public void saveImage(byte[] imageData, String fileName) throws IOException {
        ByteArrayInputStream bais = new ByteArrayInputStream(imageData);
        BufferedImage image = ImageIO.read(bais);
        File outputFile = new File(fileName);
        ImageIO.write(image, "png", outputFile);
    }
}
