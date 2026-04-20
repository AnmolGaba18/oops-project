package com.disaster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResourceService {

    @Autowired
    private ResourceRepository repository;


    public List<Resource> getAllResources() {
        return repository.findAll();
    }


    public Resource addResource(Resource resource) {
        return repository.save(resource);
    }


    public void deleteResource(Long id) {
        repository.deleteById(id);
    }


    public Resource updateResource(Long id, Resource updatedResource) {

        Optional<Resource> existing = repository.findById(id);

        if(existing.isPresent()) {

            Resource resource = existing.get();

            resource.setName(updatedResource.getName());
            resource.setType(updatedResource.getType());
            resource.setDisaster(updatedResource.getDisaster());
            resource.setSeverity(updatedResource.getSeverity());
            resource.setLatitude(updatedResource.getLatitude());
            resource.setLongitude(updatedResource.getLongitude());
            resource.setAvailable(updatedResource.isAvailable());

            return repository.save(resource);
        }

        return null;
    }


    // SEARCH METHODS REQUIRED BY CONTROLLER


    public List<Resource> searchByName(String name) {
        return repository.findByNameContainingIgnoreCase(name);
    }


    public List<Resource> filterByDisaster(String disaster) {
        return repository.findByDisaster(disaster);
    }


    public List<Resource> filterByAvailability(boolean available) {
        return repository.findByAvailable(available);
    }


    public List<Resource> filterByType(String type) {
        return repository.findByType(type);
    }

}
