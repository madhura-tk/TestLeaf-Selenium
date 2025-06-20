package week2.day4.homeAssignments.polymorphism;

public class APIClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		APIClient api = new APIClient();
		boolean response;
		response=api.sendRequest("Endpoint", "RequestBody", false);
		System.out.println(response);
		response=api.sendRequest("Endpoint");
		System.out.println(response);


	}
	
	public boolean sendRequest(String endpoint)
	{
		System.out.println("sendRequest(String endpoint) is overloaded ");
		System.out.println("Arguments passsed are :"+endpoint);

		return false;
	}
	
	
	public boolean sendRequest(String endpoint,String reqBody,boolean reqStatus)
	{
		System.out.println("sendRequest(String endpoint,String reqBody,boolean reqStatus) is overloaded ");
		System.out.println("Arguments passsed are endpoint: "+endpoint+" reqBody: "
				+reqBody+" reStatus: "+reqStatus);

		return true;
	}

}

