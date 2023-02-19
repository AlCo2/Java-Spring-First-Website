package com.account.accountManager;

import org.springframework.data.repository.CrudRepository;
import com.account.accountManager.Account;


public interface AccountRepository extends CrudRepository<Account, Integer>{
	
}
