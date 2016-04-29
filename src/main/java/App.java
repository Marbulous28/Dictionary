import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.ArrayList;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("words", request.session().attribute("words"));
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("wordInput/new", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/word-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/wordInput", (request, response) -> {
     HashMap<String, Object> model = new HashMap<String, Object>();
     model.put("words", Word.all());
     model.put("template", "templates/words.vtl");
     return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());

   post("/wordInput", (request,response) -> {
    HashMap<String, Object> model = new HashMap<String, Object>();
    String spelling = request.queryParams("word");
    Word newWord = new Word(spelling);
    model.put("template", "templates/success.vtl");
    return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/wordInput/:id", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Word word = Word.find(Integer.parseInt(request.params(":id")));
      model.put("word", word);
      model.put("template", "templates/task.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
