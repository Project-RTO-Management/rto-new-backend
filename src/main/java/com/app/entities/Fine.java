package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="fine")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Fine extends BaseEntity {
	@Column(length = 20, unique = true, nullable = false)
	private String challanNo;
	@Column(length=30, nullable = false)
	private String voilationType;
	@Column(length=30, nullable = false)
	private String noPlate;
	@Column(nullable = false)
	private LocalDate dateOfIssue;
	@Column(nullable = false)
	private LocalDate validTill;

	@ManyToOne
	@JoinColumn(name="user_id", nullable = false)
	private User user;
	@OneToOne
	@JoinColumn(name="payment_id", nullable = false)
	private Payment payment;
}
