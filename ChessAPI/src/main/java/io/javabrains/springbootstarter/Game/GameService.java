package io.javabrains.springbootstarter.Game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    //    private List<Player> players = new ArrayList<>(Arrays.asList(
//            new Player("1", "bob"),
//                new Player("2", "joe"),
//                new Player("3", "dan")
//        ));
    public List<Game> getAllGames(String playerId){
        List<Game> games = new ArrayList<>();
        gameRepository.findByplayer1Id(playerId).forEach(games::add);
        return games;
    }
    public Game getGame(String id){
        //return players.stream().filter(u -> u.getId().equals(id)).findFirst().get();
        return gameRepository.findOne(id);
    }
    public void addGame(Game game){
        gameRepository.save(game);

    }
    public void updateGame(Game game){
        gameRepository.save(game) ;
    }
    public void deleteGame(String id){
        gameRepository.delete(id);
    }
}
