package com.example.vehicles;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dailyhelp")
class Dailyhelp {

	@Id
	private int id;
	private String name;
	private int age;
	private BigInteger phno;
	private String gender;
	private boolean status;

	public Dailyhelp() {}
		
	public Dailyhelp(int id,String name, int age, String gender,boolean status) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.status = status;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}
	public BigInteger getPhno() {
		return phno;
	}

	public void setPhno(BigInteger phno) {
		this.phno = phno;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String getGender() {
		return gender;
	}
		
}

@Repository
 interface DailyhelpRepository extends JpaRepository<Dailyhelp,Integer>{

	@Transactional
	@Modifying
    @Query("UPDATE Dailyhelp d SET d.status=:status where d.id = :id")
    void statusToSelect(@Param("status") boolean status, @Param("id") int id);
	
	
	@Transactional
	@Modifying
    @Query("UPDATE Dailyhelp d SET d.status=:status where d.id = :id")
    void statusToUnselect(@Param("status") boolean status, @Param("id") int id);

}

@RequestMapping("/dailyhelp")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class DailyhelpController {

	@Autowired
	private DailyhelpRepository help;
	
	@GetMapping(value="/getall",produces = "application/json")
	public List<Dailyhelp> getPersons()
	{
		return (List<Dailyhelp>) help.findAll();
	}
	
	@GetMapping(value="/getperson/{id}")
	public Dailyhelp getPersonById(@PathVariable("id") int id)
	{
		Optional<Dailyhelp> person=help.findById(id);
		return person.get();	
	}
	
	@PutMapping(value="/select/{id}")
	public void changeStatusToSelect(@RequestBody Dailyhelp person, @PathVariable int id) {
		help.statusToSelect(true,id);
	}
	
	@PutMapping(value="/unselect/{id}")
	public void changeStatusToUnselect(@RequestBody Dailyhelp person, @PathVariable int id) {
		help.statusToUnselect(false,id);
	}

}
