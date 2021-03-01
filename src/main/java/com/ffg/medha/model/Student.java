package com.ffg.medha.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@Getter
@Setter

public class Student {
    protected String emailId;
    protected String password;
    protected String firstName;
    protected String lastName;
    protected String address;
    protected String phoneNumber;
    protected String gender;
    protected String category;
    protected String relativeName;
    protected String parentsOccupation;
    protected String aadharNumber;
    protected String noOfEarningFamilyMembers;
    protected String totalHouseholdIncome;
    protected String ownGadget;
    protected String courseName;
    protected String collegeName;
    protected String completedAcademicYear;
    protected String about;
    protected String areaOfInterest;
    protected String hoursAllocation;
    protected boolean needsNgoApproval;
}
