package com.jobtracker.backend.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobtracker.backend.service.PlacementProfileService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/api/placement-profiles")
public class PlacementProfileAPI {

    @Autowired
    private PlacementProfileService placementProfileService;
    


        @GetMapping
        public Object getAllPlacementProfiles() {
        return placementProfileService.getAllPlacementProfiles();
        }

    @PostMapping
    public Object createPlacementProfile(@RequestBody Object placementProfile) {
        return placementProfileService.createPlacementProfile((com.jobtracker.backend.model.PlacementProfile) placementProfile);
    }

    @GetMapping("/{id}")
    public Object getPlacementProfileById(@PathVariable Long id) {
        return placementProfileService.getPlacementProfileById(id);
    }


    @PutMapping("/{id}")
    public Object updatePlacementProfile(@PathVariable Long id, @RequestBody Object updatedProfile) {
        return placementProfileService.updatePlacementProfile(id, (com.jobtracker.backend.model.PlacementProfile) updatedProfile);
    }

    @PostMapping("/{id}")
    public void deletePlacementProfile(@PathVariable Long id) {
        placementProfileService.deletePlacementProfile(id);
    }

   



    
}
