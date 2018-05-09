package com.questionbank.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.questionbank.dao.ProfessionMapper;
import com.questionbank.dao.SubjectMapper;
import com.questionbank.dao.TeacherMapper;
import com.questionbank.domain.Profession;
import com.questionbank.domain.Subject;
import com.questionbank.domain.Teacher;
import com.questionbank.service.InformationService;

@Service
public class InformationServiceImpl implements InformationService{

	@Autowired
	private TeacherMapper teacherDao;
	
	@Autowired
	private ProfessionMapper professionDao;
	
	@Autowired
	private SubjectMapper subjectDao;
	
	
	
	@Override
	public boolean addNewTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		if(teacherDao.insertSelective(teacher)!=0)
			return true;
		return false;
	}

	@Override
	public boolean updateTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		if(teacherDao.updateByPrimaryKeySelective(teacher)!=0)
			return true;
		return false;
	}

	@Override
	public boolean deleteTeacher(String teacherId) {
		// TODO Auto-generated method stub
		if(teacherDao.deleteByPrimaryKey(teacherId)!=0)
			return true;
		return false;
	}

	@Override
	public List<Teacher> getAllTeacher() {
		// TODO Auto-generated method stub
		List<Teacher> teachers=null;
		if((teachers=teacherDao.selectAll())!=null){
			return teachers;
		}
		return null;
	}

	@Override
	public boolean addNewProfession(Profession profession) {
		// TODO Auto-generated method stub
		if(professionDao.insertSelective(profession)!=0)
			return true;
		return false;
	}

	@Override
	public boolean updateProfession(Profession profession) {
		// TODO Auto-generated method stub
		if(professionDao.updateByPrimaryKeySelective(profession)!=0)
			return true;
		return false;
	}

	@Override
	public boolean deleteProfession(Integer professionId) {
		// TODO Auto-generated method stub
		if(professionDao.deleteByPrimaryKey(professionId)!=0)
			return true;
		return false;
	}

	@Override
	public List<Profession> getAllProfession() {
		// TODO Auto-generated method stub
		List<Profession> profession=null;
		if((profession=professionDao.selectAll())!=null){
			return profession;
		}
		return null;
	}

	@Override
	public boolean addNewSubject(Subject subject) {
		// TODO Auto-generated method stub
		if(subjectDao.insertSelective(subject)!=0)
			return true;
		return false;
	}

	@Override
	public boolean updateSubject(Subject subject) {
		// TODO Auto-generated method stub
		if(subjectDao.updateByPrimaryKeySelective(subject)!=0)
			return true;
		return false;
	}

	@Override
	public boolean deleteSubject(Integer subjectId) {
		// TODO Auto-generated method stub
		if(subjectDao.deleteByPrimaryKey(subjectId)!=0)
			return true;
		return false;
	}

	@Override
	public List<Subject> getAllSubject() {
		// TODO Auto-generated method stub
		List<Subject> subject=null;
		if((subject=subjectDao.selectAll())!=null){
			return subject;
		}
		return null;
	}
	
	

}
