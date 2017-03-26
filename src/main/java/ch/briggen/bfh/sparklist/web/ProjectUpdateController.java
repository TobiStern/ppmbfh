package ch.briggen.bfh.sparklist.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.briggen.bfh.sparklist.domain.project.Project;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

public class ProjectUpdateController implements TemplateViewRoute  {
	private final Logger log = LoggerFactory.getLogger(ProjectUpdateController.class);
	
	@Override
	public ModelAndView handle(Request request, Response response) throws Exception {
		Project projectDetail = ProjectWebHelper.projectFromWeb(request);
		
		log.trace("POST /item/update mit itemDetail " + projectDetail);
		//todo
		
		return new ModelAndView(null, null);
	}

}
