package org.mailosaur.config;
import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Key;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({ 
	"system:properties", 
	"system:env",
	"file:${user.dir}/src/test/resources/config.properties"
	})
public interface FrameworkConfig extends Config{

	@Key("apiKey")
	String APIKEY();
	
	@Key("serverId")
	String SERVERID();
	
	@Key("serverDomain")
	String SERVERDOMAIN();
}
