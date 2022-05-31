import de.hybris.platform.processengine.definition.ProcessDefinitionsCache;
import de.hybris.platform.core.Registry;

ProcessDefinitionsCache c = Registry.getApplicationContext().getBean("processDefinitionsCache", ProcessDefinitionsCache.class);
c.clear()
return c.getAllIds()