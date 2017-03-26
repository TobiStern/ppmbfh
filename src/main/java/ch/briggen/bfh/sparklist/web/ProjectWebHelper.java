package ch.briggen.bfh.sparklist.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.briggen.bfh.sparklist.domain.Item;
import ch.briggen.bfh.sparklist.domain.project.Project;
import spark.Request;

class ProjectWebHelper {
	private final static Logger log = LoggerFactory.getLogger(ProjectWebHelper.class);
	
	public static Project projectFromWeb(Request request)
	{
		return new Project(
//				Long.parseLong(request.queryParams("itemDetail.id")),
//				request.queryParams("itemDetail.name"),
//				Integer.parseInt(request.queryParams("itemDetail.quantity"))
				);
	}
}
