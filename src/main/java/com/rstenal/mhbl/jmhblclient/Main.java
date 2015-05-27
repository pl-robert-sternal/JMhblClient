/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rstenal.mhbl.jmhblclient;

import com.rstenal.mhbl.jmhblclient.gui.MainWindow;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main {
    
    private static final String OSX_LAF_NAME = "Mac OS X";
    private static final String MHBL_WINDOW_TITLE = "Mhbl client";
    private static final String APPLICATION_NAME = "Mhbl Client";

    public static void main(String[] args) {
        for (UIManager.LookAndFeelInfo lafInfo : UIManager.getInstalledLookAndFeels()) {
            if (OSX_LAF_NAME.equals(lafInfo.getName())) {
                try {
                    System.setProperty("apple.laf.useScreenMenuBar", "true");
                    System.setProperty("com.apple.mrj.application.apple.menu.about.name", 
                            APPLICATION_NAME);
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException
                        | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }
        }
        
        SwingUtilities.invokeLater(() -> {
            MainWindow mw = new MainWindow();
            mw.setTitle(MHBL_WINDOW_TITLE);
            mw.setVisible(true);
        });
    }

}
