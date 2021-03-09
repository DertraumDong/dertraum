package com.d.main.project.service;

import com.d.main.project.model.ProjectView;
import com.dtr.web.dto.ResponseVO;

/**
 * 2021/3/9
 *
 * @author DerTraum
 * @since 1.0.0
 */
public interface ProjectViewService {
    ResponseVO queryAllProjectView();

    int addProjectView(String id);

    int deleteProjectView(String id);

    void visitProject(String id);
}
