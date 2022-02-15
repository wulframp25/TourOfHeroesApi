package co.udea.hero.api.controller;

import co.udea.hero.api.model.Hero;
import co.udea.hero.api.service.HeroService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/heroes")
public class HeroController {

    private final Logger log = LoggerFactory.getLogger(HeroController.class);

    private HeroService heroService;

    public HeroController(HeroService heroService) {
        this.heroService = heroService;
    }

    @GetMapping("{id}")
    @ApiOperation(value = "Busca un hero por su id",  response = Hero.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Hero encontrado existosamente"),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<Hero> getHero(@PathVariable Integer id){
        log.info("Rest request buscar heroe por id");
        return ResponseEntity.ok(heroService.getHero(id));
    }

    @DeleteMapping("borrar/{id}")
    @ApiOperation(value = "Borrar un hero por su id",  response = Hero.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Hero Borrado existosamente"),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<Hero> deleteHero(@PathVariable Integer id){
        log.info("Rest request buscar heroe por id");
        return ResponseEntity.ok(heroService.deleteHero(id));
    }
    @PostMapping("crear")
    @ApiOperation(value = "Crear un heroe",  response = Hero.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Hero creado existosamente"),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<Hero> addHero(@RequestBody Hero hero) {
        return ResponseEntity.ok(heroService.addHero(hero));
    }

    @GetMapping()
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Heroes encontrados existosamente"),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<List<Hero>> getHeroes(){
        log.info("Rest request lista heroes");
        return ResponseEntity.ok(heroService.getHeroes());
    }
    @GetMapping("buscar/{name}")
    @ApiOperation(value = "Busca heroes por nombre",  response = Hero.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Hero encontrado existosamente"),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<Hero> searchHeroes(@PathVariable String name){
        log.info("Rest request buscar heroe por id");
        return ResponseEntity.ok(heroService.searchHeroes(name));
    }

    @PutMapping("actualizar")
    @ApiOperation(value = "Actualiza un heroe",  response = Hero.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Hero actualizado existosamente"),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<Hero> updateHero(@RequestBody Hero hero) {
        return ResponseEntity.ok(heroService.updateHero(hero));
    }


}
