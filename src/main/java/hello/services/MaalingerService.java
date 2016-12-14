package hello.services;

import hello.entities.Status;
import hello.persistence.StatusDAO;
import hello.persistence.StromMaalingerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaalingerService {
    StromMaalingerRepository stromMaalingerRepository;

    public MaalingerService(StromMaalingerRepository stromMaalingerRepository){

        this.stromMaalingerRepository=stromMaalingerRepository;
    }


}
