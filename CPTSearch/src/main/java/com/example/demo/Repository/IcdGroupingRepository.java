package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.IcdGrouping;

@Repository
public interface IcdGroupingRepository extends JpaRepository<IcdGrouping, Integer> {

	
	@Query(value="CALL icdGroupingSearch(:icdIdSearch)",nativeQuery=true)
	List<IcdGrouping> icdGroupingSearch(Integer icdIdSearch);
	
	
	
	
	
	/* @Query(nativeQuery = true, value = 
		        "DROP TEMPORARY TABLE IF EXISTS temp_table; " +
		        "CREATE TEMPORARY TABLE temp_table( " +
		        "    id INT, " +
		        "    icd_id INT, " +
		        "    parent_id INT, " +
		        "    icd_code VARCHAR(10), " +
		        "    long_desc VARCHAR(500), " +
		        "    type VARCHAR(15), " +
		        "    level INT " +
		        "); " +
		        "SET @level = 0; " +
		        "SET @current_id = :icdIdSearch; " +
		        "WHILE @current_id IS NOT NULL DO " +
		        "    INSERT INTO temp_table " +
		        "    SELECT icd10codes.id, icd10codes.icd_id, icd10.parent_id, icd10codes.icd_code, icd10codes.long_desc, icd10codes.type, @level " +
		        "    FROM icd10codes " +
		        "    LEFT JOIN icd10cm_hier_2022 AS icd10 ON icd10codes.icd_id = icd10.icd_id " +
		        "    WHERE icd10codes.icd_id = @current_id; " +
		        "    SET @current_id = (SELECT parent_id FROM icd10cm_hier_2022 WHERE icd_id = @current_id); " +
		        "    SET @level = @level + 1; " +
		        "END WHILE; " +
		        "SET @max_level = (SELECT MAX(level) FROM temp_table); " +
		        "UPDATE temp_table SET level = @max_level - level; " +
		        "SET @parent_id = (SELECT parent_id FROM icd10cm_hier_2022 WHERE icd_id = :icdIdSearch); " +
		        "INSERT INTO temp_table " +
		        "SELECT icd10codes.id, icd10codes.icd_id, icd10.parent_id, icd10codes.icd_code, icd10codes.long_desc, icd10codes.type, @max_level " +
		        "FROM icd10codes " +
		        "LEFT JOIN icd10cm_hier_2022 AS icd10 ON icd10codes.icd_id = icd10.icd_id " +
		        "WHERE icd10.parent_id = @parent_id AND icd10codes.icd_id <> :icdIdSearch; " +
		        "SELECT * FROM temp_table ORDER BY level, icd_code;"
		    )
	List<IcdGrouping> icdGroupingSearch(Integer icdIdSearch);*/

}


