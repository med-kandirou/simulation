import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import DTO.Simulation;

public class Testsimulation {
    @Test
    public void testSimulation(){
        Simulation s=new Simulation(10000,5.5,20);
        s.setMensualite();
        assertEquals(524.41,s.getMensualite());
    }
}
