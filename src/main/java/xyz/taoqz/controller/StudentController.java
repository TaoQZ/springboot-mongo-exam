package xyz.taoqz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.taoqz.dao.StudentDao;
import xyz.taoqz.domain.Student;

import java.util.List;

/**
 * @author :almostTao
 * @date :Created in 2019/11/13 15:18
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentDao studentDao;

    /**
     * 查询所有
     * @return
     */
    @GetMapping
    public List<Student> fun() {
        return studentDao.findAll();
    }

    /**
     * 添加
     * @param student
     */
    @PostMapping
    public void add(@RequestBody Student student) {
        studentDao.save(student);
    }

    /**
     * 修改
     * @param student
     */
    @PutMapping
    public void edit(@RequestBody Student student) {
        studentDao.update(student);
    }

    /**
     * 根据字段及值 进行删除
     * @param filedName
     * @param value
     */
    @DeleteMapping
    public void deleteByFiledName(@RequestParam(name = "filedName") String filedName, String value) {
        studentDao.deleteByFiledName(filedName, value);
    }

}
