package com.slimani.reservationservice.feign;

import com.slimani.reservationservice.exceptions.ResourceNotFoundException;
import com.slimani.reservationservice.model.Resource;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "resource-service")
public interface ResourceFeignClientService {
    // Save a new Resource
    @PostMapping("/resources")
    Resource saveResource(@RequestBody Resource resource);

    // Get All Resources
    @GetMapping("/resources")
    List<Resource> getResources();

    // Get Resource By Id
    @GetMapping("/resources/{id}")
    Resource getResourceById(@PathVariable String id) throws ResourceNotFoundException;

    // Delete Resource
    @DeleteMapping("/resources/{id}")
    void deleteResource(@PathVariable String id) throws ResourceNotFoundException;

    // Patch Resource
    @PutMapping("/resources/{id}")
    Resource patchResource(@PathVariable String id, Resource resource) throws ResourceNotFoundException;
}
