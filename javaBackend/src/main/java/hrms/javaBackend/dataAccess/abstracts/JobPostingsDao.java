package hrms.javaBackend.dataAccess.abstracts;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import hrms.javaBackend.entities.concretes.JobPostings;
import hrms.javaBackend.entities.dtos.JobPostingsFilter;

public interface JobPostingsDao extends JpaRepository<JobPostings, Integer> {
	List<JobPostings> getAllByEmployer_Id(int employerId); // Sistemde bir firmaya ait tüm İş İlanları Gosterir

	JobPostings getAllByjobPostingsIdAndEmployer_Id(int jobPostingsId, int employerId);

	List<JobPostings> getAllByApplicationDeadlineLessThanEqual(LocalDate date); // Sistemdeki tüm aktif iş ilanları
																				// tarihe göre listeler.

	Page<JobPostings> getAllByisActive(Pageable pageable,Boolean isActive); 

	Page<JobPostings> getAllByisActiveIsNull(Pageable pageable);

	
	JobPostings getAllByjobPostingsId(int jobPostingsId);

	List<JobPostings> getAllByCity_cityName(String cityName);

	@Query("SELECT j FROM JobPostings  j WHERE j.minSalary>=:min and j.maxSalary <=:max ")
	List<JobPostings> getMinSalaryAndMaxSalary(@Param("min")int min, @Param("max") int max);
	
	
	@Query("SELECT j FROM JobPostings  j WHERE j.minSalary>=:min and j.maxSalary >=:max and j.city.cityId = :cityId ")
	List<JobPostings> getDene(@Param("min")int min, @Param("max") int max, @Param("cityId") int cityId);
	
	

	List<JobPostings> findBycreatedDateLessThanEqual(Date currentDate);
	
	
	  @Query("Select j from hrms.javaBackend.entities.concretes.JobPostings j where ((:#{#filter.cityId}) IS NULL OR j.city.cityId IN (:#{#filter.cityId}))"
		        +" and ((:#{#filter.jobPositionId}) IS NULL OR j.jobPosition.id IN (:#{#filter.jobPositionId}))"
		       +"and j.minSalary>=:min and j.maxSalary <=:max"
		        +" and j.isActive=true")
		     Page<JobPostings> getByAllFilter(@Param("filter") JobPostingsFilter jobPostingsFilter, Pageable pageable ,@Param("min")int min, @Param("max") int max);

	

	


}
