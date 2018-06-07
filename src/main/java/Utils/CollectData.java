/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Container.Competition;
import Container.Country;
import Container.Standing;
import com.mycompany.socceranalyzer.Soccer;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author patryk
 */
public class CollectData {

    public static void DownloadData() throws IOException {
        FilLCountries();
        FilLCompetitions();
        FilLStandings();
    }

    private static void FilLCountries() {
        List<Country> countries = null;
        try {
            countries = WebMethod.GetAllCountries();
        } catch (IOException ex) {
            Logger.getLogger(Soccer.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (Country c : countries) {
            System.out.println(c.toString());
        }

        Global.Countries = countries;
    }

    private static void FilLCompetitions() throws IOException {
        List<Country> countries = Global.Countries;
        HashMap<Integer, List<Competition>> competitions = new HashMap<>();
        for (Country c : countries) {
            List<Competition> compForCountry = WebMethod.GetCompetitions(c.getCountry_id());
            competitions.put(c.getCountry_id(), compForCountry);
        }

        Global.Competitions = competitions;
    }

    private static void FilLStandings() throws IOException {
        HashMap<Integer, List<Competition>> competitions = Global.Competitions;
        HashMap<Integer, List<Standing>> standings = new HashMap<>();
        for (Map.Entry<Integer, List<Competition>> item : competitions.entrySet()) {
            List<Competition> comp = item.getValue();
            for (Competition c : comp) {
                List<Standing> stand = WebMethod.GetStandings(c.getLeague_id());
                standings.put(c.getLeague_id(), stand);
            }
        }

        Global.Standings = standings;

    }
}
