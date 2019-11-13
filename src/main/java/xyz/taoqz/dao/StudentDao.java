package xyz.taoqz.dao;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import xyz.taoqz.domain.Classes;
import xyz.taoqz.domain.Student;

import java.util.List;

/**
 * @author :almostTao
 * @date :Created in 2019/11/13 15:18
 */
@Repository
public class StudentDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 查询所有
     * @return
     */
    public List<Student> findAll(){
        List<Student> all = mongoTemplate.findAll(Student.class);
        for (Student student : all) {
            if (student.getClassId() != null){
                // 拿到每个学生对应的班级id 创建ObjectId对象
                ObjectId objectId = new ObjectId(student.getClassId());
                // 根据班级id查询班级
                Classes one = mongoTemplate.findOne(new Query(Criteria.where("id").is(objectId)), Classes.class);
                // 将班级添加到学生对象中
                student.setClasses(one);
            }
        }
        return all;
    }

    /**
     * 添加
     * @param student
     */
    public void save(Student student) {
        // 可以在笔记中看到两者的区别
        mongoTemplate.insert(student);
//        mongoTemplate.save(student);
    }

    /**
     * 更新
     * @param student
     */
    public void update(Student student) {
        // 查询条件 根据id
        Query id = Query.query(Criteria.where("_id").is(student.getId()));
        // 创建文档对象
        Document document = new Document();
        // 向文档中追加数据 更新哪个字段添加哪个字段
        document.append("name",student.getName()).append("birthday",student.getBirthday())
                .append("hobbies",student.getHobbies());
        // 根据id 根据文档对象进行更新
        // 因为是根据ObjectId进行更新所以唯一 使用updateFirst 只更新第一条
        mongoTemplate.updateFirst(id, Update.fromDocument(document),Student.class);
//        更新所有能匹配的文档
//        mongoTemplate.updateMulti();
    }

    /**
     * 根据字段名称删除文档
     * @param filedName 字段名称
     * @param value 字段对应的值
     */
    public void deleteByFiledName(String filedName,String value){
        Query query = Query.query(Criteria.where(filedName).is(value));
        mongoTemplate.remove(query, Student.class);
    }

}
