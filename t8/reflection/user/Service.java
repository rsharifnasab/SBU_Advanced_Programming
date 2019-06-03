package user;

import annotation.Connect;
import annotation.Instantiate;

@Instantiate
public class Service {

	@Connect
	private Manager manager;
	private Employee employee;

	public Manager getManager() {
		return manager;
	}

	public Employee getEmployee() {
		return employee;
	}

}
