package tn.esprit.rh.achat;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.rh.achat.entities.DetailFournisseur;
import tn.esprit.rh.achat.entities.Fournisseur;
import tn.esprit.rh.achat.repositories.DetailFournisseurRepository;
import tn.esprit.rh.achat.repositories.FournisseurRepository;
import tn.esprit.rh.achat.services.IFournisseurService;

import java.util.ArrayList;

import static tn.esprit.rh.achat.entities.CategorieFournisseur.CONVENTIONNE;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FournisseurTest {

    @Mock
    FournisseurRepository rep ;
    @Mock
    IFournisseurService service ;
    @Mock
    DetailFournisseurRepository detail ;


    private static final Logger l = LogManager.getLogger(AchatDevopsTest.class);

    @Test
    public void testAjouterFournisseur()
    {
        try {
            l.info("In testAjouterFournisseur():");
            Fournisseur fournisseur=new Fournisseur("testAjout", "testAjout");
            ArrayList<Fournisseur> liste1 =(ArrayList<Fournisseur>) rep.findAll();
            int size1=liste1.size();
            l.info(()->"nombre des fournisseurs avant l'ajout: " +size1);
            l.info("Je vais ajouter un fournisseur.");
            int id =service.addFournisseur(fournisseur);
            ArrayList <Fournisseur> liste2 =(ArrayList<Fournisseur>) rep.findAll();
            int size2=liste2.size();
            l.info(()->"nombre d'entreprises apres l'ajout: " +size2);
            l.info("comparaison size avant et apres.");




        }
        catch (Exception e)
        { l.error(()->"Erreur dans testAjouterFournisseur() : " + e); }
    }

}
