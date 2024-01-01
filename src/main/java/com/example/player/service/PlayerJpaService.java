/*
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * import java.util.*;
 * 
 */

// Write your code here
package com.example.player.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;

import com.example.player.model.Player;
import com.example.player.repository.PlayerRepository;
import com.example.player.repository.*;

@Service
public class PlayerJpaService implements PlayerRepository {

    @Autowired
    private PlayerJpaRepository playerjparepository;

    @Override
    public ArrayList<Player> getPlayers() {
        List<Player> list = playerjparepository.findAll();
        ArrayList<Player> arraylist = new ArrayList<>(list);
        return arraylist;
    }

    @Override
    public Player addPlayer(Player player) {
        playerjparepository.save(player);
        return player;

    }

    @Override
    public Player getById(int playerId) {
        try {
            Player player1 = playerjparepository.findById(playerId).get();
            return player1;

        } catch (Exception s) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public void deletePlayer(int playerId) {
        try {
            playerjparepository.deleteById(playerId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        }

    }

    @Override
    public Player updatePlayer(int playerId, Player player) {
        try {
            Player newPlayer = playerjparepository.findById(playerId).get();
            if (player.getPlayerName() != null) {
                newPlayer.setPlayerName(player.getPlayerName());
            }
            if (player.getRole() != null) {
                newPlayer.setRole(player.getRole());
            }
            if (player.getJerseyNumber() != 0) {
                newPlayer.setJerseyNumber(player.getJerseyNumber());

            }
            return newPlayer;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

}
