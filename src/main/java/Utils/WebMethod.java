/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Container.Competition;
import Container.Country;
import Container.Standing;
import com.google.gson.Gson;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author patryk
 */
public class WebMethod {

    public static List<Country> GetAllCountries() throws MalformedURLException, IOException {

        String response = Web.getResponseFromService(Web.getCountryRequest());

        Type listType = new TypeToken<ArrayList<Country>>(){}.getType();
        List<Country> countries = new Gson().fromJson(response, listType);

        return countries;
    }
    
     public static List<Competition> GetCompetitions(int countryID) throws MalformedURLException, IOException {

        String response = Web.getResponseFromService(Web.getCompetitionsRequest(countryID));

        Type listType = new TypeToken<ArrayList<Competition>>(){}.getType();
        List<Competition> competitions = new Gson().fromJson(response, listType);
        return competitions;
    }
     
      public static List<Standing> GetStandings(int leagueID) throws MalformedURLException, IOException {

        String response = Web.getResponseFromService(Web.getStandingsRequest(leagueID));

        Type listType = new TypeToken<ArrayList<Standing>>(){}.getType();
        List<Standing> standings = new Gson().fromJson(response, listType);
        return standings;
    }

}
