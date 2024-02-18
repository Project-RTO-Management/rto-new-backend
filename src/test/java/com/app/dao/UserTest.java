package com.app.dao;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.app.entities.Address;
import com.app.entities.Gender;
import com.app.entities.Role;
import com.app.entities.User;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserTest {
	@Autowired
	private UserDao dao;
	@Autowired
	private AddressDao adrDao;

	@Test
	void testSaveUser() {
		/*
		 *  String userName, String s_d_w, String email, String password, String phoneNo, Role role, Gender gender,
			LocalDate birthDate, Address permanentAddress, Address correspondAdd
		 */
		List<User> list = List.of(
				new User("Unnati Kurekar","Dnyaneshwar Kurekar","unnati@gmail.com","unnati@123","9689393813",Role.ADMIN,Gender.FEMALE,LocalDate.parse("1996-01-03") ),
				new User("Akanksha Aage","Somnath Satpute","akanksha@gmail.com","akan@123","9689393492",Role.TRAFFICPOLICE,Gender.FEMALE,LocalDate.parse("1998-09-26") ),
				new User("Pranav Bhandare","Milind Bhandare","pranav@gmail.com","prav@123","9689393681",Role.TRAFFICPOLICE,Gender.MALE,LocalDate.parse("1999-11-21") ),
				new User("Manoj Kumar","Rahul Kumar","manoj@gmail.com","manoj@123","9689398513",Role.APPLICANT,Gender.MALE,LocalDate.parse("1986-11-29") )
				);
		
		List<User> list2 = dao.saveAll(list);
		List<Address> adrList1 = List.of(
				new Address("Tilak Rd", "Wani", "MH", "India", "445304"),
				new Address("M G Rd", "Bangalore", "KA", "India", "566020"),
				new Address("Laxman Rd", "Kolhapur", "MH", "India", "411221"),
				new Address("Sindh Rd", "Bhopal", "MP", "India", "410021"));
		assertEquals(4, list2.size());
		
		List<Address> adrList2 = List.of(
				new Address("Rajveer Palace", "Pune", "MH", "India", "411020"),
				new Address("M G Rd", "Bangalore", "KA", "India", "566020"),
				new Address("Laxmi Rd", "Pune", "MH", "India", "411001"),
				new Address("Jawahar Rd", "Kanpur", "MP", "India", "400221"));
		assertEquals(4, list2.size());
		
		for(int i=0;i<list2.size();i++)
		{
			adrList1.get(i).setUser(list.get(i));
			adrList2.get(i).setUser(list.get(i));
			list.get(i).setPermanentAddress(adrList1.get(i));
			list.get(i).setCorrespondAdd(adrList2.get(i));
			//adrList.get(i).setEmp(list2.get(i));//setting up uni dir asso from Adr -->Emp
			adrDao.save(adrList1.get(i));//saving adr details explicitly
			adrDao.save(adrList2.get(i));
			dao.save(list.get(i));
		}	
	}	}




