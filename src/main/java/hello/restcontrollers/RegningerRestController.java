package hello.restcontrollers;

import hello.entities.StromMaaling;
import hello.persistence.StromMaalingerRepository;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stromsystem")
public class RegningerRestController {
    @Autowired
    StromMaalingerRepository stromMaalingerRepository;

    /**
     * Eksempel: http://localhost:8080/stromsystem/registrer
     * {
        "dato": "2014-12-11",
        "totaltForbruk": 1000,
        "utleieForbruk": 300,
        "melding": "Nye testinger"
        }
     * @param stromMaaling
     * @throws Exception
     */
    @RequestMapping(
            value = "/registrer",
            method = RequestMethod.POST,
            produces = "application/json",
            consumes = "application/json"
    )
    public ResponseEntity<Void> createStromMaaling(@RequestBody StromMaaling stromMaaling) throws Exception{
        if(stromMaalingerRepository.exists(stromMaaling.getDato())){
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        stromMaalingerRepository.save(stromMaaling);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @RequestMapping(
            value = "/oppdater",
            method = RequestMethod.PUT,
            produces = "application/json",
            consumes = "application/json"
    )
    public ResponseEntity<StromMaaling> updateStromMaaling(@RequestBody StromMaaling stromMaaling) throws Exception{
        StromMaaling _stromMaaling = stromMaalingerRepository.getOne(stromMaaling.getDato());
        if(stromMaaling==null){
            return new ResponseEntity<StromMaaling>(stromMaaling,HttpStatus.NOT_FOUND);
        }
        _stromMaaling.setMelding(stromMaaling.getMelding());
        _stromMaaling.setTotaltForbruk(stromMaaling.getTotaltForbruk());
        stromMaaling.setUtleieForbruk(stromMaaling.getUtleieForbruk());
        stromMaalingerRepository.save(_stromMaaling);
        return new ResponseEntity<StromMaaling>(stromMaaling,HttpStatus.OK);
    }



    /**
     * Eksempel: http://localhost:8080/stromsystem/henten/2014-12-11
     * @param dato
     * @return
     * @throws Exception
     */
    @RequestMapping(
            value = "/henten/{dato}",
            method = RequestMethod.GET,
            produces = "application/json"
    )
    public ResponseEntity<StromMaaling> getStromMaaling(@PathVariable LocalDate dato) throws Exception{
        StromMaaling stromMaaling = stromMaalingerRepository.getOne(dato);
        if(stromMaaling==null) {
            return new ResponseEntity<StromMaaling>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<StromMaaling>(stromMaaling,HttpStatus.OK);
    }

    /**
     * http://localhost:8080/stromsystem/hentalle
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(
            value = "/hentalle",
            method = RequestMethod.GET,
            produces = "application/json"
    )
    public ResponseEntity<List<StromMaaling>> findAll() throws Exception{
        List<StromMaaling> strom = stromMaalingerRepository.findAll();
        if(strom.isEmpty()) return new ResponseEntity<List<StromMaaling>>(strom, HttpStatus.NOT_FOUND);
        return new ResponseEntity<List<StromMaaling>>(strom, HttpStatus.OK);
    }

    /**
     * http://localhost:8080/stromsystem/fjern/2014-12-11
     *
     * @param dato
     * @return
     */
    @RequestMapping(
            value = "/fjern/{dato}",
            consumes = "application/json",
            produces = "application/json",
            method = RequestMethod.DELETE)
    public ResponseEntity<StromMaaling> deleteUser(@PathVariable LocalDate dato) {
        StromMaaling stromMaaling = stromMaalingerRepository.findOne(dato);
        if (stromMaaling == null) {

            return new ResponseEntity<StromMaaling>(HttpStatus.NOT_FOUND);
        }
        stromMaalingerRepository.delete(dato);
        return new ResponseEntity<StromMaaling>(HttpStatus.NO_CONTENT);
    }

}
