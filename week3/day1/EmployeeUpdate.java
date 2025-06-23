package week3.day1;

public class EmployeeUpdate implements DatabaseConnection{

	public static void main(String[] args) {
		// TODO Auto-generated method stubS
		EmployeeUpdate emp = new EmployeeUpdate();
			
		emp.getConnect();
		emp.executeUpdate();
		emp.getUpdate("Employee", "E001");
		emp.getDisconnect();
		
	}
	
	public void getUpdate(String name,String id) {
		System.out.println("Employee details updated");
		}
	
	@Override
	public void executeUpdate() {
		System.out.println("Update method is called");
		
	}
	
	@Override
	public void getDisconnect() {
		System.out.println("Database disconnect method is called");

		
	}
	
	@Override
	public void getConnect() {
		// TODO Auto-generated method stub
		System.out.println("Database Connection method is called");

		
	}

}
