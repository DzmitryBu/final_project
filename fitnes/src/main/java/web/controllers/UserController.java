package web.controllers;


import dto.*;
import org.springframework.web.bind.annotation.*;
import service.api.IUserService;
import javax.servlet.http.HttpSession;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final IUserService service;

    public UserController(IUserService service) {
            this.service = service;
    }
    @RequestMapping(method = RequestMethod.POST)
    public void add(@RequestBody UserCreate userCreate){
        service.add(userCreate);
    }


    // поменять передачк параметрана query
    @RequestMapping(path = "/page/{page}/size/{size}", method = RequestMethod.GET)
    public PageOfUser getPageUsers(@PathVariable ("page") Integer page,
                                   @PathVariable ("size") Integer size){
        return service.getPageUsers(page, size);
    }
    @RequestMapping(path = "/{uuid}", method = RequestMethod.GET)
    public User getCard(@PathVariable("uuid") UUID uuid) {
        return service.getCard(uuid);
    }

    @RequestMapping(path = "/{uuid}/dt_update/{dt_update}", method = RequestMethod.PUT)
    public void updateUsers(@PathVariable ("uuid") UUID uuid,
                                   @PathVariable ("dt_update") String dt_update,
                                   @RequestBody UserCreate userCreate){
        service.updateUser(uuid, dt_update, userCreate);
    }

     @RequestMapping(path = "/registration", method = RequestMethod.POST)
     public void addUser(@RequestBody UserRegistration user) {
         service.addUser(user);
     }


     // поменять передачк параметрана query
     @RequestMapping(path = "/verification/{code}", method = RequestMethod.GET)
     public void verification(@PathVariable("code") String code) {
         service.verification(code);
     }

     @RequestMapping(path = "/login", method = RequestMethod.POST)
     public void loging(@RequestBody UserLogin userLog) {service.loging(userLog);
     }

     @RequestMapping(path = "/me", method = RequestMethod.GET)
     public User getCard(HttpSession session) {
         UUID uuid = (UUID) session.getAttribute("uuid");
         return service.getCard(uuid);
     }

}
