/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.socceranalyzer;

import Utils.CollectData;

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
