package de.tekup.recipe.services;

import java.util.List;

import org.springframework.stereotype.Service;

import de.tekup.recipe.data.entities.UnitOfMeasure;
import de.tekup.recipe.data.repositories.UnitOfMeasureRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UnitOfMeasureServiceImpl implements UnitOfMeasureService {

	private UnitOfMeasureRepository uomRepos;
	@Override
	public List<UnitOfMeasure> getUnitOfMeasures() {
		
		return uomRepos.findAll();
	}

}
