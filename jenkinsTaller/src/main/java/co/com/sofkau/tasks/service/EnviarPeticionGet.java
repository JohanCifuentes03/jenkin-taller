package co.com.sofkau.tasks.service;

import co.com.sofkau.interactions.OurGet;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static co.com.sofkau.utils.Util.id;

public class EnviarPeticionGet implements Task {

    private String endpoint;

    public EnviarPeticionGet conRecurso(String endpoint) {
        this.endpoint = endpoint;
        return this;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                OurGet.resource(endpoint+id())
                        .with(request -> request
                                .log().all()
                        )
        );
    }
    public static EnviarPeticionGet enviarPeticionGet() {
        return new EnviarPeticionGet();
    }
}
