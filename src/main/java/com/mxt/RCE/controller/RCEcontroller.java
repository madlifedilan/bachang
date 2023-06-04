package com.mxt.RCE.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.script.Bindings;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptContext;

@RestController
public class RCEcontroller {

    @RequestMapping(value = "/rceput",method = RequestMethod.POST)
    @ApiOperation("rce1")
    @ResponseBody
    public String executeCommand(@RequestParam("command") String command) {
        if (command == null || command.isEmpty()) {
            command = "whoami";
        }

        Process process;
        String result = "";
        try {
            String[] cmd = {"cmd","/c",command};
            process = Runtime.getRuntime().exec(cmd);
            InputStream inputStream = process.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream,"GB2312"));
            String line;
            while ((line = reader.readLine()) != null) {
                result += line + "\n";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * <a href="http://localhost:8080/rce/ProcessBuilder?cmd=whoami">POC</a>
     */
    @RequestMapping(value="/ProcessBuilder",method = RequestMethod.POST)
    @ApiOperation("rce2")
    @ResponseBody
    public String processBuilder(String command) {

        StringBuilder sb = new StringBuilder();

        try {
            //String[] cmd = {"/bin/sh", "-c", command}; //linux
            String[] cmd = {"cmd","/c",command};  //Windows
            ProcessBuilder processBuilder = new ProcessBuilder(cmd);
            Process p = processBuilder.start();
            BufferedInputStream in = new BufferedInputStream(p.getInputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String tmpStr;

            while ((tmpStr = reader.readLine()) != null) {
                sb.append(tmpStr);
            }
        } catch (Exception e) {
            return e.toString();
        }

        return sb.toString();
    }

    @RequestMapping(value="/jscmd",method = RequestMethod.POST)
    public void jsEngine(String command) throws Exception{
        // js nashorn javascript ecmascript
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("js");
        //ScriptEngine engine = manager.getEngineByName("JavaScript");//通过脚本名称获取：
        //ScriptEngine engine = manager.getEngineByMimeType("text/javascript");  //通过MIME类型来获取：
        Bindings bindings = engine.getBindings(ScriptContext.ENGINE_SCOPE);//启动javascript引擎
        String cmd = String.format("load(\"%s\")", command);
        engine.eval(cmd, bindings);
    }


}




//@Controller
//public class RCEcontroller {
//
//
//    @RequestMapping(value="rce",method = RequestMethod.GET)
//    public String input(){
//        return "agency/rce";
//    }
//
//
//    @RequestMapping(value="rceoutput", method = RequestMethod.POST)
//    public String rceoutput(@RequestParam("command") String command, Model model){
//        if(command=="" | command==null){
//            command= "whoami";
//        }
//        Process p = null;
//        String result = null;
//        try {
//            p = Runtime.getRuntime().exec(command);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        InputStream is = p.getInputStream();
//        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
//        String s = null;
//        while (true) {
//            try {
//                if (!((s = reader.readLine()) != null)) break;
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            result = s;
//        }
//        model.addAttribute("result",result);
//        return result;
//    }
//
//}