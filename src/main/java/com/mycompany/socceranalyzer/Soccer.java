/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.socceranalyzer;

import Container.Country;
import Utils.CollectData;
import Utils.Global;
import Utils.Web;
import Utils.WebMethod;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author patryk
 */
public class Soccer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            CollectData.DownloadData();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

}
