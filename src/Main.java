/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import views.*;
import com.sun.java.swing.*;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
/**
 *
 * @author hamil
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(new NimbusLookAndFeel());
        Login l = new Login();
        
        l.setVisible(true);
    }
    
}
