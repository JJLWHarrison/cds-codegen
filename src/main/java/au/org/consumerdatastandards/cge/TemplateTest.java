package au.org.consumerdatastandards.cge;

import java.io.StringWriter;
import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;

import au.org.consumerdatastandards.interfaces.api.CDRApi;

/**
 * Hello world!
 *
 */
public class TemplateTest 
{
    public static void main( String[] args )
    {
    	
    	Properties p = new Properties();
    	p.setProperty("resource.loader", "class");
    	p.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
    	Velocity.init( p );
    	VelocityContext context = new VelocityContext();           
    	Template template = Velocity.getTemplate("test.vm");
    	
    	ModelBuilder modelBuilder = new ModelBuilder(CDRApi.class);
    	context.put("api", modelBuilder.getObjectForest());
    	
    	StringWriter writer = new StringWriter();
    	template.merge( context, writer );
    	
    	System.out.println(writer.toString());
    	
    }
}
