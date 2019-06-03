package user;


import annotation.Connect;
import annotation.Instantiate;

@Instantiate
public class Manager {

	@Connect
	private Developer developer;

	public Developer getDeveloper() {
		return developer;
	}

}
