/*
 * Copyright (C) 2011-2013 FocusSNS.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301  USA
 */
package org.focusns.service.core;

import org.focusns.model.common.Rectangle;
import org.focusns.model.core.Project;
import org.focusns.model.core.ProjectLogo;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface ProjectLogoService { 
    
    ProjectLogo getProjectLogo(long logoId);
    
    void createProjectLogo(ProjectLogo logo);

    void modifyProjectLogo(ProjectLogo logo);
    
    void removeProjectLogo(ProjectLogo logo);
    
    List<ProjectLogo> listProjectLogos(long projectId);
    
    File loadProjectLogoImage(ProjectLogo logo);
    
    void cropProjectLogoImage(Project project, File original, Rectangle rectangle) throws IOException;
    
}
