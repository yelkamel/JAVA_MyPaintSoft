package Controller;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class MyJarLoader extends ClassLoader
{
	//String name = null;
	//Class<?> c = null;
	Method f = null;
  
//	public final ArrayList<String> listname = new ArrayList<>();
	public final ArrayList<Class<?>> listc = new ArrayList<>();

	public static URLClassLoader loader = null;
	private JarFile jf = null;

	public MyJarLoader()
	{
	}

	public void loading() throws IOException
	{
		String folder = "PluginSource/";
		File f = new File(folder);
		String name = null;
		
		FilenameFilter fnf = new FilenameFilter()
		{
			public boolean accept(File dir, String name)
			{
				return name.endsWith(".jar");
			}
		};

		String[] files = f.list(fnf);
		
		
		URL[] urls = new URL[files.length];

		for (int i = 0; i < files.length; i++)
				urls[i] = new URL("file:" + folder + "/" + files[i]);

		loader = new URLClassLoader(urls);

		for (URL url : urls)
		{
				File file = new File(url.toExternalForm().substring(5));
				jf = new JarFile(file);
				Enumeration<JarEntry> en = jf.entries();

				while (en.hasMoreElements())
				{
						JarEntry je = en.nextElement();
						name = je.getName();
						if (name.endsWith(".class"))
						{
							name = name.substring(0, name.length() - 6);
							name = name.replace('/', '.');
							try
							{
								listc.add(forC(name));
							} catch (ClassNotFoundException e)
							{
								e.printStackTrace();
							}
						}
				}
		}
	}

    public Class<?> forC(String name) throws ClassNotFoundException
    {
    	return loader.loadClass(name);
    }
	
	public Method getFiltre(Class<?> c)
	{
		Method m = null;
		try
		{
			m = c.getDeclaredMethod("perform");
		} catch (NoSuchMethodException | SecurityException e)
		{
			e.printStackTrace();
		}
		//m.invoke(c.newinstance());
		return m;
	}


	public ArrayList<Class<?>> getC()
	{
		return listc;
	}
	
}
