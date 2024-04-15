package com.example.BigData.Service;

import com.example.BigData.Entity.Actor;
import com.example.BigData.Entity.Movie;
import com.example.BigData.Repo.ActorRepository;
import com.example.BigData.Repo.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ActorService {


    @Autowired

    private  ActorRepository actorRepository;
    private MovieRepository movieRepository;
    private MovieService movieService;

    public ActorService(ActorRepository actorRepository, MovieRepository movieRepository, MovieService movieService) {
        this.actorRepository = actorRepository;
        this.movieRepository = movieRepository;
        this.movieService = movieService;
    }

    public List<Actor> getAllActors() {
        return this.actorRepository.findAll();
    }
    public Actor createActor(String id, String name, Map<String, Object> payload) {
        Actor actor= new Actor(id, name);
        Map<String, Object> newRegisteredOnPayload = (Map<String, Object>) payload.getOrDefault("ACTED_IN", actor.getACTED_IN());

        String movieUri = (String) newRegisteredOnPayload.getOrDefault("uri", "");
        Optional<Movie> movie = movieService.findByUri(movieUri);

        if (movie.isPresent()) {
            actor.setACTED_IN(movie.get());

        } else {
            throw new RuntimeException("movie not found");
        }

        return actorRepository.save(actor);


    }

    /*public void deleteActor(String id) {
        Optional<Actor> actor= actorRepository.findById(id);
        if (actor.isPresent()) {
            actorRepository.delete(actor.get());
        } else {
            throw new RuntimeException("Account not found");
        }
    }*/
  /*  public Actor updateActor(String id,Map<String, Object> payload){

        Optional<Account> existingAccount = accountRepository.findById(id);
        if (existingAccount.isPresent()) {
            Account account = existingAccount.get();
            String newUsername = (String) payload.getOrDefault("username", account.getUsername());
            String newDisplayName = (String) payload.getOrDefault("displayName", account.getDisplayName());

            account.setUsername(newUsername);
            account.setDisplayName(newDisplayName);
            Map<String, Object> registeredOnPayload = (Map<String, Object>) payload.getOrDefault("registeredOn", null);
            if (registeredOnPayload != null) {
                String serverUri = (String) registeredOnPayload.getOrDefault("uri", "");
                Optional<Server> existingServerOptional = serverRepository.findByUri(serverUri);
                if (existingServerOptional.isPresent()) {

                    Server existingServer = existingServerOptional.get();
                    if (account.getRegisteredOn() != null) {
                        Server registeredOnServer = account.getRegisteredOn();
                        accountRepository.deleteRegisteredOnRelationship(registeredOnServer.getUri());
                    }
                    if (!existingServer.equals(account.getRegisteredOn())) {
                        account.setRegisteredOn(existingServer);

                    }
                } else {
                    throw new RuntimeException("Server not found");
                }
            }



            List<Map<String, Object>> newFollowsPayload = (List<Map<String, Object>>) payload.getOrDefault("follows", account.getFollows());
            for (Map<String, Object> followPayload : newFollowsPayload) {
            }
            return accountRepository.save(account);
        }else {
            throw new RuntimeException("Account not found");
        }
    }*/
    /*

    private List<Account> newAccountsFromPayload(List<Map<String, Object>> payload) {
        if (payload == null || payload.isEmpty()) {
            return null;
        }

        List<Account> follows = new ArrayList<>();
        for (Map<String, Object> accountPayload : payload) {
            String id = (String) accountPayload.get("id");
            String username = (String) accountPayload.get("username");
            String displayName = (String) accountPayload.get("displayName");

            Optional<Account> existingFollow = accountRepository.findById(id);
            Account follow = existingFollow.orElse(new Account(id, username, displayName));

            follows.add(follow);
        }

        return follows;
    }*/
}
