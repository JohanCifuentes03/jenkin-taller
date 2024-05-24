Feature: prueba servicio Rest
  yo como usuario del sitema
  quiero probar un servicio tipo rest
  para obtener los valores de respuesta de cada servicio

  @rest1
  Scenario: obtener datos de usuario por id de reserva
    Given que el usario esta en la pagina "https://restful-booker.herokuapp.com/"
    When realiza una peticion de tipo get al recurso "booking/"
    Then deberia obtener un codigo de respuesta 200
    And deberia ver los datos del usuario