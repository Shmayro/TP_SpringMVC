package springapp.web;

import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller()
@RequestMapping("/tests")
public class HelloAnnoController {

    protected final Log logger = LogFactory.getLog(getClass());

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public ModelAndView sayHello() {
    	String now = (new Date()).toString();
        String user="Haroun EL ALAMI";
        
        HashMap<String, Object> data=new HashMap<>();
        data.put("now", now);
        data.put("user", user);
        
        logger.info("Returning hello view with " + now);

        return new ModelAndView("hello", "data", data);
    }
    
    @RequestMapping(value = "/welcome1", method = RequestMethod.GET)
    public ModelAndView sayHello1(@RequestParam(value="user", defaultValue="Haroun EL ALAMI") String user,@RequestParam(value="now",defaultValue="0001-01-01") @DateTimeFormat(pattern="yyyy-MM-dd") Date now) {
        
        HashMap<String, Object> data=new HashMap<>();
        data.put("now", now);
        data.put("user", user);
        
        logger.info("Returning hello view with " + now);

        return new ModelAndView("hello", "data", data);
    }
    
    @RequestMapping(value = "/welcome2/{user}", method = RequestMethod.GET)
    public ModelAndView sayHello3(@PathVariable("user") String user,@RequestParam(value="now",defaultValue="0001-01-01") @DateTimeFormat(pattern="yyyy-MM-dd") Date now) {
        
        HashMap<String, Object> data=new HashMap<>();
        data.put("now", now);
        data.put("user", user);
        System.out.println(user);
        
        logger.info("Returning hello view with " + now);

        return new ModelAndView("hello", "data", data);
    }
    
    @RequestMapping(value = "/welcome3/{user}/{now}", method = RequestMethod.GET)
    public ModelAndView sayHello2(@PathVariable(value="user") String user,@PathVariable(value="now") @DateTimeFormat(pattern="yyyy-MM-dd") Date now) {
        
        HashMap<String, Object> data=new HashMap<>();
        data.put("now", now);
        data.put("user", user);
        
        logger.info("Returning hello view with " + now);

        return new ModelAndView("hello", "data", data);
    }
    
    @RequestMapping(value = "/welcome4/{user:shmayro}/{tdata}", method = RequestMethod.GET)
    public ModelAndView sayHello4(@PathVariable(value="user") String user,@RequestParam(value="now",defaultValue="0001-01-01") @DateTimeFormat(pattern="yyyy-MM-dd") Date now,@MatrixVariable(pathVar="tdata",required=true) HashMap<String,Integer> hp) {
        
        HashMap<String, Object> data=new HashMap<>();
        data.put("now", now);
        data.put("user", user);
        
        logger.info("Returning hello view with " + now);
        ModelAndView mv=new ModelAndView("hello");
        mv.addObject("data", data);
        mv.addObject("hp", hp);
        return mv;
    }

}