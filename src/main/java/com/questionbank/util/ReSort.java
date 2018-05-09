package com.questionbank.util;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.questionbank.domain.ScheduleInfo;

public class ReSort {
	public static void sortIntMethod(List<ScheduleInfo> list){
		Collections.sort(list,new Comparator<Object>() {

			public int compare(Object o1, Object o2) {
				// TODO Auto-generated method stub
				ScheduleInfo s1=(ScheduleInfo)o1;
				ScheduleInfo s2=(ScheduleInfo)o2;
				if(s1.getOrders()>s2.getOrders()){
					return 1;
				}else if(s1.getOrders()==s2.getOrders()){
					return 0;
				}else{
					return -1;
				}
			}
			
			
		});
		
	}
}
