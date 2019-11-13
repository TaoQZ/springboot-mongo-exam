package xyz.taoqz.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import xyz.taoqz.domain.Classes;

import java.util.List;

/**
 * @author :almostTao
 * @date :Created in 2019/11/13 15:36
 */
@Repository
public class ClassesDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Classes> findAll() {
        return mongoTemplate.findAll(Classes.class);
    }
}
