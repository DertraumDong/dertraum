package com.d.main.service.impl;
import com.d.main.model.Course;
import com.d.main.service.ICourseService;
import com.d.main.dao.CourseDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.d.main.model.CourseDTO;
import java.util.List;

/**
* 描述：元数据 服务实现层
* @author Administrator
* @date 2020-04-03 08:36:26
*/
@Service
public class CourseServiceImpl implements ICourseService {

    @Autowired
    private CourseDAO courseDAO;

    /**
    * 描述：根据Id获取DTO
    * @param id
    */
    @Override
    public CourseDTO findDTOById(String id) throws Exception {
        CourseDTO courseDTO = courseDAO.findDTOById(id);
        return courseDTO;
    }

    /**
    * 描述：根据条件查询User
    * @param course
    */
    @Override
    public List<Course> selectAll(Course course){
        List<Course> courseList = courseDAO.selectAll(course);
        return courseList;
    }
}

