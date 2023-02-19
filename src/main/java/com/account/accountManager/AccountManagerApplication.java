package com.account.accountManager;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@SpringBootApplication
@Controller
public class AccountManagerApplication {
	 @Autowired
	
	private AccountRepository accountRepository;
    public static void main(String[] args) {
      SpringApplication.run(AccountManagerApplication.class, args);
    }
    
    @GetMapping("/")
    public String myPage(Model model) {
    	Iterable<Account> accounts = accountRepository.findAll();
        model.addAttribute("accounts", accounts);
        return "index";
    }
    @PostMapping("/")
    public String processForm(@RequestParam("name") String name,@RequestParam("gmail") String gmail, @RequestParam("password") String password) {
    	Account account = new Account();
    	account.setName(name);
    	account.setEmail(gmail);
    	account.setPassword(password);
    	accountRepository.save(account);
    	return "redirect:/";
    }
}