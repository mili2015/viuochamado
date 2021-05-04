package br.com.mili.viuochamado;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesLoader
{

	private Properties props = null;
	
	public PropertiesLoader()
	{
		
		getProp();
	}
	
	private Properties getProp() 
	{
		try
		{
			props = new Properties();
			String arquivo = "F:\\Deploy\\chamado\\conf.properties";
			FileInputStream fis;
			fis = new FileInputStream(arquivo);
			props.load(fis);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return props;
	}
	
	public String getValue(String key)
	{
		return props.getProperty(key);
	}

}
