package com.chuvadasquatro.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.odftoolkit.simple.text.list.ListItem;
import org.springframework.stereotype.Repository;

import com.chuvadasquatro.datasource.ODFDataSource;
import com.chuvadasquatro.domain.Education;
import com.chuvadasquatro.domain.EducationItem;

@Repository
public class EducationRepository {
	public Education getEducation() {
		List<EducationItem> education = new ArrayList<EducationItem>();

		Iterator<org.odftoolkit.simple.text.list.List> descriptionIterator = ODFDataSource.getListIterator("education");
		while (descriptionIterator.hasNext()) {
			for (ListItem description : descriptionIterator.next().getItems()) {
				education.add(new EducationItem(
						description.getTextContent(),
						ODFDataSource.getData(ODFDataSource.getListIterator(description))
				));
			}
		}

		return new Education(education);
	}
}
