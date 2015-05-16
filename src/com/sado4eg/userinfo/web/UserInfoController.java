package com.sado4eg.userinfo.web;

import com.sado4eg.userinfo.beans.User;
import com.sado4eg.userinfo.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserInfoController {

    private final String JSP_NAME = "userReg";
    private UserDAO userDAO;

    @Autowired
    @Qualifier(value = "UserValidator")
    private Validator validator;

    UserInfoController() {
        ClassPathXmlApplicationContext context;
        context = new ClassPathXmlApplicationContext("WEB-INF/applicationContext.xml");
        userDAO = (UserDAO) context.getBean("dataDao");
    }

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }

    @RequestMapping(value = "/userReg", method = RequestMethod.GET)
    public ModelAndView registerUser() throws Exception {

        return new ModelAndView(JSP_NAME, "command", new User());
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUser(@Validated @ModelAttribute("command") User user, BindingResult result, ModelMap modelMap) {

        if (result.hasErrors()) {
            modelMap.addAttribute("hasErrors", result.hasErrors());
        } else {
            modelMap.addAttribute(user);
            userDAO.save(user);
        }

        return JSP_NAME;
    }
}
