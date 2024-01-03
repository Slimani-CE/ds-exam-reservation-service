package com.slimani.reservationservice.controller;

import com.slimani.reservationservice.exceptions.ResourceNotFoundException;
import com.slimani.reservationservice.feign.ResourceFeignClientService;
import com.slimani.reservationservice.model.Resource;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@OpenAPIDefinition
@RequestMapping("/resources")
public class ResourceRestController {
    private final ResourceFeignClientService resourceFeignClientService;

    public ResourceRestController(ResourceFeignClientService resourceFeignClientService) {
        this.resourceFeignClientService = resourceFeignClientService;
    }

    // Save a new resource
    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Resource> saveResource(@RequestBody Resource resource) {
        return ResponseEntity.ok(resourceFeignClientService.saveResource(resource));
    }

    // Get all resources
    @GetMapping
    @PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<List<Resource>> getAllResources() {
        return ResponseEntity.ok(resourceFeignClientService.getResources());
    }

    // Get Resource By Id
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<Resource> getResourceById(@PathVariable String id) {
        try {
            return ResponseEntity.ok(resourceFeignClientService.getResourceById(id));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete Resource
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Void> deleteResource(@PathVariable String id) {
        try {
            resourceFeignClientService.deleteResource(id);
            return ResponseEntity.ok().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Patch Resource
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Resource> patchResource(@PathVariable String id, @RequestBody Resource resource) {
        try {
            return ResponseEntity.ok(resourceFeignClientService.patchResource(id, resource));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
