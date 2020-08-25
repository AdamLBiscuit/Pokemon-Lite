package fr.adam.pokemon.mod;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import org.yaml.snakeyaml.introspector.PropertyUtils;

import fr.adam.pokemon.Game;

public class ModManager { 
	
	private final Game game;
	
	private final File modsFolder = new File("mods");
	private final Yaml yaml;
	
	private final Map<String, ModDescription> toLoad = new HashMap<String, ModDescription>();
	private final Map<String, Mod> mods = new HashMap<String, Mod>();
	
	public ModManager(Game game) {
		this.game = game;
		
		Constructor yamlConstructor = new Constructor();
		PropertyUtils propertyUtils = yamlConstructor.getPropertyUtils();
		
		propertyUtils.setSkipMissingProperties(true);
		yamlConstructor.setPropertyUtils(propertyUtils);
		this.yaml = new Yaml(yamlConstructor);
		
		this.modsFolder.mkdirs();
	}
	
	public void initMods() {
		for(Mod mod : this.mods.values()) {
			if(mod.isEnable()) {
				try {
					mod.onInit();
				}catch(Exception exception){
					System.err.println("Une erreur est survenue lors de l'initialisation du Mod: " + mod.getDescription().getName());
					exception.printStackTrace();
				}
			}
		}
	}
	
	public void loadMods() {
		ModDescription desc;
		
		for(Map.Entry<String, ModDescription> entry : this.toLoad.entrySet()) {
			desc = entry.getValue();
			
			try {
				URLClassLoader loader = new ModClassLoader(new URL[] { desc.getFile().toURI().toURL() });
				Class<?> main = loader.loadClass(desc.getMain());
				Mod mod = (Mod) main.getDeclaredConstructor().newInstance();
				
				this.mods.put(desc.getName(), mod);
				mod.init(this.game, desc);
				System.out.println("[System] Le Mod " + desc.getName() + " " + desc.getVersion() + " à bien été chargé !");
				mod.onLoad();
				mod.setEnable(true);
				
			}catch(Exception exception) {
				System.err.println("[System] Erreur lors du chargement du Mod: " + desc.getName());
			}
		}
	}
	
	public void detectMods() {
		System.out.println("[System] Recherche de mods en cours..");
		
		for(File file : this.modsFolder.listFiles()) {
			if(file.isFile() && file.getName().endsWith(".jar")) {
				System.out.println("[System] Detect File: " + file.getName());
				
				try(JarFile jar = new JarFile(file)){
					JarEntry info = jar.getJarEntry("resources/mod.yml");	
					
					if(info == null) {
						System.err.println("[System] mod.yml inexistant /!\\");
					}
					
					try(InputStream in = jar.getInputStream(info)) {
						ModDescription desc = this.yaml.loadAs(in, ModDescription.class);
						
						desc.setFile(file);
						this.toLoad.put(desc.getMain(), desc);
					}
				}catch(Exception exception) {
					System.err.println("[System] Erreur lors du chargement de: " + file.getName());
				}
			}
		}
	}
}
