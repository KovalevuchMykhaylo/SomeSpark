import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import spark.ModelAndView;
import spark.Spark;
import spark.template.freemarker.FreeMarkerEngine;

import static spark.Spark.staticFileLocation;

//Def url http://localhost:4567/
public class Main {
    public static void main(String[] args) {
        FreeMarkerEngine freeMarkerEngine = new FreeMarkerEngine();
        Configuration freemarkerConfiguration = new Configuration();
        freemarkerConfiguration.setTemplateLoader(new ClassTemplateLoader(Main.class, "/templates/"));
        freeMarkerEngine.setConfiguration(freemarkerConfiguration);
        staticFileLocation("/static");
        Spark.get("/view", (request, response) -> freeMarkerEngine.render(new ModelAndView(null, "view.ftl")));
    }
}