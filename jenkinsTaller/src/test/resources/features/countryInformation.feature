Feature:  pruebas de servicio soap
  yo como usuario del sistema
  quiero probar un servicio de tipo soap
  para obtener informacion del pais segun su codigo iso

  @codigoIso
  Scenario: prueba nombre capital del pais segun codigo iso
    Given que el es usuario quiere ingresar el codigo "FR"
    When hace la peticion de tipo soap
    Then deberia obtener un statuscode 200
    And deberia obtener el nombre de la capital del pais