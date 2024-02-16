package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@Table(name="examApplication")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class examApplication extends BaseEntity{
	@Column(nullable = false)
	private LocalDate dateOfAppl;
	@Enumerated(EnumType.STRING)
	private examType examType;

	@OneToOne
	@JoinColumn(name="user_id", nullable = false)
	private User user;
	@OneToOne
	@JoinColumn(name="payment_id", nullable = false)
	private Payment payment;
}
