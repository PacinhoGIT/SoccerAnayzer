/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 *
 * @author patryk
 */
public class Web {

    private static final String API_KEY = "3f19cf038ac252c67921b2733ff4280124a7e2c59b457c705c810eb0b57a6761";
    private static final String CoutryRequest = "https://apifootball.com/api/?action=get_countries&APIkey=";
    private static final String CompetitionsRequest = "https://apifootball.com/api/?action=get_leagues&country_id=#&APIkey=";
    private static final String StandingsRequest = "https://apifootball.com/api/?action=get_standings&league_id=#&APIkey=";

    public static String getCountryRequest() {
        return CoutryRequest + API_KEY;
    }

    public static String getCompetitionsRequest(int countryID) {
        return CompetitionsRequest.replace("#", "" + countryID) + API_KEY;
    }
    
     public static String getStandingsRequest(int leagueID) {
        return StandingsRequest.replace("#", "" + leagueID) + API_KEY;
    }


    public static String getResponseFromService(String endpoint) throws MalformedURLException, ProtocolException, IOException, ProtocolException {

        URL url = new URL(endpoint);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        if (conn.getResponseCode() != 200) {
            System.out.println("Error ! Cannot download Data from Server.");
            throw new RuntimeException("Failed : HTTP error code : "
                    + conn.getResponseCode());
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(
                (conn.getInputStream())));

        String response = "";
        String output;
        System.out.println("Output from Server .... \n");
        while ((output = br.readLine()) != null) {
            response += output;
        }

        return response;
    }
}
