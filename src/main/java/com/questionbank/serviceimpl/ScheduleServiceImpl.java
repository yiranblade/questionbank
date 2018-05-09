package com.questionbank.serviceimpl;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.questionbank.dao.ScheduleInfoMapper;
import com.questionbank.dao.ScheduleMapper;
import com.questionbank.dao.SchedulePaperMapper;
import com.questionbank.dao.SetMarkMapper;
import com.questionbank.dao.SubjectMapper;
import com.questionbank.dao.TeacherMapper;
import com.questionbank.domain.Schedule;
import com.questionbank.domain.ScheduleInfo;
import com.questionbank.domain.SchedulePaper;
import com.questionbank.domain.SetMark;
import com.questionbank.domain.Subject;
import com.questionbank.domain.Teacher;
import com.questionbank.dto.IndicatorDto;
import com.questionbank.dto.ScheduleDto;
import com.questionbank.dto.SchedulePaperDto;
import com.questionbank.service.ScheduleService;
import com.questionbank.util.Paper_Word;

@Service
public class ScheduleServiceImpl implements ScheduleService{
	
	@Autowired
	private ScheduleMapper scheduleDao;
	@Autowired
	private ScheduleInfoMapper scheduleInfoDao;
	@Autowired
	private SetMarkMapper setMarkDao;
	
	@Autowired
	private SubjectMapper subjectDao;
	
	@Autowired
	private TeacherMapper teacherDao;
	
	@Autowired
	private SchedulePaperMapper schedulePaperDao;
	
	
	
