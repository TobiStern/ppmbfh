package ch.briggen.bfh.sparklist.web;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.briggen.bfh.sparklist.domain.ItemRepository;
import ch.briggen.bfh.sparklist.domain.project.Project;
import ch.briggen.bfh.sparklist.domain.project.ProjectRepository;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

/**
 * 
 */
public class ProjectDeleteController implements TemplateViewRoute {
	
	private final Logger log = LoggerFactory.getLogger(ProjectDeleteController.class);
	private ProjectRepository projectRepo = new ProjectRepository();

	@Override
	public ModelAndView handle(Request request, Response response) throws Exception {
		//evaluate parameter.
		String id = request.queryParams("id");
		log.trace("POST /project/delete mit id " + id);
		
		if(null == id)
		{
			log.trace("GET /project ohne id");		}
		else
		{
			//delete project
			Long longId = Long.parseLong(id);
			projectRepo.delete(longId);
			
			//redirect the user
			response.redirect("/"); //todo: redirect maybe to /portfolio
		}
		return new ModelAndView(null, null);
	}

}
