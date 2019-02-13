package au.csiro.data61.cds.cge;

import java.io.StringWriter;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import au.csiro.data61.cds.models.api.CommonApi;

/**
 * Hello world!
 *
 */
public class TemplateTest 
{
    public static void main( String[] args )
    {
    	VelocityEngine velocityEngine = new VelocityEngine();
    	velocityEngine.init();
    	    
    	Template t = velocityEngine.getTemplate("index.vm");
    	     
    	VelocityContext context = new VelocityContext();
    	
    	context.put("api", CommonApi.class);
    	
    	StringWriter writer = new StringWriter();
    	t.merge( context, writer );
    	
    	System.out.println(writer.toString());
    	
    }
}
