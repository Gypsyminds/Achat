package tn.esprit.rh.achat;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.rh.achat.entities.Fournisseur;

import tn.esprit.rh.achat.repositories.FournisseurRepository;
import tn.esprit.rh.achat.services.FournisseurServiceImpl;


import java.util.ArrayList;


@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class FournisseurTest {

    @Mock
    private FournisseurRepository rep;
    @InjectMocks
    private FournisseurServiceImpl service;


    private static final Logger l = LogManager.getLogger(AchatDevopsTest.class);


    @Test
    public void shouldReturnAllFournisseurs() {
        l.info("In testAjouterEntreprise():");
        Fournisseur fournisseur = new Fournisseur("testAjout", "testAjout");
        ArrayList<Fournisseur> liste1 = (ArrayList<Fournisseur>) rep.findAll();
        int size1 = liste1.size();
        l.info(() -> "nombre d'entreprises avant l'ajout: " + size1);
        l.info("Je vais ajouter une entreprise.");

        int id = service.addFournisseur(fournisseur);
        ArrayList<Fournisseur> liste2 = (ArrayList<Fournisseur>) rep.findAll();
        int size2 = liste2.size();
        l.info(() -> "nombre d'entreprises apres l'ajout: " + size2);
        l.info("comparaison size avant et apres.");

    }
}