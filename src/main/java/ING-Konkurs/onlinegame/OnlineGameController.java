package com.example.myapp;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/onlinegame")
public class OnlineGameController {

    @PostMapping(value = "/calculate", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<List<Clan>>> calculateOrder(@RequestBody Players players) {

        int groupCount = players.getGroupCount();
        List<Clan> clans = players.getClans();
        List<List<Clan>> groups = new ArrayList<>(Collections.nCopies(groupCount, new ArrayList<>()));

        // Sort clans by points descending, number of players ascending
        Comparator<Clan> comparator = Comparator.comparing(Clan::getPoints).reversed().thenComparing(Clan::getNumberOfPlayers);
        Collections.sort(clans, comparator);

        // Assign clans to groups
        for (Clan clan : clans) {
            int groupIndex = findGroupIndex(groups, clan);
            groups.get(groupIndex).add(clan);
        }

        return new ResponseEntity<>(groups, HttpStatus.OK);
    }

    private int findGroupIndex(List<List<Clan>> groups, Clan clan) {
        int minIndex = 0;
        int minScore = Integer.MAX_VALUE;

        for (int i = 0; i < groups.size(); i++) {
            List<Clan> group = groups.get(i);

            if (group.isEmpty()) {
                return i;
            }

            int score = calculateGroupScore(group);

            if (group.size() < group.get(0).getNumberOfPlayers() && score + clan.getPoints() <= minScore) {
                minIndex = i;
                minScore = score + clan.getPoints();
            }
        }

        return minIndex;
    }

    private int calculateGroupScore(List<Clan> group) {
        int score = 0;
        for (Clan clan : group) {
            score += clan.getPoints();
        }
        return score;
    }
}
