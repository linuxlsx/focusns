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
package org.focusns.web.modules.setting;

import org.focusns.model.core.Project;
import org.focusns.model.core.ProjectFeature;
import org.focusns.service.core.ProjectFeatureService;
import org.focusns.web.widget.annotation.Bind;
import org.focusns.web.widget.annotation.Widget;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

@Widget
public class SettingsWidget {
    
    @Autowired
    private ProjectFeatureService featureService;
    
    public String menu(@Bind(value="project", scope = Bind.Scope.REQUEST)
            Project project, Map<String, Object> model) {
         //
        List<ProjectFeature> features = featureService.getProjectFeatures(project.getId());
        model.put("features", features);
        //
        return "setting/menu";
    }
    
    public String summary() {
        //
        return "setting/summary";
    }
     
}
