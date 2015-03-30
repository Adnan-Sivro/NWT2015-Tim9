package services;

import com.sun.jersey.spi.resource.Singleton;
import dbclasses.Image;
import dbclasses.User;

/**
 * Created by Enes on 30.3.2015..
 */
@Singleton
public class ImageService {

    public Image updateImage(int idimage) {
        Image image = new Image();
        image.setIdimage(idimage);
        return image;
    }

    public Image createImage(Image image) {

        return image;
    }

}