	@Override
	public boolean addSchedule(ScheduleDto scheduleDto) {
		// TODO Auto-generated method stub
		if(scheduleDto!=null){
			Schedule schedule=scheduleDto.getSchedule();
			List<ScheduleInfo> scheduleInfos=scheduleDto.getScheduleInfo();
			List<SetMark> setMarks=scheduleDto.getSetMark();
			scheduleDao.insertSelective(schedule);
			Integer scheduleId=scheduleDao.selectLastId();
			for(int i=0;i<scheduleInfos.size();i++){
				ScheduleInfo scheduleInfo=scheduleInfos.get(i);
				scheduleInfo.setScheduleId(scheduleId);
				System.out.println(scheduleInfos.size());
				scheduleInfoDao.insertSelective(scheduleInfo);
			}
			for(int i=0;i<setMarks.size();i++){
				SetMark setMark=setMarks.get(i);
				setMark.setScheduleId(scheduleId);
				setMarkDao.insertSelective(setMark);
			}
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteScheduleByScheduleId(Integer scheduleId) {
		// TODO Auto-generated method stub
		if(scheduleId!=null){
			scheduleDao.deleteByPrimaryKey(scheduleId);
			scheduleInfoDao.deleteByScheduleId(scheduleId);
			setMarkDao.deleteByScheduleId(scheduleId);
			return true;
		}
		return false;
	}

	@Override
	public boolean updateSchedule(ScheduleDto scheduleDto) {
		// TODO Auto-generated method stub
		if(scheduleDto!=null){
			Schedule schedule=scheduleDto.getSchedule();
			List<ScheduleInfo> scheduleInfos=scheduleDto.getScheduleInfo();
			List<SetMark> setMarks=scheduleDto.getSetMark();
			scheduleDao.updateByPrimaryKeySelective(schedule);
			for(int i=0;i<scheduleInfos.size();i++){
				scheduleInfoDao.updateByPrimaryKeySelective(scheduleInfos.get(i));
			}
			for(int i=0;i<setMarks.size();i++){
				setMarkDao.updateByPrimaryKeySelective(setMarks.get(i));
			}
			return true;
		}
		return false;
	}

	@Override
	public List<ScheduleDto> getAllScheduleDto() {
		// TODO Auto-generated method stub
		List<Schedule> schedules=scheduleDao.selectAll();
		List<ScheduleDto> scheduleDtos=null;
		List<ScheduleInfo> scheduleInfos=null;
		List<SetMark> setMarks=null;
		scheduleDtos=new ArrayList<ScheduleDto>();
		for(int i=0;i<schedules.size();i++){
			ScheduleDto scheduleDto=new ScheduleDto();
			Schedule schedule=schedules.get(i);
			scheduleInfos=scheduleInfoDao.selectByScheduleId(schedule.getScheduleId());
			setMarks=setMarkDao.selectByScheduleId(schedule.getScheduleId());
			scheduleDto.setSchedule(schedule);
			scheduleDto.setScheduleInfo(scheduleInfos);
			scheduleDto.setSetMark(setMarks);
			scheduleDtos.add(scheduleDto);	
		}
		return scheduleDtos;
	}

	@Override
	public SchedulePaper generateSchedulePaperByScheduleId(Integer scheduleId) {
		// TODO Auto-generated method stub
		Map<String,Object> scheduleList=new HashMap<String,Object>();
		Schedule schedule=scheduleDao.selectByPrimaryKey(scheduleId);
		List<ScheduleInfo> scheduleInfos=scheduleInfoDao.selectByScheduleId(scheduleId);
		List<SetMark> setMarks=setMarkDao.selectByScheduleId(scheduleId);
		scheduleList.put("term",schedule.getTerm());
		scheduleList.put("college", "计算机学院");
		Subject subject=subjectDao.selectByPrimaryKey(schedule.getSubjectId());
		scheduleList.put("subject", subject.getSubjectName());
		scheduleList.put("studyterm","48");
		Teacher teacher=teacherDao.selectByPrimaryKey(schedule.getTeacherId());
		scheduleList.put("teacher", teacher.getTeacherName());
		scheduleList.put("grade",schedule.getGrade());
		scheduleList.put("createtime", schedule.getCreatetime());
		scheduleList.put("testtime",schedule.getTestTime());
		scheduleList.put("mark",schedule.getAvgRecord());
		
		List<ScheduleInfo> scheduleInfoListA=getScheduleInfoByType(1, scheduleInfos);
		List<SchedulePaperDto> scheduleListA=new ArrayList<SchedulePaperDto>();
		SetMark setMarkA=getQuestionMark(1, setMarks);
		for(int i=0;i<scheduleInfoListA.size();i++){
			SchedulePaperDto schedulePaper=new SchedulePaperDto();
			ScheduleInfo scheduleInfo=scheduleInfoListA.get(i);
			schedulePaper.setOrder(scheduleInfo.getOrders());
			schedulePaper.setMark(setMarkA.getMark());
			schedulePaper.setIndicator(scheduleInfo.getIndicator());
			schedulePaper.setIndicatorlevel(scheduleInfo.getIndicatorLevel());
			scheduleListA.add(schedulePaper);
		}
		scheduleList.put("scheduleListA", scheduleListA);
		
		List<ScheduleInfo> scheduleInfoListB=getScheduleInfoByType(2, scheduleInfos);
		List<SchedulePaperDto> scheduleListB=new ArrayList<SchedulePaperDto>();
		SetMark setMarkB=getQuestionMark(2, setMarks);
		for(int i=0;i<scheduleInfoListB.size();i++){
			SchedulePaperDto schedulePaper=new SchedulePaperDto();
			ScheduleInfo scheduleInfo=scheduleInfoListA.get(i);
			schedulePaper.setOrder(scheduleInfo.getOrders());
			schedulePaper.setMark(setMarkB.getMark());
			schedulePaper.setIndicator(scheduleInfo.getIndicator());
			schedulePaper.setIndicatorlevel(scheduleInfo.getIndicatorLevel());
			scheduleListA.add(schedulePaper);
		}
		scheduleList.put("scheduleListB", scheduleListB);
		
		
		List<ScheduleInfo> scheduleInfoListC=getScheduleInfoByType(3, scheduleInfos);
		List<SchedulePaperDto> scheduleListC=new ArrayList<SchedulePaperDto>();
		SetMark setMarkC=getQuestionMark(3, setMarks);
		for(int i=0;i<scheduleInfoListC.size();i++){
			SchedulePaperDto schedulePaper=new SchedulePaperDto();
			ScheduleInfo scheduleInfo=scheduleInfoListC.get(i);
			schedulePaper.setOrder(scheduleInfo.getOrders());
			schedulePaper.setMark(setMarkC.getMark());
			schedulePaper.setIndicator(scheduleInfo.getIndicator());
			schedulePaper.setIndicatorlevel(scheduleInfo.getIndicatorLevel());
			scheduleListA.add(schedulePaper);
		}
		scheduleList.put("scheduleListC", scheduleListC);
		
		
		List<ScheduleInfo> scheduleInfoListD=getScheduleInfoByType(4, scheduleInfos);
		List<SchedulePaperDto> scheduleListD=new ArrayList<SchedulePaperDto>();
		SetMark setMarkD=getQuestionMark(4, setMarks);
		for(int i=0;i<scheduleInfoListD.size();i++){
			SchedulePaperDto schedulePaper=new SchedulePaperDto();
			ScheduleInfo scheduleInfo=scheduleInfoListD.get(i);
			schedulePaper.setOrder(scheduleInfo.getOrders());
			schedulePaper.setMark(setMarkD.getMark());
			schedulePaper.setIndicator(scheduleInfo.getIndicator());
			schedulePaper.setIndicatorlevel(scheduleInfo.getIndicatorLevel());
			scheduleListA.add(schedulePaper);
		}
		scheduleList.put("scheduleListD", scheduleListD);
		
		List<IndicatorDto> indicatorDtos=getScheduleIndicator(scheduleListA,scheduleListB,scheduleListC,scheduleListD);
		
		scheduleList.put("scheduleInfoList", indicatorDtos);
		Integer tlevel1=0;
		Integer tlevel2=0;
		Integer tlevel3=0;
		Integer tlevel4=0;
		for(int i=0;i<indicatorDtos.size();i++){
			IndicatorDto temp=indicatorDtos.get(i);
			tlevel1+=temp.getLevel1();
			tlevel2+=temp.getLevel2();
			tlevel3+=temp.getLevel3();
			tlevel4+=temp.getLevel4();
		}
		System.out.println(tlevel1);
		System.out.println(tlevel2);
		System.out.println(tlevel3);
		System.out.println(tlevel4);
		scheduleList.put("tlevel1",tlevel1);
		scheduleList.put("tlevel2",tlevel2);
		scheduleList.put("tlevel3",tlevel3);
		scheduleList.put("tlevel4",tlevel4);
		
		scheduleList.put("count1", setMarkA.getCount());
		scheduleList.put("mark1", setMarkA.getMark());
		
		scheduleList.put("count2", setMarkB.getCount());
		scheduleList.put("mark2", setMarkB.getMark());
		
		scheduleList.put("count3", setMarkC.getCount());
		scheduleList.put("mark3", setMarkC.getMark());
		
		scheduleList.put("count4", setMarkD.getCount());
		scheduleList.put("mark4", setMarkD.getMark());
		
		scheduleList.put("totalc", setMarkA.getCount()+setMarkB.getCount()+setMarkC.getCount()+setMarkD.getCount());
		scheduleList.put("totalm", setMarkA.getCount()*setMarkA.getMark()+setMarkB.getCount()*setMarkB.getMark()+setMarkC.getCount()*setMarkC.getMark()+setMarkD.getCount()*setMarkD.getMark());
		SchedulePaper schedulePaper=new SchedulePaper();
		try{
			File file=Paper_Word.createDoc(scheduleList,"testS");
			schedulePaper.setContent(file.getAbsolutePath());
			schedulePaper.setScheduleid(scheduleId);
			schedulePaperDao.insertSelective(schedulePaper);
		}catch(Exception e){
			
		}
		return schedulePaper;
	}
	
	//获取不同题型的赋分方案
		private SetMark getQuestionMark(Integer number,List<SetMark> setMarks){
			SetMark setMark=null;
			for(SetMark setMarkt:setMarks){
				if(setMarkt.getType()==number){
					setMark=setMarkt;
					break;
				}
			}
			return setMark;
		}
		//获取每种题型的详细指标方案
		private List<ScheduleInfo> getScheduleInfoByType(Integer type,List<ScheduleInfo> scheduleInfos){
			List<ScheduleInfo> scheduleInfosa=new ArrayList<ScheduleInfo>();
			for(ScheduleInfo scheduleInfo:scheduleInfos){
				if(type==scheduleInfo.getType()){
					scheduleInfosa.add(scheduleInfo);
				}
			}
			return scheduleInfosa;
		}
		//获取指标点分值的占比
		private List<IndicatorDto> getScheduleIndicator(List<SchedulePaperDto> A,List<SchedulePaperDto> B,List<SchedulePaperDto> C,List<SchedulePaperDto> D){
			Map<String,Map<Integer,Integer>> indicatorMap=new TreeMap<String,Map<Integer,Integer>>();
			for(int i=0;i<A.size();i++){
				Map<Integer,Integer> indicatorLevelMap=new TreeMap<Integer,Integer>(); 
				indicatorLevelMap.put(1, 0);
				indicatorLevelMap.put(2, 0);
				indicatorLevelMap.put(3, 0);
				SchedulePaperDto schedulePaperDto=A.get(i);
				if(indicatorMap.get(schedulePaperDto.getIndicator())!=null){
					 if((indicatorMap.get(schedulePaperDto.getIndicator()).get(schedulePaperDto.getIndicatorlevel())!=null))
						 indicatorMap.get(schedulePaperDto.getIndicator()).put(schedulePaperDto.getIndicatorlevel(), indicatorMap.get(schedulePaperDto.getIndicator()).get(schedulePaperDto.getIndicatorlevel())+1);
					 else
						 indicatorMap.get(schedulePaperDto.getIndicator()).put(schedulePaperDto.getIndicatorlevel(),1);
				}else{
					    indicatorMap.put(schedulePaperDto.getIndicator(),indicatorLevelMap);
				}
			}
			for(int i=0;i<B.size();i++){
				Map<Integer,Integer> indicatorLevelMap=new TreeMap<Integer,Integer>(); 
				indicatorLevelMap.put(1, 0);
				indicatorLevelMap.put(2, 0);
				indicatorLevelMap.put(3, 0);
				SchedulePaperDto schedulePaperDto=B.get(i);
				if(indicatorMap.get(schedulePaperDto.getIndicator())!=null){
					 if((indicatorMap.get(schedulePaperDto.getIndicator()).get(schedulePaperDto.getIndicatorlevel())!=null))
						 indicatorMap.get(schedulePaperDto.getIndicator()).put(schedulePaperDto.getIndicatorlevel(), indicatorMap.get(schedulePaperDto.getIndicator()).get(schedulePaperDto.getIndicatorlevel())+1);
					 else
						 indicatorMap.get(schedulePaperDto.getIndicator()).put(schedulePaperDto.getIndicatorlevel(),1);
				}else{
					    indicatorMap.put(schedulePaperDto.getIndicator(),indicatorLevelMap);
				}
			}
			for(int i=0;i<C.size();i++){
				Map<Integer,Integer> indicatorLevelMap=new TreeMap<Integer,Integer>(); 
				indicatorLevelMap.put(1, 0);
				indicatorLevelMap.put(2, 0);
				indicatorLevelMap.put(3, 0);
				SchedulePaperDto schedulePaperDto=C.get(i);
				if(indicatorMap.get(schedulePaperDto.getIndicator())!=null){
					 if((indicatorMap.get(schedulePaperDto.getIndicator()).get(schedulePaperDto.getIndicatorlevel())!=null))
						 indicatorMap.get(schedulePaperDto.getIndicator()).put(schedulePaperDto.getIndicatorlevel(), indicatorMap.get(schedulePaperDto.getIndicator()).get(schedulePaperDto.getIndicatorlevel())+1);
					 else
						 indicatorMap.get(schedulePaperDto.getIndicator()).put(schedulePaperDto.getIndicatorlevel(),1);
				}else{
					    indicatorMap.put(schedulePaperDto.getIndicator(),indicatorLevelMap);
				}
			}
			
			for(int i=0;i<D.size();i++){
				Map<Integer,Integer> indicatorLevelMap=new TreeMap<Integer,Integer>(); 
				indicatorLevelMap.put(1, 0);
				indicatorLevelMap.put(2, 0);
				indicatorLevelMap.put(3, 0);
				SchedulePaperDto schedulePaperDto=D.get(i);
				if(indicatorMap.get(schedulePaperDto.getIndicator())!=null){
					 if((indicatorMap.get(schedulePaperDto.getIndicator()).get(schedulePaperDto.getIndicatorlevel())!=null))
						 indicatorMap.get(schedulePaperDto.getIndicator()).put(schedulePaperDto.getIndicatorlevel(), indicatorMap.get(schedulePaperDto.getIndicator()).get(schedulePaperDto.getIndicatorlevel())+1);
					 else
						 indicatorMap.get(schedulePaperDto.getIndicator()).put(schedulePaperDto.getIndicatorlevel(),1);
				}else{
					    indicatorMap.put(schedulePaperDto.getIndicator(),indicatorLevelMap);
				}
			}
			List<IndicatorDto> indicatorDtos=new ArrayList<IndicatorDto>();
			for (Object o : indicatorMap.keySet()) { 
				IndicatorDto indicatorDto=new IndicatorDto();
				indicatorDto.setIndicator((String)o);
				Map<Integer,Integer> map=indicatorMap.get(o);
				indicatorDto.setLevel1(map.get(1));
				indicatorDto.setLevel2(map.get(2));
				indicatorDto.setLevel3(map.get(3));
				indicatorDto.setLevel4(map.get(1)+map.get(2)+map.get(3));
				indicatorDtos.add(indicatorDto);
			}  
			
			return indicatorDtos;
		}

}
