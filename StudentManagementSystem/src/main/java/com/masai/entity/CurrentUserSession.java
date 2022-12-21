package com.masai.entity;


import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
@Data
public class CurrentUserSession {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotNull
	private String userName;
	
	@NotNull
	private String uuid;
	
	@NotNull
	private LocalDateTime localDateTime;

	public CurrentUserSession(String userName, String uuid, LocalDateTime localDateTime) {
		super();
		this.userName = userName;
		this.uuid = uuid;
		this.localDateTime = localDateTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}

	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}

	public CurrentUserSession(Integer id, @NotNull String userName, @NotNull String uuid,
			@NotNull LocalDateTime localDateTime) {
		super();
		this.id = id;
		this.userName = userName;
		this.uuid = uuid;
		this.localDateTime = localDateTime;
	}

	public CurrentUserSession() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
