package co.com.sofkau.utils;

import co.com.sofkau.models.UsuarioModel;
import net.datafaker.Faker;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Util {
    private Util() {
        throw new IllegalStateException("Utility Class");
    }

    public static UsuarioModel crearUsuario() {

        Faker faker = new Faker();

        UsuarioModel usuarioModel = new UsuarioModel();

        String email = faker.internet().emailAddress();
        String password = faker.internet().password();

        usuarioModel.setNombre(faker.name().firstName());
        usuarioModel.setApellido(faker.name().lastName());
        usuarioModel.setEmail(email);
        usuarioModel.setConfirmarEmail(email);
        usuarioModel.setPassword(password);
        usuarioModel.setConfirmarPassword(password);

        return usuarioModel;

    }

    public static <T> T escogerItemAleatorio(List<T> list) {
        int randomIdx = (int) Math.floor(Math.random() * list.size());
        return list.get(randomIdx);
    }



    public static String obtenerTituloAleatorio() {
        List<String> libros = Arrays.asList(
                "La Sombra del Viento",
                "Cien Años de Soledad",
                "1984",
                "El Alquimista",
                "Crónica de una Muerte Anunciada",
                "El Nombre de la Rosa",
                "Don Quijote de la Mancha",
                "El Principito",
                "Los Miserables",
                "Orgullo y Prejuicio",
                "Matar a un Ruiseñor",
                "Harry Potter y la Piedra Filosofal",
                "La Casa de los Espíritus",
                "El Gran Gatsby",
                "El Señor de los Anillos: La Comunidad del Anillo",
                "Cumbres Borrascosas",
                "El Diario de Ana Frank",
                "Rayuela",
                "La Metamorfosis",
                "La Divina Comedia"
        );
        return escogerItemAleatorio(libros);
    }

    public static String id(){
        Random random = new Random();
        int randomNumber = random.nextInt(22) + 1;
        return Integer.toString(randomNumber);
    }
}
