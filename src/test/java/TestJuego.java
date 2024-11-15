import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*; // Ajout des assertions JUnit 5
import dsa.examples.mocking.FachadaJuego;
import dsa.examples.mocking.InterfazJuego;
import dsa.examples.mocking.Usuario;
import dsa.examples.mocking.PuntoInteres;
import dsa.examples.mocking.ElementType;

import java.util.List;

public class TestJuego {
    private InterfazJuego service;

    @BeforeEach
    public void setUp() {
        service = FachadaJuego.getInstance();
    }

    @Test
    public void testAddAndRetrieveUser() {
        service.addUser(1, "John", "Doe", "john@example.com", "1/1/2002");
        Usuario user = service.getUserById(1);
        assertNotNull(user);
        assertEquals("John", user.getNombre());
        assertEquals("Doe", user.getApellidos());
    }

    @Test
    public void testAddAndRetrievePointOfInterest() {
        service.addPointOfInterest(0, 1, ElementType.DOOR);
        List<PuntoInteres> doors = service.getPointsByType(ElementType.DOOR);
        assertFalse(doors.isEmpty());
        assertEquals(0, doors.get(0).getCoordenadaX());
        assertEquals(1, doors.get(0).getCoordenadaY());
    }

    @Test
    public void testRecordTransit() {
        service.addUser(2, "Jane", "Smith", "jane@example.com", "27/09/2005");
        service.addPointOfInterest(2, 3, ElementType.BRIDGE);
        service.recordTransit(2, 2, 3);
        List<PuntoInteres> points = service.getUserTransitPoints(2);
        assertFalse(points.isEmpty());
        assertEquals(ElementType.BRIDGE, points.get(0).getTipo());
    }
}
