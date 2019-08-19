package com.cognizant.fse.service;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cognizant.fse.eo.ParentTaskEO;
import com.cognizant.fse.repository.MasterTaskRepository;
import com.cognizant.fse.service.MasterTaskService;
public class MasterTaskServiceTest {

	 @InjectMocks
	    MasterTaskService service;
	     
	    @Mock
	    MasterTaskRepository repo;
	 
	    @Before
	    public void init() {
	        MockitoAnnotations.initMocks(this);
	    }
	     

	@Test
	    public void addNewTest()
	    {
		ParentTaskEO ptask = new ParentTaskEO();
		String task="parentTask";
		
		ptask.setParentTask(task);			  
		   when(service.addNew(task)).thenReturn(ptask);
		   when(repo.save(ptask)).thenReturn(ptask);
	     
	        
	         
	         verify(repo, times(0)).save(ptask);
	    }  

	    

	     
	    @Test
	    public void findAllTest()
	    {
	        List<ParentTaskEO> list = new ArrayList<ParentTaskEO>();
	        ParentTaskEO taskOne = new ParentTaskEO (1, "ParentTask1");
	        ParentTaskEO taskTwo = new ParentTaskEO (2, "ParentTask2");
	        ParentTaskEO taskThree = new ParentTaskEO (3, "ParentTask3");
	       
	        list.add(taskOne);
	        list.add(taskTwo);
	        list.add(taskThree);
	         
	        when(repo.findAll()).thenReturn(list);
	      
	        Iterable<ParentTaskEO> taskList = service.getAllUsers();
	         
	        assertEquals(3, ((List<ParentTaskEO>) taskList).size());
	        verify(repo, times(1)).findAll();
	    }

	    
	    @Test
	    
	    public void setParentIdTest()
		{
			ParentTaskEO ptask = new ParentTaskEO();
			ptask.setParentId(12);
		}
	 
}
