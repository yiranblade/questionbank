package com.questionbank.service;

import java.util.List;

import com.questionbank.domain.Profession;
import com.questionbank.domain.Subject;
import com.questionbank.domain.Teacher;

public interface InformationService {
	
	public boolean addNewTeacher(Teacher teacher);
	public boolean updateTeacher(Teacher teacher);
	public boolean deleteTeacher(String teacherId);
	public List<Teacher> getAllTeacher();
	
	public boolean addNewProfession(Profession profession);
	public boolean updateProfession(Profession profession);
	public boolean deleteProfession(Integer professionId);
	public List<Profession> getAllProfession();
	
	public boolean addNewSubject(Subject subject);
	public boolean updateSubject(Subject subject);
	public boolean deleteSubject(Integer subjectId);
	public List<Subject> getAllSubject();

}
