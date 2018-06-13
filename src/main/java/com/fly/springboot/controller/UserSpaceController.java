package com.fly.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author fly
 * @date 2018/5/13 16:22
 * @description     用户主页接口
 **/
@Controller
@RequestMapping("/u")
public class UserSpaceController {
    /**
     * 日志记录
     */
    public static final Logger LOGGER = LoggerFactory.getLogger(UserSpaceController.class);

    @GetMapping("/{username}")
    public String userSpace(@PathVariable("username") String username){
        LOGGER.info("username" + username);
        return "/userspace/u";
    }

    @GetMapping("/{username}/blogs")
    public String listBlogsByOrder(@PathVariable("username") String username,
                                   @RequestParam(value = "order", required = false, defaultValue = "new") String order,
                                   @RequestParam(value = "category", required = false) String category,
                                   @RequestParam(value = "keyword", required = false) String keyword){
        if(!StringUtils.isEmpty(category)){
            LOGGER.info("category" +category);
            LOGGER.info("selflink: " + "redirect:/u/" + username + "/blogs?category=" + category);
            return "/userspace/u";
        }else if(!StringUtils.isEmpty(keyword)){
            LOGGER.info("keyword" +keyword);
            LOGGER.info("selflink: " + "redirect:/u/" + username + "/blogs?keyword=" + keyword);
            return "/userspace/u";
        }
        LOGGER.info("order" +order);
        LOGGER.info("selflink: " + "redirect:/u/" + username + "/blogs?order=" + order);
        return "/userspace/u";
    }

    @GetMapping("/{username}/blogs/{id}")
    public String listBlogsByOrder(@PathVariable("id") Long id){
        LOGGER.info("blogId " + id);
        return "/usersapce/blog";
    }
    @GetMapping("/{username}/blogs/edit")
    public String editBlog(){
        return "/usersapce/blogedit";
    }
}
