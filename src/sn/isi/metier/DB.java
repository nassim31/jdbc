package sn.isi.metier;

import java.sql.*;

public class DB {
    //pour la connection
    private Connection cnx;
    //pour result de requete SELECT
    private ResultSet rs;
    //pour les requettes preparer
    private PreparedStatement pstm;

    public PreparedStatement getPstm() {
        return pstm;
    }

    //pour result de requete MISEaJOUR(MAJ) Insert Update Delete
    private int ok;


    private void getConnection(){
       /* String url="jdbc:mysql//localhost:3306/gestionFacture";*/
        String url="jdbc:mysql://127.0.0.1:3306/gestionFacture";
        String user="root";
        String password="lol";
        try {
        Class.forName("com.mysql.jdbc.Driver");
        cnx= DriverManager.getConnection(url,user,password);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public void initPrepar(String sql){

        try {
            getConnection();
            pstm=cnx.prepareStatement(sql);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public  ResultSet executSelect(){
        rs=null;
    try {
    rs=pstm.executeQuery();
    }catch (Exception ex){
        ex.printStackTrace();
    }
    return rs;
    }
    public int executeMaj(){
        try {
          ok=pstm.executeUpdate();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return ok;
    }
    public  void  closeConnection(){
        try {
            if (cnx!=null)
                cnx.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
