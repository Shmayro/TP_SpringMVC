package springapp.web;

import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller()
@RequestMapping("/tests")
public class CounterController {

    protected final Log logger = LogFactory.getLog(getClass());

    @RequestMapping(value = "/counter", method = RequestMethod.GET)
    public ModelAndView sayHello(HttpServletRequest request) {
    	String now = (new Date()).toString();
        String user="Haroun EL ALAMI";
        
        int counter=(request.getSession().getAttribute("counter")==null)?0:(int)request.getSession().getAttribute("counter");
        counter++;
        request.getSession().setAttribute("counter",counter);
        System.out.println(counter);
        
        HashMap<String, Object> data=new HashMap<>();
        data.put("now", now);
        data.put("user", user);
        data.put("counter", counter);
        
        logger.info("Returning hello view with " + now);

        return new ModelAndView("count", "data", data);
    }

}