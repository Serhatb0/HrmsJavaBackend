package hrms.javaBackend.dataAccess.abstracts;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import hrms.javaBackend.entities.concretes.JobPostings;

public interface JobPostingsDao extends JpaRepository<JobPostings, Integer> {
	List<JobPostings> getAllByEmployer_Id(int employerId); // Sistemde bir firmaya ait tüm İş İlanları Gosterir

	JobPostings getAllByjobPostingsIdAndEmployer_Id(int jobPostingsId, int employerId);

	List<JobPostings> getAllByApplicationDeadlineLessThanEqual(LocalDate date); // Sistemdeki tüm aktif iş ilanları
																				// tarihe göre listeler.

	List<JobPostings> getAllByisActive(Boolean isActive); // Sistemdeki tüm aktif iş ilanları Gosterir

	List<JobPostings> getAllByisActiveIsNull();

	JobPostings getAllByjobPostingsId(int jobPostingsId);

	List<JobPostings> getAllByCity_cityName(String cityName);

	@Query("SELECT j FROM JobPostings  j WHERE j.minSalary>=:min and j.maxSalary >=:max ")
	List<JobPostings> getMinSalaryAndMaxSalary(@Param("min")int min, @Param("max") int max);

	List<JobPostings> findBycreatedDateLessThanEqual(Date currentDate);

}
