package com.example.demo.employeeservice.domain.valueobject;


public class EmployeeVO {
	Long id;
	String name;
	String Title;
	String Group;
	
	
	public EmployeeVO(String name, String title, String group) {
		this.name = name;
		this.Title = title;
		this.Group = group;
	}

	@Override
	public String toString() {
		return new StringBuilder("{ Id : ").append(id)
				.append(", name : ").append(name)
				.append(", title : ").append(Title)
				.append(", group : ").append(Group)				
				.append("}")
				.toString();
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getGroup() {
		return Group;
	}

	public void setGroup(String group) {
		Group = group;
	}

		
}
