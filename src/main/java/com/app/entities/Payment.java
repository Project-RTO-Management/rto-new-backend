package com.app.entities;

import javax.persistence.Column;
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
@Table(name="payment")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Payment extends BaseEntity{
@Enumerated(EnumType.STRING)
private PaymentMode paymentMode;
@Enumerated(EnumType.STRING)
private PaymentType paymentType;
@Column(nullable = false)
private double amount;

@OneToOne
@JoinColumn(name="fine_id", nullable = false)
private Fine fine;
@OneToOne
@JoinColumn(name="veh_reg_id", nullable = false)
private VehicleRegistration vehReg;
@OneToOne
@JoinColumn(name="exam_app_id", nullable = false)
private examApplication examApp;
}
