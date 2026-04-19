package com.disaster;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ResourceService {

    private final ResourceRepository repository;

    public ResourceService(ResourceRepository repository) {
        this.repository = repository;
    }

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

        Resource existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Resource not found"));

        existing.setName(updatedResource.getName());
        existing.setType(updatedResource.getType());
        existing.setDisasterType(updatedResource.getDisasterType());
        existing.setSeverity(updatedResource.getSeverity());
        existing.setLatitude(updatedResource.getLatitude());
        existing.setLongitude(updatedResource.getLongitude());
        existing.setAvailable(updatedResource.isAvailable());

        return repository.save(existing);
    }

    public List<Resource> searchByName(String keyword) {
        return repository.findByNameContainingIgnoreCase(keyword);
    }

    public List<Resource> filterByDisaster(String disasterType) {
        return repository.findByDisasterTypeContainingIgnoreCase(disasterType);
    }

    public List<Resource> filterByType(String type) {
        return repository.findByTypeContainingIgnoreCase(type);
    }

    public List<Resource> filterByAvailability(boolean available) {
        return repository.findByAvailable(available);
    }
}