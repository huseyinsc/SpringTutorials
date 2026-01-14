package com.huseyinsacikay.services.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huseyinsacikay.dto.DtoHome;
import com.huseyinsacikay.dto.DtoRoom;
import com.huseyinsacikay.entities.Home;
import com.huseyinsacikay.entities.Room;
import com.huseyinsacikay.repository.HomeRepository;
import com.huseyinsacikay.services.IHomeService;

@Service
public class HomeServiceImpl implements IHomeService{
	@Autowired
	private HomeRepository homeRepository;

	@Override
	public DtoHome findHomeById(Long id) {
		Optional<Home> optional = homeRepository.findById(id);
		if(optional.isEmpty()) {
			return null;
		}
		Home home = optional.get();
		List<Room> rooms = home.getRoom();
		
		DtoHome dtoHome = new DtoHome();
		List<DtoRoom> dtoRooms = new ArrayList<>();
		
		BeanUtils.copyProperties(home, dtoHome);
		if(rooms != null && !rooms.isEmpty()) {
			for (Room room : rooms) {
				DtoRoom dtoRoom =  new DtoRoom();
				BeanUtils.copyProperties(room, dtoRoom);
				dtoRooms.add(dtoRoom);
			}
		}
		
		dtoHome.setRooms(dtoRooms);
		return dtoHome;
	}
	
}
