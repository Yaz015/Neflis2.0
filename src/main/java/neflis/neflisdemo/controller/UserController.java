package neflis.neflisdemo.controller;

import neflis.neflisdemo.model.Contenido;
import neflis.neflisdemo.model.UserApi;
import neflis.neflisdemo.service.ContenidoService;
import neflis.neflisdemo.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class UserController {
    private UserService userService;
    private ContenidoService contenidoService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
   /* @GetMapping("/users/{id}")
    public List<UserApi> usuarioContenido(@PathVariable (value="id") Long id,
                                          @RestController (value="genre", required = false) String genre){
        return userService.featureContents(genre);
    }*/

   /* @GetMapping("/users")
    public List<UserApi> usuarioPorId(@RequestParam(value = "id", required = false) String id) {
        return userService.usuariosPorIdContenidoVisto(id);
    }//http://localhost:8080/users?id=1L*/

    /** Ejercicio 3**/
    @GetMapping("/users/{id}")
    public List<UserApi> usuarioContenido(@PathVariable(value = "id") String id,
                                          @RequestParam(value = "watched", required = false) String watched) {
        return userService.usuariosPorId(id);
    }  //http://localhost:8080/users/1L?watched

   /**Ejercicio2**/
    @GetMapping("/user/{id}")
    public List<UserApi> contenidoRuntimes (@PathVariable(value = "id") String id,
                                              @RequestParam(value="featured", required = false) String featured)
                                       // @RequestParam(value = "genre") String genre)
    { return userService.usuariosPorIdContenidoRecomendado(id);}

    @GetMapping("/userr/{id}")
    public List<UserApi> contenidoGeneroFav(@PathVariable(value = "id") String id,
                                            @RequestParam(value="genre", required = false) String genre)

    {   return userService.filtrarContenidoRecomendadoPor(id, genre);
}}
    /*@GetMapping("users/{id}/feature")
    public List<UserApi> usuarioContenidoNuevo(@PathVariable(value = "id") String id) {
        return userService.usuarioNuevoContenido(id);
    }}
    /*@GetMapping("users/{id}/nuevo2")
    public List<UserApi> usuarioContenidoNuevo2(@PathVariable(value = "id") String id,
                                               @RequestParam(value = "contenidoNuevo", required = false) String contenidoNuevo) {
        return userService.usuariosPorId2(id, contenidoNuevo);
    }}*/

