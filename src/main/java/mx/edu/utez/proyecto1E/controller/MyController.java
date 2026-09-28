package mx.edu.utez.proyecto1E.controller;

import jakarta.validation.Valid;
import mx.edu.utez.proyecto1E.controller.dto.RequestBodyDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin({"*"})
@RequestMapping("/my-services")
public class MyController {

    @GetMapping
    public String miPrimerServicio (){
        return "Hola mundo";
    }

    @GetMapping("/servicio2")
    public String servicio2(){
        return "servicio 2";
    }

    @PostMapping
    public String servicio(){
        return "servicio 3";
    }

    ///
    @GetMapping("/path/{id}")
    public String pathVariable(@PathVariable String id){
        return "el valor recibido fue: " + id;
    }

    @PostMapping("/body")
    public ResponseEntity<RequestBodyDTO> body(@RequestBody @Valid RequestBodyDTO payload){

        System.out.println(payload.getNombre());
        System.out.println(payload.getCurp());
        System.out.println(payload.getEdad());
        System.out.println(payload.getCorreo());

        return ResponseEntity
                .status(201)
                .body(payload);
    }
}
