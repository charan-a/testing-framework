package util;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;
import org.yaml.snakeyaml.Yaml;

public class Reader {
	 public String getXpath(String object) throws IOException {
		 Properties obj = new Properties();
		 FileInputStream objfile = new FileInputStream("src\\test\\resources\\Objects_Repository.properties");
		 obj.load(objfile);
		 String xpath = obj.getProperty(object);
		 return xpath;
	 }
}
