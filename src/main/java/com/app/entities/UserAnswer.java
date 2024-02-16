package com.app.entities;


import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="user_answer")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserAnswer extends BaseEntity {
	@Enumerated(EnumType.STRING)
	private Answer ans;

	@OneToOne
	@JoinColumn(name="examdata_id",nullable = false)
	private ExamData examdata;
}
