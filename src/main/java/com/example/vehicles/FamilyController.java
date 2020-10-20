package com.example.vehicles;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Entity
@Table(name="Family")
class Family {
	@Id
	@GeneratedValue
	private int id; // primary key
	private int resident_id; // foreign key
	private String name;
	private int age;
	private BigInteger phno;
	private String email;
	
	public Family() {}

	public Family(String resident_id, String phno,String name, String age, String email) {
		super();
		this.resident_id = Integer.parseInt(resident_id);
		this.name = name;
		this.age = Integer.parseInt(age);
		this.phno =new BigInteger(phno);
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getResident_id() {
		return resident_id;
	}

	public void setResident_id(int resident_id) {
		this.resident_id = resident_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public BigInteger getPhno() {
		return phno;
	}

	public void setPhno(BigInteger phno) {
		this.phno = phno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}

@Repository
interface FamilyRepository extends CrudRepository<Family,Integer> {}


@RestController
@CrossOrigin(origins = "http://skyview24x7.com")
@RequestMapping("/family")
public class FamilyController {

	@Autowired
	private FamilyRepository famrepo;
	
	@GetMapping(value="/getall", produces="application/json")
	public List<Family> getMembers()
	{
		return (List<Family>) famrepo.findAll();
	}
	
	@GetMapping(value="/getall/{id}")
	public Optional<Family> getMember(@PathVariable int id)
	{
		return famrepo.findById(id);
	}
	
	@PostMapping(value="/addmember")
	public void addMember(@RequestBody Family member)
	{
		famrepo.save(member);
	}
	
	@DeleteMapping(value="/getall/{id}")
	public void deleteMember(@PathVariable int id)
	{
		famrepo.deleteById(id);
	}
	
	@PutMapping(value="/getall/{id}")
	public void updateMember(@RequestBody Family member,@PathVariable int id)
	{
		Optional<Family> toupdate = famrepo.findById(id);
		member.setId(id);
		famrepo.save(member);
	}
	
}
