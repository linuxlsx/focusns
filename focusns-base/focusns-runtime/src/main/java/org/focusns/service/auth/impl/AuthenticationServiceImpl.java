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
package org.focusns.service.auth.impl;

import org.focusns.dao.core.ProjectUserDao;
import org.focusns.model.core.ProjectUser;
import org.focusns.service.auth.AuthenticationException;
import org.focusns.service.auth.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private ProjectUserDao projectUserDao;
    
    public void authenticate(ProjectUser user) {
        ProjectUser dbUser = projectUserDao.selectByUsername(user.getUsername());
        if(!user.getPassword().equals(dbUser.getPassword())) {
            throw new AuthenticationException("Username or password miss matched!");
        }
    }
    
}
