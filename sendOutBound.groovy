import de.hybris.platform.cockpit.services.search.SearchService
import de.hybris.platform.cockpit.services.search.impl.DefaultSearchService
import de.hybris.platform.core.model.order.OrderModel
import de.hybris.platform.core.model.product.ProductModel
import de.hybris.platform.processengine.action.AbstractSimpleDecisionAction
import de.hybris.platform.returns.model.ReturnRequestModel
import de.hybris.platform.servicelayer.model.ModelService
import de.hybris.platform.outboundservices.facade.impl.DefaultOutboundServiceFacade
import org.springframework.http.ResponseEntity

DefaultOutboundServiceFacade outboundServiceFacade = spring.getBean("outboundServiceFacade")
ModelService modelService = spring.getBean("modelService")

searchService = spring.getBean("flexibleSearchService")
query = "SELECT {pk} FROM {Order} WHERE {code} = *******"
orderModel = searchService.search(query).getResult().get(0)

destinationId = ""
ioCode = ""


outboundServiceFacade.send(orderModel, ioCode, destinationId)
        .subscribe{res -> res.getBody().each {println(it.getKey() + "---" +it.getValue())}}

