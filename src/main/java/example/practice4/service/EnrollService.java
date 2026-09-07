package example.practice4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
public class EnrollService {
    @Autowired private EnrollService enrollService;   
}
