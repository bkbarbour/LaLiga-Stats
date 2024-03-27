package com.bbarb75.laligastats.Services;

import com.bbarb75.laligastats.API.MyApiClient;
import com.bbarb75.laligastats.Entities.Player;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerService {
    private final MyApiClient apiClient;

    @Autowired
    public PlayerService(MyApiClient apiClient){
        this.apiClient = apiClient;
    }

    public List<Player> parseApiResponse(String jsonResponse){
        List<Player> players = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();

        try{
            JsonNode responseNode = mapper.readTree(jsonResponse).get("response");

            if (responseNode != null){
                for (JsonNode playerNode : responseNode){
                    JsonNode playerInfoNode = playerNode.get("player");
                    JsonNode statsNode = playerNode.get("statistics").get(0).get("goals");
                    JsonNode assistsNode = statsNode.get("assists");
                    JsonNode appearancesNode = playerNode.get("statistics").get(0).get("games");


                    String name = playerInfoNode.get("name").asText();
                    int goals = statsNode.get("total").asInt();
                    int assists = (assistsNode != null) ? assistsNode.asInt() : 0;
                    int appearances = appearancesNode.get("appearences").asInt();

                    Player player = new Player();
                    player.setPlayerName(name);
                    player.setGoalsScored(goals);
                    player.setAssistsGiven(assists);
                    player.setMatchesPlayed(appearances);

                    players.add(player);

                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }return players;
    }


    public String fetchScorers(){
        String apiUrl = "https://api-football-v1.p.rapidapi.com/v3/players/topscorers?league=140&season=2023";
        return apiClient.fetchDataFromApi(apiUrl);
    }

    public void testFetchScorers(){
        String response = fetchScorers();
        System.out.println("Response from API: " + response);
    }

    public List<Player> getPlayersList(String jsonResponse){
        return parseApiResponse(jsonResponse);
    }

}
