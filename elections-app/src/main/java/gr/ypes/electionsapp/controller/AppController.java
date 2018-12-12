package gr.ypes.electionsapp.controller;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.keycloak.KeycloakPrincipal;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getHome() {
		return "index";
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String getUser(Principal principal, Model model) {
		model.addAttribute("user", principal.getName());
		String str = principal.getName() + "<br/>";
		str += ((KeycloakAuthenticationToken) principal).getAuthorities().toString();
		if(!principal.getName().isEmpty())
			return str;
		return "user";
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String getAdmin(Principal principal, Model model) {
		model.addAttribute("admin", principal.getName());
		return "admin";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public void handleLogout(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		request.logout();
		response.sendRedirect("/");
	}

}
