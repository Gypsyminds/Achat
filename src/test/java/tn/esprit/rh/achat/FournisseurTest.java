package tn.esprit.rh.achat;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import tn.esprit.rh.achat.entities.Fournisseur;

import tn.esprit.rh.achat.repositories.FournisseurRepository;
import tn.esprit.rh.achat.services.FournisseurServiceImpl;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)
public class FournisseurTest {

    @Mock
    private  FournisseurRepository rep ;
    @InjectMocks
    private FournisseurServiceImpl service ;



    //private static final Logger l = LogManager.getLogger(AchatDevopsTest.class);

    @Test
    public void testAjouterFournisseur() {

        //given
        Fournisseur fournisseur = new Fournisseur("test","test");
        //when
        service.addFournisseur(fournisseur);

        //then
        ArgumentCaptor<Fournisseur> saArgumentCaptor = ArgumentCaptor.forClass(Fournisseur.class);
        verify(rep).save(saArgumentCaptor.capture());

        Fournisseur capturedsa = saArgumentCaptor.getValue();
        assertThat(capturedsa).isEqualTo(fournisseur);
    }




    }

