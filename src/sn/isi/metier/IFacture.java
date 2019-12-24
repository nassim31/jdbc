package sn.isi.metier;

import sn.isi.entities.Facture;

import java.util.List;

public interface IFacture {
    int add(Facture f);
    List<Facture> liste();
    int update(Facture f);
}
