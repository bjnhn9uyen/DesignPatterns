package extra_DAOPattern_FactoryMethod.BussinessObjects;

public class Staff {

	private int id;
	private String name;
	private String gender;
	private int age;
	private String address;

	public Staff(int id, String name, String gender, int age, String address) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getGender() {
		return gender;
	}

	public int getAge() {
		return age;
	}

	public String getAddress() {
		return address;
	}

	@Override
	public String toString() {
		return "\t\tId: " + id + "\n" + "\t\tName: " + name + "\n" + "\t\tGender: " + gender + "\n"
								+ "\t\tAge: " + age + "\n" + "\t\tAddress: " + address;
	}

}
