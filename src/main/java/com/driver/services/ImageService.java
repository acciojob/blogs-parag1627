package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.*;
import javassist.runtime.Inner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {

    @Autowired
    BlogRepository blogRepository2;
    @Autowired
    ImageRepository imageRepository2;

    public Image addImage(Integer blogId, String description, String dimensions){
        //add an image to the blog
          Image image = new Image();
          Blog blog = new Blog();
          image.setBlog(blog);
          image.setDescription(description);
          image.setDimensions(dimensions);
          blog.getImageList().add(image);
          blogRepository2.save(blog);
          return image;
    }

    public void deleteImage(Integer id){
     imageRepository2.deleteById(id);
    }

    public int countImagesInScreen(Integer id, String screenDimensions) {
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`
        String[] screenArray = screenDimensions.split("X");

        Image image = imageRepository2.findById(id).get();

        String imageDimentions = image.getDimensions();

        String[] imageArray = imageDimentions.split("X");

        int screen1 = Integer.parseInt(screenArray[0]);
        int screen2 = Integer.parseInt(screenArray[1]);

        int img1 = Integer.parseInt(imageArray[0]);
        int img2 = Integer.parseInt(imageArray[1]);

        return no_images(screen1,screen2,img1,img2);

    }
        private int no_images(int screen1 , int screen2, int img1, int img2) {
            int leng1 = screen1 / img1;
            int leng2 = screen2 / img2;

            return leng1 * leng2;
    }
}
//        String [] scrarray = screenDimensions.split("X"); //A=Length   X    B=Breadth
//
//        Image image = imageRepository2.findById(id).get();
//
//        String imageDimensions = image.getDimensions();
//        String [] imgarray = imageDimensions.split("X");
//
//        int scrl = Integer.parseInt(scrarray[0]); //A -- > integer
//        int scrb = Integer.parseInt(scrarray[1]); //B -- > integer
//
//        int imgl = Integer.parseInt(imgarray[0]); //A -- > integer
//        int imgb = Integer.parseInt(imgarray[1]); //B -- > integer
//
//        return no_Images(scrl,scrb,imgl,imgb);
//
//    }
//
//    private int no_Images(int scrl, int scrb, int imgl, int imgb) {
//        int lenC = scrl/imgl; //
//        int lenB = scrb/imgb;
//        return lenC*lenB;




