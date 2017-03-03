/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anna.nadhuira.cardmaker;

import anna.nadhuira.cardmaker.beans.Card;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;

/**
 *
 * @author ai
 */
public class Main {
    public static void main(String[]args){
        try {
            List<Card>l=genData();
            net.sf.jasperreports.engine.JasperPrint j=JasperFillManager.fillReport(JasperCompileManager.compileReport("card2.jrxml")
                    , new java.util.HashMap<String,Object>(),
                    new net.sf.jasperreports.engine.data.JRBeanCollectionDataSource(l));
            new Laporan(null, true, j).setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static List<Card> genData() {
        List<Card>l=new java.util.LinkedList<>();
        Card c=new Card();
        c.setComp("Ashura Kingdom");
        c.setFoto("me.jpg");
        c.setId("0001");
        c.setNama("Achmad Rifa'i");
        l.add(c);
        return l;
    }
}