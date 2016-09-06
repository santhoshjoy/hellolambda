package hellolambda;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class Hello implements RequestHandler<String, String> {
	
	final LoggerContext ctx = (LoggerContext) LogManager.getContext(false);

    public String handleRequest(String input, Context context) {
    	
    	Logger logger = LogManager.getLogger("splunk.logger");
        
        String output = "Hi "+ input + ",How are you?"; 
        
        logger.info(output);
        
        try {
            Thread.sleep(100);                 
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        
        return output;
    }
}