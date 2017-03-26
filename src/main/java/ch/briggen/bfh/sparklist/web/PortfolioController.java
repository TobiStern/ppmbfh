package ch.briggen.bfh.sparklist.web;

import java.util.Collection;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.briggen.bfh.sparklist.domain.portfolio.Portfolio;
import ch.briggen.bfh.sparklist.domain.portfolio.PortfolioRepository;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

public class PortfolioController implements TemplateViewRoute{

	private final Logger log = LoggerFactory.getLogger(PortfolioController.class);

	/**
	 *  Liefert daten des portolfios zurück, wird mit /portfolio aufgerufen 
	 *  @return Model 
	 */	
	@Override
	public ModelAndView handle(Request request, Response response) throws Exception {

		PortfolioRepository portfolioRepo = new PortfolioRepository();
		
		// Check if all portfolios should be displayed
		if(request.queryParams("id") == null )
		{	
			log.trace("return all portfolios");
			
			HashMap<String, Collection<Portfolio>> model = new HashMap<String, Collection<Portfolio>>();
			model.put("portfolioCollection", portfolioRepo.getAll());
			return new ModelAndView(model, "portfolioTemplate");
		}
		
		// if url has ?id=[number] then only one portfolio should be displayed
		HashMap<String, Portfolio> model = new HashMap<String, Portfolio>();		
		Long id = Long.parseLong(request.queryParams("id"));
		
		log.trace("return a single portfolio with ID: " + id);
		
		Portfolio portfolio = portfolioRepo.getById(id);		
		model.put("portfolio", portfolio);
		
		return new ModelAndView(model, "portfolioTemplate");
	}

}
