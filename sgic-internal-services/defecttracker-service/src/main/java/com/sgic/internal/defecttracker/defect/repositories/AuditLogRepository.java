package com.sgic.internal.defecttracker.defect.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sgic.internal.defecttracker.defect.entities.AuditLog;
import com.sgic.internal.defecttracker.defect.entities.Defect;

@Repository
@Transactional
public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {

	@Query("SELECT c FROM AuditLog c WHERE c.defect.id= :defectId")
	List<AuditLog> findCommentsByDefectId(@Param("defectId") String defectId);
	
	List<AuditLog> findByDefect(Defect defect);
}
