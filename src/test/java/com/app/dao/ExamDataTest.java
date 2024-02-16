package com.app.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.app.entities.Answer;
import com.app.entities.ExamData;
import com.app.entities.User;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class ExamDataTest {
	@Autowired
	private ExamDataDao dao;
	

	@Test
	void testSaveExamData() {
		//(String questions, String optA, String optB, String optC, String optD, Answer correctAns)
		List<ExamData> list = List.of(
				new ExamData("What is the legal age to ride a motorcycle without a gear?",
						"20 years", "18 years", "16 years", "25 years", Answer.C),
				new ExamData("When pedestrians are crossing the road near a pedestrian crossing, you should",
						"Slow down, sound the horn, and then continue", " Sound the horn, and then continue", "Stop the vehicle and wait for pedestrians to cross the road before continuing", "None of these", Answer.C),
				new ExamData("Which side of the road should a vehicle's driver drive on?",
						"Left side", "Right side", "Middle", "Footpath", Answer.A),
				new ExamData("If you are on a one way", "Parking your vehicle is prohibited", " It is not advisable to drive in reverse gear",
						"Overtaking another vehicle is prohibited", "Both Option B and C", Answer.B),
				new ExamData("What does a red traffic signal signify?", "Vehicle should be slowed down",
						" Drive with caution", " Stop the vehicle completely", "None of these", Answer.C),
				new ExamData("When should we use the fog lamps?", " During night", "When the vehicle in front of you is not using dim lights",
						" Mist is present", "During daytime", Answer.C),
				new ExamData("What does a yellow light during traffic signify?", "Stop the vehicle completely",
						" Slow down the vehicle", "Reduce your vehicle's speed and drive cautiously", "Parking your vehicle is prohibited", Answer.C),
				new ExamData("Which vehicle is permitted to go at a speed of 60 kilometers per hour?",
						"Truck/heavy bus", " Cars", "None of the above", "Both", Answer.B),
				new ExamData("What does over speeding?", " An offence that may result in your driver's licence being revoked or suspended",
						" Is not an offence and be overlooked", "Is an offence, although no charges will be pressed", "None of the above", Answer.A),
				new ExamData("If a vehicle is parked on the side of the road late at night", "The parking light should be left on",
						" It is necessary to lock the car", "None of the above", "Both", Answer.A),
				new ExamData("A person who drives a car in a public without a licence is liable for the following penalties:", "A word of caution",
						"Seizure of the vehicle and/or penalties for the driver and owner", "Only penalty", "2 years of Jail", Answer.B),
				new ExamData(" No honking is permitted in the vicinity of", "Hospitals, courts, and schools",
						" Police station", "Shopping places", "Public garden", Answer.A),
				new ExamData(" Where is parking of vehicle is prohibited?", "One-way road", "Middle of the road", "Footpath", "Left of road", Answer.C),
				new ExamData("When should you halt your vehicle?", "When involved in an accident or signaled by a traffic police",
						"While approaching a red traffic light", " None of the above", "Both", Answer.C),
				new ExamData("What should you do when an ambulance is approaching?", "Move to the side of the road to provide free passage",
						"Ignore the ambulance", "If there are no vehicles on other side, allow passage", "If there are vehicles on other side, ignore ambulance", Answer.A),
				new ExamData("Wearing a helmet on State & National highways is",
						"Mandatory", "Necessary", "Optional", "Sometime", Answer.A),
				new ExamData("Using cell phone while driving is", "Allowed on roads with less traffic",
						"Allowed if driven carefully", "An offence", "None of These", Answer.C),
				new ExamData("Check tyre pressure", "While tyres are hot", "While tyres are cold", "Any time", "Both A and B", Answer.B),
				new ExamData("Permissible alcohol level in blood prescribed by M.V. Act is", "50 mg. per 100 ml of blood",
						"30 mg. per 100 ml of blood", "No alcohol allowed", "70 mg. per 100 ml of blood", Answer.B),
				new ExamData("What is the validity of registration of motor cycle & car?",
						"10 years", "18 years", "20 years", "15 years", Answer.D),
				new ExamData("Changing the lanes on multilane road is",
						"Prohibited", "Permitted", "Not advised to change", "As required", Answer.B)
				);
		
		List<ExamData> list2=	dao.saveAll(list);
		for(int i=0;i<list.size();i++)
		{
			dao.save(list2.get(i));
		}
	}
}
