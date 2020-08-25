package fr.adam.pokemon.mod;

import java.net.URL;
import java.net.URLClassLoader;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class ModClassLoader extends URLClassLoader {

	private static final Set<ModClassLoader> loaders = new CopyOnWriteArraySet<ModClassLoader>();
	
	static {
		ClassLoader.registerAsParallelCapable();
	}
	
	public ModClassLoader(URL[] urls) {
		super(urls);
		loaders.add(this);
	}
	
	@Override
	protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
		return loadClass0(name, resolve, true);
	}
	
	private Class<?> loadClass0(String name, boolean resolve, boolean checkOther) throws ClassNotFoundException {
		try {
			return super.loadClass(name, resolve);
		}catch(ClassNotFoundException ignored) {}
		
		if(checkOther) {
			for(ModClassLoader loader : loaders) {
				if(loader != this) {
					try {
						return loader.loadClass0(name, resolve, false);
					}catch(ClassNotFoundException ignored) {}
				}
			}
		}
		throw new ClassNotFoundException(name);
	}
}
