package com.example.vehicles;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Entity
@Table(name="residents_table")

class Residents{
	@Id
	private int residentId;
	private String name;
	private int age;
	private BigInteger phno;
	private String email;
    
    public Residents() {}
    
	public Residents(String residentId, String name, String age, String phno, String email) {
		super();
		this.residentId = Integer.parseInt(residentId);
		this.name = name;
		this.age = Integer.parseInt(age);
		this.phno = new BigInteger(phno);
		this.email = email;
	}
	
	public int getResidentId() {
		return residentId;
	}
	public void setResidentId(int residentId) {
		this.residentId = residentId;
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
interface ProfileRepository extends CrudRepository<Residents,Integer> {}

@RequestMapping("/profile")
@CrossOrigin(origins = "http://skyview24x7.com")
@RestController
public class ProfileController {
	@Autowired
	private ProfileRepository repo;
	
	@GetMapping(value="/getmembers",produces = "application/json")
	public List<Residents> getResidents(){
		return (List<Residents>) repo.findAll();
	}
	
	@PutMapping(value="/getmembers/{id}")
	public void updateProfile(@RequestBody Residents updated, @PathVariable int id)
	{
		Optional<Residents> res = repo.findById(id);
		updated.setResidentId(id);
		repo.save(updated);
	}
	@RequestMapping(method=RequestMethod.GET,value="/getmembers/{id}")
	public Residents getMember(@PathVariable("id") int id)
	{
		Optional<Residents> member=repo.findById(id);
		return member.get();
		
	}
}
