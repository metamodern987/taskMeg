package metamodern7.testspringboot.service;

import metamodern7.testspringboot.model.Req;
import metamodern7.testspringboot.model.User;
import metamodern7.testspringboot.repository.ReqRepository;
import metamodern7.testspringboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by igor on 02.06.2020
 */
@Service
public class ReqService {

    private final ReqRepository reqRepository;

    @Autowired
    public ReqService(ReqRepository reqRepository) {
        this.reqRepository = reqRepository;
    }

    public Req saveReq(Req req) {
        return reqRepository.save(req);
    }

    public List<Req> findAll(){
        return reqRepository.findAll();
    }
}
