package services;

import com.sun.jersey.spi.resource.Singleton;
import dbclasses.ResourceType;

/**
 * Created by Enes on 31.3.2015..
 */
@Singleton
public class ResourceTypeService {

    public ResourceType updateResourceType(int idresourceType)
    {
        ResourceType restype = new ResourceType();
        restype.setIdresourceType(idresourceType);
        return  restype;
    }
}
