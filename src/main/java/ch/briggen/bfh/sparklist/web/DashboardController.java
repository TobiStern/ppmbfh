package ch.briggen.bfh.sparklist.web;

import java.util.Collection;
import java.util.HashMap;

import ch.briggen.bfh.sparklist.domain.Item;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

public class DashboardController  implements TemplateViewRoute{

	@Override
	public ModelAndView handle(Request request, Response response) throws Exception {
		HashMap<String, String> model = new HashMap<String, String>();
		model.put("list", "blup");
		return new ModelAndView(model, "dashboardTemplate");
	}

}
