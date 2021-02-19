package com.d.main.bank.service;

import com.d.main.bank.model.Course;
import com.d.main.bank.model.CourseDTO;
import java.util.List;

/**
* 描述：元数据 服务实现层接口
* @author Administrator
* @date 2020-04-03 08:36:26
*/
public interface ICourseService {

    /**
    * 描述：根据Id获取DTO
    * @param id
    */
    CourseDTO findDTOById(String id)throws Exception;

    /**
    * 描述：根据条件查询User
    * @param course
    */
    public List<Course> selectAll(Course course);

}