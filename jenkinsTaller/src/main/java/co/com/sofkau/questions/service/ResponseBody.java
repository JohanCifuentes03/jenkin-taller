package co.com.sofkau.questions.service;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ResponseBody implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        Response response = SerenityRest.lastResponse();
        return response != null && !response.getBody().asString().isEmpty();
    }
    public static ResponseBody isNotEmpty(){
        return new ResponseBody();
    }
}
