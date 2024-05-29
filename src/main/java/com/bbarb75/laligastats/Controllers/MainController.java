package com.bbarb75.laligastats.Controllers;

import com.bbarb75.laligastats.Entities.Player;
import com.bbarb75.laligastats.Services.PlayerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
@Controller
public class MainController {

    private final PlayerService playerService;
    private final List<Player> topScorers = new ArrayList<>();

    public MainController(PlayerService playerService){
        this.playerService = playerService;
    }

    @GetMapping("/home")
    public String getTopScorers(@RequestParam(value = "leagues", defaultValue= "select")String leagues, Model model){
        String jsonResponse;

        switch(leagues){
            case "Premier League":
                jsonResponse = playerService.fetchPremScorers();
                break;
            case "Ligue 1":
                jsonResponse = playerService.fetchLigue1Scorers();
                break;
            case "Bundesliga":
                jsonResponse = playerService.fetchBundesligaScorers();
                break;
            case "La Liga":
                /*jsonResponse = playerService.fetchLaLigaScorers(); //this should fix the page not navigating to the La Liga stats correctly after leaving it once
                break;*/
            default:
                jsonResponse = playerService.fetchLaLigaScorers();
                break;

        }
        //String jsonResponse = playerService.fetchLaLigaScorers();
        List<Player> players = playerService.parseApiResponse(jsonResponse);
        model.addAttribute("leagues", leagues);
        model.addAttribute("players", players);
        return "home";

    }



}
