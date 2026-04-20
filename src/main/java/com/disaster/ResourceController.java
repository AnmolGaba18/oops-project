package com.disaster;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/resources")
@CrossOrigin("*")
public class ResourceController {

    private final ResourceService service;

    public ResourceController(ResourceService service) {
        this.service = service;
    }

    @GetMapping
    public List<Resource> getAllResources() {
        return service.getAllResources();
    }

    @PostMapping
    public Resource addResource(@RequestBody Resource resource) {
        return service.addResource(resource);
    }

    @PutMapping("/{id}")
    public Resource updateResource(@PathVariable Long id,
                                   @RequestBody Resource resource) {
        return service.updateResource(id, resource);
    }

    @DeleteMapping("/{id}")
    public void deleteResource(@PathVariable Long id) {
        service.deleteResource(id);
    }

    @GetMapping("/search/{keyword}")
    public List<Resource> searchResources(@PathVariable String keyword) {
        return service.searchByName(keyword);
    }

    @GetMapping("/disaster/{type}")
    public List<Resource> filterByDisaster(@PathVariable String type) {
        return service.filterByDisaster(type);
    }

    @GetMapping("/available/{status}")
    public List<Resource> filterByAvailability(@PathVariable boolean status) {
        return service.filterByAvailability(status);
    }

    @GetMapping("/type/{type}")
    public List<Resource> filterByType(@PathVariable String type) {
        return service.filterByType(type);
    }
