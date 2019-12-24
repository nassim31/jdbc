package sn.isi.metier;

import sn.isi.entities.Reglement;

import java.text.SimpleDateFormat;

public class ReglementImp implements IReglement {
    private DB db=new DB();
    private int ok;
    @Override
    public int add(Reglement r) {
        String sql="INSERT INTO reglement (NULL,?,?)";
        try {
           db.initPrepar(sql);
           //gestion de date en java
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
           db.getPstm().setString(1,sdf.format(r.getDate()));
           db.getPstm().setInt(2,r.getFacture().getIdF());
           ok=db.executeMaj();
           db.closeConnection();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return ok;
    }
}
