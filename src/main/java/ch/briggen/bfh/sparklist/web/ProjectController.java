package ch.briggen.bfh.sparklist.web;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.briggen.bfh.sparklist.domain.project.Project;
import ch.briggen.bfh.sparklist.domain.project.ProjectRepository;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

public class ProjectController implements TemplateViewRoute{

	private final Logger log = LoggerFactory.getLogger(ProjectController.class);
	private ProjectRepository projectRepo = new ProjectRepository();
	
	/**
	 * Handles requests like /project?id=1
	 * @Return the project-detailView
	 */
	@Override
	public ModelAndView handle(Request request, Response response) throws Exception {
		//evaluate parameter.
		String idString = request.queryParams("id");		
		HashMap<String, Object> model = new HashMap<String, Object>();
		
		if(null == idString)
		{
			log.trace("GET /project ohne id");		}
		else
		{
			log.trace("GET /project mit id " + idString);
			Long id = Long.parseLong(idString);
			//get project from db
			Project p = projectRepo.getById(id);
			model.put("projectDetail", p);
		}
		
		return new ModelAndView(model, "projectTemplate");
	}

}
