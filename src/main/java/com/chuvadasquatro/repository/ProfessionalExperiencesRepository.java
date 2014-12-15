package com.chuvadasquatro.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.odftoolkit.simple.text.list.ListItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chuvadasquatro.datasource.ODFDataSource;
import com.chuvadasquatro.domain.Achievements;
import com.chuvadasquatro.domain.ProfessionalExperiences;
import com.chuvadasquatro.domain.ProfessionalExperiencesItem;
import com.chuvadasquatro.domain.Tasks;

@Repository
public class ProfessionalExperiencesRepository {
	@Autowired
	private ODFDataSource dataSource;

	public ProfessionalExperiences getProfessionalExperiences() {
		List<ProfessionalExperiencesItem> professionalExperiences = new ArrayList<ProfessionalExperiencesItem>();
		List<String> detailsList;
		Tasks tasks = null;
		Achievements achievements = null;

		Iterator<org.odftoolkit.simple.text.list.List> descriptionIterator = dataSource.getListIterator("experiences");
		while (descriptionIterator.hasNext()) {
			for (ListItem description : descriptionIterator.next().getItems()) {
				detailsList = new ArrayList<String>();
				Iterator<org.odftoolkit.simple.text.list.List> detailsIterator = dataSource.getListIterator(description);
				while (detailsIterator.hasNext()) {
					for (ListItem details : detailsIterator.next().getItems()) {
						if ("Tasks:".equals(details.getTextContent())) {
							tasks = new Tasks(dataSource.getData(dataSource.getListIterator(details)));
						} else if ("Achievements:".equals(details.getTextContent())) {
							achievements = new Achievements(dataSource.getData(dataSource.getListIterator(details)));
						} else {
							detailsList.add(details.getTextContent());
						}
					}
				}
				professionalExperiences.add(new ProfessionalExperiencesItem(
						description.getTextContent(),
						detailsList,
						tasks,
						achievements
				));
			}
		}

		return new ProfessionalExperiences(professionalExperiences);
	}
}
