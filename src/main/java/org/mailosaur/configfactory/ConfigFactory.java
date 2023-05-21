package org.mailosaur.configfactory;

import org.aeonbits.owner.ConfigCache;
import org.mailosaur.config.FrameworkConfig;

public class ConfigFactory {

private ConfigFactory() {}
	
	public static FrameworkConfig getConfig() {	
		return ConfigCache.getOrCreate(FrameworkConfig.class);
	}
}
