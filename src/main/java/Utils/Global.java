/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Container.Competition;
import Container.Country;
import Container.Standing;
import java.util.HashMap;
import java.util.List;
import lombok.Data;


/**
 *
 * @author patryk
 */
@Data
public class Global {

    public static List<Country> Countries;
    public static HashMap<Integer,List<Competition>> Competitions;
    public static HashMap<Integer,List<Standing>> Standings;
 
}
