package com.smartcab.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.smartcab.command.TripCommand;

public class TripValidator implements Validator {

	@Override
	public boolean supports(Class<?> classType) {
		return classType.isAssignableFrom(TripCommand.class);
	}

	@Override
	public void validate(Object command, Errors errors) {
		TripCommand tCommand = null;

		tCommand = (TripCommand) command;

		if (isEmpty(tCommand.getName())) {
			errors.rejectValue("name", "name.blank");
		}

		if (isEmpty(tCommand.getContactMobile())) {
			errors.rejectValue("contactMobile", "contactmobile.blank");
		}

		if (isEmpty(tCommand.getEmergencyContact())) {
			errors.rejectValue("emergencyContact", "emergencycontact.blank");
		}
	}

	private static boolean isEmpty(String s) {
		if (s == null || s.equals("")) {
			return true;
		}
		return false;
	}

}
