package uuu.domain;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Pattern;

public class Customer implements Comparable<Customer>{
	public static final char MALE = 'M';
	public static final char FEMALE = 'F';

	private String id;
	private String name = "";
	private String password;
	private Date birthDate;
	private char gender = MALE;
	private String address;
	private String phone;
	private String email;
	private boolean married = false;
	private BloodType bloodtype;

	public BloodType getBloodtype() {
		return bloodtype;
	}

	public void setBloodtype(BloodType bloodtype) {
		this.bloodtype = bloodtype;
	}

	public Customer() {
	}

	public Customer(String id, String name, String address) {
		this.id = id;
		this.name = name;
		this.address = address;
	}
        public Customer(String id, String name, String address,String phone) {
		this.id = id;
		this.name = name;
		this.address = address;
                this.phone = phone;
	}
	public Customer(String id, String name, String password, Date birthDate,
			char gender, String address, String phone, String email,
			boolean married) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.birthDate = birthDate;
		this.gender = gender;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.married = married;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) throws UMallException {
		if (checkId(id)) {
			this.id = id;
		} else {
			System.out.println("身份證字號不正確");
			throw new UMallException("身分證資料不正確");
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name == null) {
			System.out.println("姓名資料不得為null");
			throw new RuntimeException("姓名資料不得為null");
		}
		name = name.trim();
		if (name.length() > 0) {
			this.name = name;
		} else {
			System.out.println("姓名資料不得為空白");
			throw new RuntimeException("Customer.Name.CanNotBeEmptyString");
		}
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		if (gender == MALE || gender == FEMALE) {
			this.gender = gender;
		} else
			System.out.println("性別資料不正確");
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isMarried() {
		return married;
	}

	public void setMarried(boolean married) {
		this.married = married;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	// ------------------------------------------------------------
	public void setBirthDate(Date birthDate) throws UMallException {
		if (birthDate != null && birthDate.before(new Date())) {
			this.birthDate = birthDate;
		} else {
			System.out.println("日期必須小於今天");
			throw new UMallException("日期必須小於今天");
		}
	}

	public void setBirthDate(int year, int month, int day)
			throws UMallException {
		this.setBirthDate(new GregorianCalendar(year, month - 1, day).getTime());
	}

	public void setBirthDate(String date) throws UMallException {
		try {
			// Date c = new SimpleDateFormat("yyyy-M-d").parse(date);
			Date d = DateFormat.getDateInstance().parse(date);
			this.setBirthDate(d);
		} catch (ParseException e) {
			System.out.print("日期格式不正確：" + e);
			throw new UMallException("日期格式不正確");
			// e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "客戶id：" + id + "\n客戶名稱=" + name + "\n" + "生日：" + birthDate
				+ "\n性別：" + gender + "\n" + "地址：" + address + "\n電話：" + phone
				+ "\n郵件：" + email;
	}

	// ---------------------------------------------------------------
	/**
	 * 身分證檢查規則
	 */
	public static boolean checkId(String id) {
		boolean answer = false;
		if (id == null || id.length() != 10) {
			return answer;
		} else {
			final String pattern = "^[A-Z][12][0-9]{8}$";
			final Pattern p = Pattern.compile(pattern);
			if (p.matcher(id).matches()) {
				char last_char = id.charAt(9);
				if (last_char == getLastNumberFromId(id.substring(0, 9))) {
					answer = true;
				}
			}
		}
		return answer;
	}

	public static char getLastNumberFromId(String id_9) {
		char first_char = id_9.charAt(0);
		char last_char = '\u0000';

		int s = 0;
		if (first_char >= 'A' && first_char <= 'H') {
			s = (first_char - 'A' + 10);
		} else if (first_char >= 'J' && first_char <= 'N') {
			s = (first_char - 'J' + 18);
		} else if (first_char >= 'P' && first_char <= 'V') {
			s = (first_char - 'P' + 23);
		} else {
			switch (first_char) {
			case 'I':
				s = 34;
				break;
			case 'O':
				s = 35;
				break;
			case 'W':
				s = 32;
				break;
			case 'X':
				s = 30;
				break;
			case 'Y':
				s = 31;
				break;
			case 'Z':
				s = 33;
				break;
			default:
				System.out.println("不可能");
				assert false : "assert1錯誤" + first_char;
			}
		}

		assert (s >= 10 && s <= 35) : "assert2錯誤" + s;

		int data = (s / 10) * 1 + (s % 10) * 9;
		for (int i = 1; i < 9; i++) {
			int c = Integer.parseInt(id_9.charAt(i) + "") * (8 - i + 1);
			data += c;
		}
		last_char = (char) (10 - (data % 10) + '0');

		assert (last_char >= '0' && last_char <= '9') : "assert3錯誤" + last_char;
		return last_char;
	}

	// /equals , hashCode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result
				+ ((birthDate == null) ? 0 : birthDate.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + gender;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (married ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (birthDate == null) {
			if (other.birthDate != null)
				return false;
		} else if (!birthDate.equals(other.birthDate))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (gender != other.gender)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (married != other.married)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		return true;
	}

	@Override
	public int compareTo(Customer o) {
		return this.id.compareTo(o.id);
	}



}
