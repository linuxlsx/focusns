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

package org.focusns.install;

import org.focusns.install.setting.DatabaseWizard;
import org.focusns.install.setting.OpenApiWizard;
import org.focusns.install.setting.ServerWizard;
import org.focusns.install.setting.Wizard;
import org.focusns.install.utils.Properties;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Installer {

    private static final String RUNTIME_NAME = ".focusns";
    private static final String RUNTIME_BASE = System.getProperty("user.home");
    private static final String RUNTIME_PATH = RUNTIME_BASE + File.separator + RUNTIME_NAME;
    //

    private static final Wizard databaseWizard = new DatabaseWizard();
    private static final Wizard openApiWizard = new OpenApiWizard();
    private static final Wizard serverWizader = new ServerWizard();

    public static void main(String[] args) throws Exception {
        //
        Scanner scanner = new Scanner(System.in);
        //
        printWelcome(scanner);
        //
        Properties globalSettings = new Properties();
        //
        databaseWizard.setup(globalSettings);
        //
        openApiWizard.setup(globalSettings);
        //
        serverWizader.setup(globalSettings);
        //
        storeToRuntime(globalSettings);
        //
        printEnjoyment(scanner);
    }

    private static void printWelcome(Scanner scanner) {
        StringBuilder welcome = new StringBuilder();
        welcome.append("###################################\n");
        welcome.append("#     欢迎使用 FocusSNS 安装程序    #\n");
        welcome.append("#     当前版本 2.0.0               #\n");
        welcome.append("#     发布日期 2013年02月14日       #\n");
        welcome.append("###################################\n");
        //
        System.out.println(welcome);
        //
        System.out.print("如需退出安装程序，请输入【exit】：");
        String exit = scanner.nextLine();
        if("exit".equalsIgnoreCase(exit)) {
            System.exit(0);
        }
    }

    private static void printEnjoyment(Scanner scanner) {
        StringBuilder enjoyment = new StringBuilder();
        enjoyment.append("FocusSNS 已经安装成功，开始享用吧...");
        //
        System.out.println(enjoyment);
        // press any key to exit
        scanner.nextLine();
    }

    private static void storeToRuntime(Properties globalSettings) throws IOException {
        File runtime = new File(RUNTIME_PATH);
        if(!runtime.exists()) {
            runtime.mkdirs();
        }
        //
        File application = new File(RUNTIME_PATH + File.separator + "application.properties");
        if(application.exists()) {
            application.createNewFile();
        }
        //
        globalSettings.store(new FileWriter(application), "Generated by FocusSNS Installer");
    }
}
