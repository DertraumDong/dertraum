package com.d.main.dao;

import java.util.List;
import com.d.main.model.Course;
import com.d.main.model.CourseDTO;
import org.springframework.stereotype.Component;

/**
* 描述：元数据 服务Dao接口
* @author Administrator
* @date 2020-04-03 08:36:26
*/
@Component
public interface CourseDAO {

    /**
    * 描述：根据Id获取DTO
    * @param id
    */
    CourseDTO findDTOById(String id)throws Exception;

    List<Course> selectAll(Course course);

    CourseDTO createCourse(CourseDTO courseDTO) throws Exception;

    void deleteCourse(String id) throws Exception;

    CourseDTO updateCourse(CourseDTO courseDTO) throws Exception;

}