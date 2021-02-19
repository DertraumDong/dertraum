package com.d.main.bank.controller;
import com.d.main.bank.service.ICourseService;
import com.d.main.bank.model.Course;
import com.d.main.bank.model.CourseDTO;
import com.d.main.bank.model.ResultData;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;


/**
* 描述：元数据控制层
* @author Administrator
* @date 2020-04-03 08:36:26
* @version V1.0
*/
@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private ICourseService courseService;

    /**
    * 描述：根据Id 查询
    * @param id  元数据id
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultData findById(@PathVariable("id") String id)throws Exception {
        CourseDTO courseDTO = courseService.findDTOById(id);
        return new ResultData(courseDTO);
    }

    /**
    * 描述：根据条件查询User
    * @param course
    */
    @RequestMapping(value = "/list", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultData selectAll(@RequestBody Course course){
        List<Course> courseList = courseService.selectAll(course);
        return new ResultData(courseList);
    }

}