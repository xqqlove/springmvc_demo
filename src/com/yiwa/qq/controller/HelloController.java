package com.yiwa.qq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloController {
    /**
     *1.使用@RequestMapping注解映射请求的url
     * 2.返回器会通过视图解析器解析为实际的物理视图，对InternalResourceViewResolver视图解析器，
     * 会作如下解析： 通过prefix +returnval+后缀 这样的方式得到实际的物理视图，然后转发操作
     */
    @RequestMapping("/helloworld")
    public String hello() {
        System.out.println("hello world");
        return "success";
    }

    /**
     *测试请求方式
     * @return
     */
    @RequestMapping(value = "/testMethod",method = RequestMethod.POST)
    public String testMethod(){
        System.out.println("testMethod");
        return "success";
    }

    /**
     * 测试请求参数和请求头
     * @return
     */
    @RequestMapping(value = "/testParamerANdHanders",
            params = {"username","age!=10"},headers = {"Accept-Language=zh-CN,zh;q=0.9"})
    public String testParamerANdHanders(){
        System.out.println("testParamerANdHanders");
        return "success";
    }

    /**
     * @PathVariable可以映射url中的占位符到目标方法的参数中
     * @param id
     * @return
     */
    @RequestMapping("/testPathVariable/{id}")
    public String testPathVariable(@PathVariable("id") Integer id){
        System.out.println("testPathVariable"+id);
        return "success";
    }

    @RequestMapping(value = "/testRequestParam")
    public String testRequestParam(@RequestParam(value = "username") String username,
                                   @RequestParam(value = "age") String age){
        System.out.println("username: "+username+", age "+age );
        return "success";
    }
    @RequestMapping("/testServletAPI")
    public void testServletAPI(HttpServletRequest request, HttpServletResponse response, Writer out)throws IOException {
        System.out.println("HttpServletRequest: "+request+"    ,HttpServletResponse  "+response);
        out.write("hello SpringMVC");
    }
    @RequestMapping("/testMap")
    public String testMap(Map<String,Object> map){
        map.put("name" , Arrays.asList("tom" ,"Jerry","mike"));
        return "success";
    }
     @RequestMapping("/testFileUpload")
    public String testFileUpload(@RequestParam("desc") String desc,
                                 @RequestParam("file")MultipartFile file) throws IOException{
         System.out.println("desc: "+desc);
         System.out.println("filename :"+file.getOriginalFilename());
         System.out.println("inputStream: "+file.getInputStream());
        return "success";
    }
}
