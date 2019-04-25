package org.dubbo.spring.boot.controller;

import org.dubbo.spring.boot.service.OneService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;

@RestController
public class DubboController {
	@Reference(check=false)//启动消费者不检查服务者是否存在
    public OneService oneService;

    @RequestMapping(value = "hello/{name}",method = RequestMethod.GET)
    public String Hello(@PathVariable String name){
        String ret_msg;
        try {
            ret_msg  = oneService.one(name);
        }catch (Exception e){
            e.printStackTrace();
            ret_msg = "出错啦！";
        }
        return  ret_msg;
    }
}
