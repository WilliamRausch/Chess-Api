package io.javabrains.springbootstarter.Game;

import io.javabrains.springbootstarter.user.Player;
import io.javabrains.springbootstarter.Game.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GameController {

    @Autowired
    private GameService gameService;

    @RequestMapping("/Players/{playerId}/Games")
    public List<Game> getAllGames(@PathVariable String playerId){
        return gameService.getAllGames(playerId);
    }
    @RequestMapping("/Players/{playerId}/Games/{gameId}")
    public Game getGame(@PathVariable String gameId){
        return gameService.getGame(gameId);
    }
    @RequestMapping(method= RequestMethod.POST, value="/Players/{playerId}/Games")
    public void addGame(@RequestBody Game game, @PathVariable String playerId){
        game.setPlayer1(new Player(playerId, "")) ;
        gameService.addGame(game);

    }
    @RequestMapping(method= RequestMethod.PUT, value="/Players/{playerId}/Games/{gameId}")
    public void updateGame(@RequestBody Game game, @PathVariable String gameId, String playerId){
        game.setPlayer1(new Player(playerId, "")) ;
        gameService.updateGame(game);

    }
    @RequestMapping(method= RequestMethod.DELETE, value="/Players/{playerId}/Games/{gameId}")
    public void deleteGame( @PathVariable String gameId){
        gameService.deleteGame(gameId);

    }
}
