package com.udea.sagoa;


import com.udea.sagoa.dominio.user.UserService;
import com.udea.sagoa.dominio.user.dto.UserData;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class Steps {

    @Autowired
    private UserService userService;


    private UserData response;

    @When("Realizo la consulta para el usuario con id {long}")
    public void realizoLaConsutaParaElUsirarioConId(Long id) {
        response = userService.findById(id);
    }

    @Then("la respuesta debe incluir {string}")
    public void laRespuestaDebeIncluir(String user) {
        String body = response.userName();
        assertTrue(body.equals(user));
    }

}