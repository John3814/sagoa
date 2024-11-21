package com.udea.sagoa;

import com.udea.sagoa.dominio.user.dto.UserData;
import com.udea.sagoa.dominio.user.dto.UserResgistrationData;
import com.udea.sagoa.dominio.user.interfaces.UserService;
import com.udea.sagoa.dominio.user.model.Role;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class Steps {

    @Autowired
    private UserService userService;

    private UserResgistrationData userResgistrationData;
    private UserData registeredUser;
    private String userName;
    private String password;
    private Role role;
    private String responseMessage;


    //Registro de un usuario

    @Given("que se va a registrar un usuario con los siguientes datos username {string}, role {string} y password {string}")
    public void queSeVaARegistrarUnUsuarioConLosSiguientesDatos(String userName, String role, String password) {
        userResgistrationData = new UserResgistrationData(userName, password, Role.valueOf(role));
    }

    @When("se registra al usuario con esos datos")
    public void seRegistraAlUsuarioConEsosDatos() {
        registeredUser = this.userService.addUser(userResgistrationData);
    }

    @Then("el sistema debe devolver un objeto de usuario con el username igual a {string}")
    public void elSistemaDebeDevolverUnObjetoDeUsuarioConElUsernameIgualA(String userName) {
        assertNotNull(registeredUser);
        assertEquals(registeredUser.userName(), userName);
    }


    //Actualizar la contraseña de un usuario

    @Given("que el usuario con username {string} desea cambiar su password por {string}")
    public void queElUsuarioConUsernameDeseaCambiarSuPasswordPor(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    @When("se realiza el cambio de password")
    public void seRealizaElCambioDePassword() {
        this.responseMessage = this.userService.updatePassword(this.userName, this.password);
    }

    @Then("el sistema debe retornar el mensaje {string}")
    public void elSistemaDebeRetornarElMensaje(String message) {
        assertNotNull(this.responseMessage);
        assertEquals(responseMessage, message);
    }


    //Consultar el rol de un usuario

    @Given("que requiero consultar el rol de usuario con username {string}")
    public void queRequieroConsultarElRolDeUsuarioConUsername(String userName) {
        this.userName = userName;
    }

    @When("realizo la consulta del rol por el username")
    public void realizoLaConsultaDelRol() {
        this.role = this.userService.getRoleByUsername(userName);
    }

    @Then("el sistema debe retornar {string}")
    public void elSistemaDebeRetornar(String role) {
        assertEquals(Role.valueOf(role), this.role);
    }


    //Eliminar un usuario por el nombre

    @Given("que se quiere eliminar el usuario con username {string}")
    public void queSeQuiereEliminarElUsuarioConUsername(String username) {
        this.userName = username;
    }

    @When("se elimina el usuario")
    public void seEliminaElUsuario() {
        this.responseMessage = this.userService.deleteUserByUsername(this.userName);
    }


}