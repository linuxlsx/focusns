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

package org.focusns.web.modules.profile;

import org.focusns.model.core.ProjectLink;
import org.focusns.service.core.ProjectLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProjectLinkController {

    @Autowired
    private ProjectLinkService projectLinkService;

    @RequestMapping("/project/link/create")
    public void link(ProjectLink link) {
        projectLinkService.createProjectLink(link);
    }

    @RequestMapping("/project/link/remove")
    public void unlink(ProjectLink link) {
        projectLinkService.removeProjectLink(link.getFromProjectId(), link.getToProjectId());
    }

}
