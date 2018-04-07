package com.test.demo.service.impl;

import com.test.demo.entity.WorkPlace;
import com.test.demo.repository.WorkPlaceRepository;
import com.test.demo.service.WorkPlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: Nerses
 * Date: 4/6/18.
 * Time: 12:51 PM.
 * To change this template use File | Settings | File Templates.
 */
@Service
public class WorkPlaceServiceImpl implements WorkPlaceService {

    @Autowired
    WorkPlaceRepository workPlaceRepository;

    @Override
    public void saveWorkPlace(WorkPlace workPlace) {
        workPlaceRepository.save(workPlace);
    }

    public void test(){
//        workPlaceRepository.fin
    }
}