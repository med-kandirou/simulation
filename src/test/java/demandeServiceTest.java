import DAO.ImpDemandeCredit;
import DTO.DemandeCredit;
import DTO.Historique;
import Services.DemandeService;
import org.junit.Test;
import DTO.Client;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class demandeServiceTest {
    DemandeService demandeService;
    @Mock
    ImpDemandeCredit impDemandeCredit;

    @Before
    public void setUp(){
        MockitoAnnotations.openMocks(this);
        demandeService = new DemandeService(impDemandeCredit);
    }

    @Test
    public void testAdd(){
        Client c= new Client();
        c.setCode("code1");
        DemandeCredit demandeCredit = new DemandeCredit(5.0, 10000.0, 500.0, 12, "Remarques", c);
        when(demandeService.add(demandeCredit)).thenReturn(Optional.of(demandeCredit));
        Optional<DemandeCredit> result = demandeService.add(demandeCredit);
        assertTrue(result.isPresent());
        assertEquals(demandeCredit,result.get());
        verify(impDemandeCredit).add(demandeCredit);
    }

    @Test
    public void getall(){
        List<DemandeCredit> listdemande= new ArrayList<>();
        listdemande.add(new DemandeCredit());
        listdemande.add(new DemandeCredit());
        when(demandeService.getAll()).thenReturn(listdemande);
        List<DemandeCredit> result = demandeService.getAll();
        assertEquals(result.size(),2);
        verify(impDemandeCredit).getAll();
    }

    @Test
    public void getbydate(){
        List<DemandeCredit> listdemande= new ArrayList<>();
        listdemande.add(new DemandeCredit());
        when(demandeService.getbydate(LocalDate.of(2001,12,23))).thenReturn(listdemande);
        List<DemandeCredit> result = demandeService.getbydate(LocalDate.now());
        assertEquals(result.size(),0);
        verify(impDemandeCredit).getbydate(LocalDate.now());
    }

    @Test
    public void getbyetat(){
        List<DemandeCredit> listdemande= new ArrayList<>();
        listdemande.add(new DemandeCredit());
        when(demandeService.getbyetat("refuse")).thenReturn(listdemande);
        List<DemandeCredit> result = demandeService.getbyetat("refuse");
        assertEquals(result.size(),1);
        verify(impDemandeCredit).getbyetat("refuse");
    }

    @Test
    public void historique(){
        List<Historique> historiques= new ArrayList<>();
        historiques.add(new Historique());
        when(demandeService.getHistorique(1)).thenReturn(historiques);
        List<Historique> result = demandeService.getHistorique(1);
        assertEquals(result.size(),1);
        verify(impDemandeCredit).getHistorique(1);
    }

    @Test
    public void updateStatus(){
        DemandeCredit d= new DemandeCredit();
        d.setEtat("refuse");
        when(demandeService.updateStatus(1,"refuse")).thenReturn(Optional.of(d));
        Optional<DemandeCredit> opt = demandeService.updateStatus(1,"refuse");
        assertEquals(opt.get().getEtat(),"refuse");
        verify(impDemandeCredit).updateStatus(1,"refuse");
    }


}
