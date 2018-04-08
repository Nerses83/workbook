package com.test.demo.service.impl;

import com.test.demo.entity.WorkBook;
import com.test.demo.entity.WorkPlace;
import com.test.demo.repository.WorkPlaceRepository;
import com.test.demo.service.WorkPlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

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
    public void setWorkPlaceRepository(WorkPlaceRepository workPlaceRepository) {
        this.workPlaceRepository = workPlaceRepository;
    }

    WorkPlaceRepository workPlaceRepository;

    @Override
    public void saveWorkPlace(WorkPlace workPlace) {
        workPlaceRepository.save(workPlace);
    }

    @Override
    public void deleteWorkPlace(Integer id) {
        workPlaceRepository.delete(id);
    }

    @Override
    public void updateIsCurrent(WorkBook workbook) {
//        workPlaceRepository.updateCurrent(workbook, false);
    }

    public void test(){
//        workPlaceRepository.updatcountry(5, "kuxniq");
    }

    @Override
    public WorkPlace getWorkPlaceById(Integer id) {
        return workPlaceRepository.findOne(id);
    }

    @Override
    public void updateWorkPlace(Set<WorkPlace> workPlaces, WorkPlace workPlace) {
        if(workPlace.isCurrent()) {
//            workPlace.setEndDate(null);
            for (WorkPlace place  : workPlaces) {
                if(place.isCurrent()) {
                    place.setCurrent(false);
                    workPlaceRepository.save(place);
                    break;
                }
            }
        }
        workPlaceRepository.save(workPlace);
    }
}
