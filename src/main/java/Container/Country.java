/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Container;

import lombok.Data;

/**
 *
 * @author patryk
 */
@Data
public class Country {

    private int country_id;
    private String country_name;

    @Override
    public String toString() {
        return country_id + ";" + country_name;
    }

}
