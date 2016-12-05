 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.harlock.model;


import java.awt.image.BufferedImage;
import java.util.Random;
import java.io.ByteArrayInputStream;
import java.io.File;
import javax.imageio.ImageIO;
import sun.misc.BASE64Decoder;

/**
 *
 * @author kai
 */
public class Image {
    
    public String FixImg(String stt) throws Exception{
        
        try{
            Random gerador = new Random();
 
        int numero = gerador.nextInt(999999);
                String parts[] = stt.split(",");
                String imgPart = parts[1];
            BufferedImage image = null;
            byte[] imageByte;
            BASE64Decoder decoder = new BASE64Decoder();
            imageByte = decoder.decodeBuffer(imgPart);
            ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
            image = ImageIO.read(bis);
            bis.close();
            // write the image to a file
            
            File outputfile = new File("image3"+numero+".png");
            ImageIO.write(image, "png", outputfile);
            String rt ="image3"+numero+".png";
            return rt;
            }catch(Exception e){
                e.printStackTrace();
                throw new Exception(" "+e);
            }
        
    }
}
