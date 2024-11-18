Feature: Consultar usuarios

  Scenario: Obtener todos los usuarios
    When Realizo la consulta para el usuario con id 1
    Then la respuesta debe incluir "Chucho.Guzman2595"

