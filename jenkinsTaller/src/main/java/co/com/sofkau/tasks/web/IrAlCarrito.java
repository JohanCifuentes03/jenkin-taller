package co.com.sofkau.tasks.web;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.sofkau.ui.PaginaPrincipal.URL_CARRITO;

public class IrAlCarrito implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(URL_CARRITO)
        );
    }


    public static IrAlCarrito irAlCarrito(){
        return new IrAlCarrito();
    }
}
