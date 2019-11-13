package xyz.taoqz.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author :almostTao
 * @date :Created in 2019/11/13 15:17
 */
@Data
@Document(collection = "students")
public class Student {

    @Id
    private String id;

    private Integer sid;

    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:dd",timezone = "GMT+8")
    private Date birthday;

    private String classId;

    private Classes classes;

    private String hobbies[];

}
