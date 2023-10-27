package com.biblioteca.repo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.biblioteca.entity.Membro;

@Repository
public class MembroRepo {

	private final Map<Long, Membro> membroListMap = new HashMap<>();
	private Long currentId = 1L;

	public Membro addMembro(Membro membro) {
		membro.setId(currentId++);
		
		membroListMap.put(membro.getId(), membro);
		return membro;
	}

	public Collection<Membro> getAllMembro() {
		return membroListMap.values();
	}

	public Membro getMembroById(Long id) {
		return membroListMap.get(id);
	}

	public Membro updateMembro(Long id, Membro membro) {
		if (membroListMap.containsKey(id)) {
			membro.setId(id);
			membroListMap.put(id, membro);
			return membro;
		}
		return null;
	}

	public void deleteMembro(Long id) {
		membroListMap.remove(id);
	}

}
