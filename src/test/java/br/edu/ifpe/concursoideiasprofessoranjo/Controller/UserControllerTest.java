package br.edu.ifpe.concursoideiasprofessoranjo.Controller;

import br.edu.ifpe.concursoideiasprofessoranjo.Controllers.UserController;
import br.edu.ifpe.concursoideiasprofessoranjo.Models.Users;
import br.edu.ifpe.concursoideiasprofessoranjo.Services.UserServices;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


public class UserControllerTest {

//    @Test
//    public void testCreateUser() {
//        // Cria um objeto Users de exemplo
//        Users user = new Users();
//        user.setId(1);
//        user.setName("Test User");
//        user.setEmail("test@example.com");
//        user.setPassword("password");
//
//        // Cria um mock do UserServices
//        UserServices userServices = mock(UserServices.class);
//        when(userServices.CreateUser(user)).thenReturn(user);
//
//        // Cria um objeto UserController e injeta o UserServices mockado
//        UserController userController = new UserController();
//        userController.setServices(userServices);
//
//        // Chama o método CreateUser do UserController e verifica se a resposta é igual ao objeto Users criado
//        var response = userController.CreateUser(user);
//        assertEquals(response.getBody(), user);
//
//        // Verifica se o método CreateUser do UserServices foi chamado
//        verify(userServices, times(1)).CreateUser(user);
//
//        assertEquals(HttpStatus.CREATED, response.getStatusCode());
//    }
//
//    @Test
//    public void testGetUser() {
//        // Cria uma lista de Users de exemplo
//        List<Users> userList = mock(List.class);
//        when(userList.size()).thenReturn(3);
//        when(userList.get(0)).thenReturn(new Users(1, "User 1", "user1@example.com", "default", "01020304056", "password", null));
//        when(userList.get(1)).thenReturn(new Users(2, "User 2", "user2@example.com", "default", "01020304056", "password", null));
//        when(userList.get(2)).thenReturn(new Users(3, "User 3", "user3@example.com", "default", "01020304056", "password", null));
//
//        // Cria um mock do UserServices
//        UserServices userServices = mock(UserServices.class);
//        when(userServices.GetUser()).thenReturn(userList);
//
//        // Cria um objeto UserController e injeta o UserServices mockado
//        UserController userController = new UserController();
//        userController.setServices(userServices);
//
//        // Chama o método GetUser do UserController e verifica se a resposta é igual à lista de Users criada
//        var response = userController.GetUser();
//        assertEquals(response.getBody(), userList);
//
//        // Verifica se o método GetUser do UserServices foi chamado
//        verify(userServices, times(1)).GetUser();
//
//        // Verifica se o status HTTP da resposta é 200 - OK
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//    }
}
