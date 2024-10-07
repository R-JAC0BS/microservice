package br.edu.atitus.paradigma.cambioservice.Controller;


import br.edu.atitus.paradigma.cambioservice.Entity.CambioEntity;
import br.edu.atitus.paradigma.cambioservice.repositorys.CambioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cambio")
public class CambioController {

    private final CambioEntity cambioEntity = new CambioEntity();

    @Autowired
    private CambioRepository cambioRepository;

    @GetMapping("/{valor}/{origem}/{destino}")
    public CambioEntity getCambio(@PathVariable double valor,
                                  @PathVariable String origem,
                                  @PathVariable String destino) throws Exception {

        try {
            CambioEntity cambio = cambioRepository.findByOrigemAndDestino(origem, destino);
            double valorConvertido = valor * cambio.getFator();
            cambio.setValorConvertido(valorConvertido);
            cambio.setAmbiente("Porta 8100");
            return cambio;
        }catch (Exception e){
            throw new Exception("Não foi possivel realizar operção");
        }

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exception(Exception e) {
        String cleanMessage = e.getMessage().replaceAll("[\\r\\n]", "");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(cleanMessage);
    }
}
