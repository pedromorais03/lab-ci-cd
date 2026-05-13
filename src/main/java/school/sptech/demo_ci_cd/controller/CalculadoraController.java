import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CalculadoraController {

    private final CalculadoraService calculadoraService;

    public CalculadoraController(CalculadoraService calculadoraService) {
        this.calculadoraService = calculadoraService;
    }

    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("UP");
    }

    @PostMapping("/soma/{a}/{b}")
    public ResponseEntity<Double> soma(@PathVariable double a, @PathVariable double b) {
        return ResponseEntity.ok(calculadoraService.somar(a, b));
    }

    @PostMapping("/subtracao/{a}/{b}")
    public ResponseEntity<Double> subtracao(@PathVariable double a, @PathVariable double b) {
        return ResponseEntity.ok(calculadoraService.subtrair(a, b));
    }

    @PostMapping("/multiplicacao/{a}/{b}")
    public ResponseEntity<Double> multiplicacao(@PathVariable double a, @PathVariable double b) {
        return ResponseEntity.ok(calculadoraService.multiplicar(a, b));
    }

    @PostMapping("/divisao/{a}/{b}")
    public ResponseEntity<Double> divisao(@PathVariable double a, @PathVariable double b) {
        return ResponseEntity.ok(calculadoraService.dividir(a, b));
    }
}