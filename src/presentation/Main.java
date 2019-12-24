package presentation;

import sn.isi.entities.Facture;
import sn.isi.entities.Reglement;
import sn.isi.metier.FactureImp;
import sn.isi.metier.IFacture;
import sn.isi.metier.IReglement;
import sn.isi.metier.ReglementImp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ParseException, IOException {
/*        Facture f= new Facture();
        String dt="2019-08-30";
        SimpleDateFormat form=new SimpleDateFormat("yyyy-MM-dd");
        f.setDate(form.parse(dt));
        f.setConsommation(9999);
        f.setPrix(9999);
        f.setPaiement(true);
        IFacture iFacture=new FactureImp();
        iFacture.add(f);*/
/*
        Reglement r=new Reglement();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        r.setDate(sdf.parse("2019-06-11"));

        Facture f=new Facture();
        f.setIdF(2);

        r.setFacture(f);
        //reglement de la facture 2
        IReglement ir=new ReglementImp();
        ir.add(r);
        //mise a jour de la facture
        f.setPaiement(true);
        IFacture iFacture=new FactureImp();
        iFacture.update(f);*/

        IFacture iFacture=new FactureImp();
        File etatFacture=new File("etatFacture.csv");
        List<Facture> factures=iFacture.liste();
        FileWriter writer=new FileWriter(etatFacture);
        writer.write("idF;date;cosommation;Prix;Paiement\n");
        for (Facture f:factures) {
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            String fact=f.getIdF()+";"
                    + sdf.format(f.getDate())+";"
                    +f.getConsommation()+";"
                    +f.getPrix()+";"
                    +f.isPaiement()+"\n";
            writer.write(fact);

        }
        writer.close();


    }
}
