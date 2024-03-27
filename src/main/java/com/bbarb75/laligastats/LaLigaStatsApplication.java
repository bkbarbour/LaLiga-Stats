package com.bbarb75.laligastats;

import com.bbarb75.laligastats.API.MyApiClient;
import com.bbarb75.laligastats.Entities.Player;
import com.bbarb75.laligastats.Services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LaLigaStatsApplication implements CommandLineRunner {

    @Autowired
    private PlayerService playerService;

    public static void main(String[] args) {
        SpringApplication.run(LaLigaStatsApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
//        playerService.testFetchScorers();
//        //System.out.println(playerService.parseApiResponse(playerService.fetchScorers()));
//        String resultAsString = playerService.parseApiResponse(playerService.fetchScorers()).toString();
//        System.out.println(resultAsString);
    }
}
