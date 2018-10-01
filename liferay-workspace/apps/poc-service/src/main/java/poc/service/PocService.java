package poc.service;

import poc.api.api.PocApi;

import org.osgi.service.component.annotations.Component;

/**
 * @author jboumard
 */
@Component(
	immediate = true,
	property = {
		// TODO enter required service properties
	},
	service = PocApi.class
)
public class PocService implements PocApi {
	
	private String titre = "default";

	@Override
	public String getTitre() {
		return this.titre;
	}

	@Override
	public void setTitre(String titre) {
		this.titre = titre;
	}

}