/*
 * 
 * You can use the following import statemets
 * 
 * import org.springframework.web.bind.annotation.*;
 * import java.util.*;
 * import org.springframework.beans.factory.annotation.Autowired;
 * 
 */

// Write your code here
package com.example.player.controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.player.repository.*;
import com.example.player.service.*;
import com.example.player.model.*;

@RestController
public class PlayerController {
    @Autowired
    public PlayerJpaService playerjpaService;

    @GetMapping("/players")
    public ArrayList<Player> getPlayers() {
        return playerjpaService.getPlayers();
    }

    @PostMapping("/players")
    public Player addPlayer(@RequestBody Player player) {
        return playerjpaService.addPlayer(player);
    }

    @GetMapping("/players/{playerId}")
    public Player getById(@PathVariable("playerId") int playerId) {
        return playerjpaService.getById(playerId);

    }

    @PutMapping("/players/{playerId}")
    public Player updatePlayer(@PathVariable("playerId") int playerId, @RequestBody Player player) {
        return playerjpaService.updatePlayer(playerId, player);

    }

    @DeleteMapping("/players/{playerId}")
    public void deletePlayer(@PathVariable("playerId") int playerId) {
      playerjpaService.deletePlayer(playerId);

    }
}
