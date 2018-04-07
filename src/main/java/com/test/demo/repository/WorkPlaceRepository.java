package com.test.demo.repository;

import com.test.demo.entity.WorkPlace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: Nerses
 * Date: 4/6/18.
 * Time: 12:45 PM.
 * To change this template use File | Settings | File Templates.
 */
//@Repository
public interface WorkPlaceRepository extends JpaRepository<WorkPlace, Integer> {

}
