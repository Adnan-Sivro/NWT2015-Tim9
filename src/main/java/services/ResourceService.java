package services;

import dbclasses.Resource;

/**
 * Created by Adnan on 25.3.2015..
 */
public class ResourceService {

    public Resource updateResource(int idresource) {
        Resource resource = new Resource();
        try {

            resource.setIdresource(idresource);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }


        return resource;

    }

}