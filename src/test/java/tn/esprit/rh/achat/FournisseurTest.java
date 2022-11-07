package tn.esprit.rh.achat;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.rh.achat.entities.DetailFournisseur;
import tn.esprit.rh.achat.entities.Fournisseur;
import tn.esprit.rh.achat.repositories.DetailFournisseurRepository;
import tn.esprit.rh.achat.repositories.FournisseurRepository;
import tn.esprit.rh.achat.services.FournisseurServiceImpl;
import tn.esprit.rh.achat.services.IFournisseurService;

import java.util.ArrayList;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;
import static tn.esprit.rh.achat.entities.CategorieFournisseur.CONVENTIONNE;

@RunWith(MockitoJUnitRunner.class)
public class FournisseurTest {

    @Mock
    FournisseurRepository rep ;
    @InjectMocks
    FournisseurServiceImpl service ;
    @Mock
    DetailFournisseurRepository detail ;


    private static final Logger l = LogManager.getLogger(AchatDevopsTest.class);

    @Test
    public void testAjouterFournisseur() {

        //given
        Fournisseur fournisseur = new Fournisseur();
        //when
        service.addFournisseur(fournisseur);
        ;
        //then
        ArgumentCaptor<Fournisseur> saArgumentCaptor = ArgumentCaptor.forClass(Fournisseur.class);
        verify(rep).save(saArgumentCaptor.capture());

        Fournisseur capturedsa = saArgumentCaptor.getValue();
        assertThat(capturedsa).isEqualTo(fournisseur);
    }
        @Test
        public void retreiveAllSecteurActiviteTest () {

            service.retrieveAllFournisseurs();
            verify(rep).findAll();

        }

        @Test
        public void deleteOperateur() {

        service.deleteFournisseur(1L);
        verify(rep).deleteById(1L);

    }

        @Test
        public void updateOperateur() {
        Fournisseur sa = new Fournisseur();
        sa.setCode("test");
        Fournisseur sa1 = service.updateFournisseur(sa) ;

        assertThat(sa1.getCode()).isEqualTo("test") ;

    }

    }

