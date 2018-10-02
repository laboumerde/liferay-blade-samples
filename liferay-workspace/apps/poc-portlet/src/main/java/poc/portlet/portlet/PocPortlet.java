package poc.portlet.portlet;

import poc.api.api.PocApi;
import poc.portlet.constants.PocPortletKeys;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author jboumard
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + PocPortletKeys.Poc,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class PocPortlet extends MVCPortlet {

	@Reference
	private PocApi pocApi;
	
	private Log _log = LogFactoryUtil.getLog(this.getClass());
	
	@Override
		public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
				throws IOException, PortletException {

		renderRequest.setAttribute("pocTest", pocApi.getTitre());
		_log.debug("pocTest value : " + pocApi.getTitre());

		super.doView(renderRequest, renderResponse);
		
		}
		
}