import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraServiceTest {

    // ──────────────────────────────────────────
    // SOMAR
    // ──────────────────────────────────────────

    @Test
    @DisplayName("Quando acionado com 3 e 2, então deve retornar 5")
    public void testSomar() {
        // Arrange
        CalculadoraService calculadoraService = new CalculadoraService();
        double a = 3;
        double b = 2;
        double esperado = 5;

        // Act
        double resultado = calculadoraService.somar(a, b);

        // Assert
        assertEquals(esperado, resultado);
    }

    // ──────────────────────────────────────────
    // SUBTRAIR
    // ──────────────────────────────────────────

    @Test
    @DisplayName("Quando acionado com 10 e 4, então deve retornar 6")
    public void testSubtrair() {
        // Arrange
        CalculadoraService calculadoraService = new CalculadoraService();
        double a = 10;
        double b = 4;
        double esperado = 6;

        // Act
        double resultado = calculadoraService.subtrair(a, b);

        // Assert
        assertEquals(esperado, resultado);
    }

    // ──────────────────────────────────────────
    // MULTIPLICAR
    // ──────────────────────────────────────────

    @Test
    @DisplayName("Quando acionado com 3 e 4, então deve retornar 12")
    public void testMultiplicar() {
        // Arrange
        CalculadoraService calculadoraService = new CalculadoraService();
        double a = 3;
        double b = 4;
        double esperado = 12;

        // Act
        double resultado = calculadoraService.multiplicar(a, b);

        // Assert
        assertEquals(esperado, resultado);
    }

    // ──────────────────────────────────────────
    // DIVIDIR
    // ──────────────────────────────────────────

    @Test
    @DisplayName("Quando acionado com 10 e 2, então deve retornar 5")
    public void testDividir() {
        // Arrange
        CalculadoraService calculadoraService = new CalculadoraService();
        double a = 10;
        double b = 2;
        double esperado = 5;

        // Act
        double resultado = calculadoraService.dividir(a, b);

        // Assert
        assertEquals(esperado, resultado);
    }

    @Test
    @DisplayName("Quando divisor é zero, então deve lançar ResponseStatusException com BAD_REQUEST")
    public void testDividirPorZero() {
        // Arrange
        CalculadoraService calculadoraService = new CalculadoraService();
        double a = 10;
        double b = 0;

        // Act & Assert
        ResponseStatusException exception = assertThrows(
                ResponseStatusException.class,
                () -> calculadoraService.dividir(a, b)
        );

        assertEquals(HttpStatus.BAD_REQUEST, exception.getStatusCode());
        assertEquals("Divisão por zero não permitida", exception.getReason());
    }
}