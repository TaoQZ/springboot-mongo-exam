package xyz.taoqz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.taoqz.dao.ClassesDao;
import xyz.taoqz.domain.Classes;

import java.util.List;

/**
 * @author :almostTao
 * @date :Created in 2019/11/13 15:35
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/classes")
public class ClassesController {

    @Autowired
    private ClassesDao classesDao;

    @GetMapping
    public List<Classes> fun(){
        return classesDao.findAll();
    }

}
