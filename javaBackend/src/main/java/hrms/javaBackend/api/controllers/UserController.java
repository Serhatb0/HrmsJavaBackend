package hrms.javaBackend.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hrms.javaBackend.business.abstracts.UserService;
import hrms.javaBackend.core.dataAccess.ConfirmationTokenRepository;
import hrms.javaBackend.core.entities.ConfirmationToken;
import hrms.javaBackend.core.utilities.results.ErrorResult;
import hrms.javaBackend.core.utilities.results.Result;
import hrms.javaBackend.core.utilities.results.SuccessResult;
import hrms.javaBackend.entities.concretes.User;

@RestController
@RequestMapping(value = "/api/Users")
public class UserController {

	private ConfirmationTokenRepository confirmationTokenRepository;
	private UserService userService;

	@Autowired
	public UserController(ConfirmationTokenRepository confirmationTokenRepository, UserService userService) {
		super();
		this.confirmationTokenRepository = confirmationTokenRepository;
		this.userService = userService;
	}

	@RequestMapping(value = "/confirm-account", method = { RequestMethod.GET, RequestMethod.POST })
	public Result confirmUserAccount(@RequestParam("token") String confirmationToken) {
		ConfirmationToken token = confirmationTokenRepository.findByConfirmationToken(confirmationToken);

		if (token != null) {
			User user = userService.findByEmailIgnoreCase(token.getUser().getEmail()).getData();
			user.setActive(true);
			userService.add(user);
			return new SuccessResult("Aktif edildi");
		}
		return new ErrorResult("Aktif edilemedi");

	}
}
