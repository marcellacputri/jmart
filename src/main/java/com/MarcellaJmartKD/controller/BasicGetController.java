package com.MarcellaJmartKD.controller;

import com.MarcellaJmartKD.dbjson.Serializable;
import com.MarcellaJmartKD.dbjson.JsonTable;
import com.MarcellaJmartKD.Algorithm;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Write a description of class Complaint here.
 *
 * @author (Marcella Cinninthya Putri)
 * @version (20/11/2021)
 */


@RestController
public interface BasicGetController <T extends Serializable>{
	@GetMapping("/page")
	default @ResponseBody List<T> getPage(@RequestParam(defaultValue="1") int page, @RequestParam(defaultValue="5") int pageSize){
        return Algorithm.<T>paginate(getJsonTable(),page,pageSize,e -> true);
	}
	
	@GetMapping("/id")
	 default T getById(int id) {
        return Algorithm.<T>find(getJsonTable(), (e) -> e.id==id);
    }
	
	 
	public abstract JsonTable <T> getJsonTable();
		
}

