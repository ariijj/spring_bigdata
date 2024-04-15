package com.example.BigData.Controller;

import com.example.BigData.Entity.Actor;
import com.example.BigData.Repo.ActorRepository;
import com.example.BigData.Service.ActorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/api")

@RestController
public class ActorController {
    private  ActorService actorService;
    private  ActorRepository actorRepository;
    public ActorController(ActorService actorService, ActorRepository actorRepository) {
        this.actorService = actorService;
        this.actorRepository = actorRepository;
    }
    @GetMapping("/getAll")
    public List<Actor> getAllActors() {
        return actorService.getAllActors();
    }

    @PostMapping("/actors")
    public Actor createActor(@RequestBody Map<String, Object> actorMap) {
        String id = (String) actorMap.get("id");
        String name = (String) actorMap.get("name");
        return actorService.createActor(id,name, actorMap);
    }
   /* @DeleteMapping("/{id}")
    public void deleteActor(@PathVariable String id ){
        actorService.deleteActor(id);

    }*/
/*
    @PostMapping("/actor/{id}")
    public Actor updateActor(@PathVariable String id, @RequestBody Map<String, Object> payload) {
        return actorService.updateActor(id,payload);

    }*/

}
