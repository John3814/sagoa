
Feature:  Gestión de usuarios

  Scenario: Registro de un usuario
    Given que se va a registrar un usuario con los siguientes datos username "prueba", role "CUSTOMER" y password "123456"
    When se registra al usuario con esos datos
    Then el sistema debe devolver un objeto de usuario con el username igual a "prueba"

  Scenario: Actualizar la contraseña de un usuario
    Given que el usuario con username "prueba" desea cambiar su password por "654321"
    When se realiza el cambio de password
    Then el sistema debe retornar el mensaje "Password for user with username prueba has been updated"

  Scenario: Consultar el rol de un usuario
    Given que requiero consultar el rol de usuario con username "prueba"
    When realizo la consulta del rol por el username
    Then el sistema debe retornar "CUSTOMER"

  Scenario: Eliminar un usuario por el nombre
    Given que se quiere eliminar el usuario con username "prueba"
    When se elimina el usuario
    Then el sistema debe retornar el mensaje "User with username prueba was deleted"


