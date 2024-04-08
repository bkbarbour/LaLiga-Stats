package com.bbarb75.laligastats.Controllers;

import com.bbarb75.laligastats.Entities.Player;
import com.bbarb75.laligastats.Services.PlayerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
    public String getTopScorers(Model model){
        String jsonResponse = playerService.fetchLaLigaScorers();
        List<Player> players = playerService.parseApiResponse(jsonResponse);
        model.addAttribute("players", players);
        return "home";

    }



}
